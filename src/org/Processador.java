package org;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.fases.Executer;
import org.fases.Fase;
import org.fases.InstructionFetch;
import org.fases.MemoryAccess;
import org.fases.RegisterDecoder;
import org.fases.WriteBack;
import org.instrucoes.InstrucaoWrapper;
import org.instrucoes.Rtype.InstrucaoNop;
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;
import org.latches.LatchIFID;
import org.latches.LatchMEMWB;

public class Processador {

	protected CentralSinais centralSinais;
	protected int pc;
	protected Map<Integer, List<InstrucaoWrapper>> dependencias = new HashMap<>();
	protected MemoriaDados memoria;
	protected BancoDeRegistradores registradores;
	protected MemoriaInstrucoes instrucoes;
	protected int clockCount = 0;
	protected List<InstrucaoWrapper> instrucoesCompletadas = new LinkedList<>();
	protected LatchIFID ifId;
	protected LatchIDEX idEx;
	protected LatchEXMEM exMem;
	protected LatchMEMWB memWb;
	protected Fase[] fases;
	protected boolean fimDePrograma = false;
	protected boolean temDependencia;
	protected Map<InstrucaoWrapper, Integer> dependenciasInstrucoes = new HashMap<>();

	public Processador(MemoriaDados mem, MemoriaInstrucoes ins) {
		this.memoria = (mem);
		this.registradores = (new BancoDeRegistradores());
		this.instrucoes = (ins);
		setPc(0);
		construirLatches();
		fases = construirFases();
	}

	public void adicionarInstrucaoCompletada(InstrucaoWrapper inst) {
		if (inst != null)
			instrucoesCompletadas.add(inst);
		else {
			InstrucaoWrapper ins = new InstrucaoWrapper("");
			ins.setInstrucaoReal(new InstrucaoNop("000000000000000000000000"));
			instrucoesCompletadas.add(ins);
		}

	}

	private void construirLatches() {
		ifId = new LatchIFID();
		idEx = new LatchIDEX();
		exMem = new LatchEXMEM();
		memWb = new LatchMEMWB();
	}

	private Fase[] construirFases() {
		Fase[] res = new Fase[5];
		res[0] = new InstructionFetch(this, ifId);
		res[1] = new RegisterDecoder(this, ifId, idEx);
		res[2] = new Executer(this, idEx, exMem);
		res[3] = new MemoryAccess(this, exMem, memWb);
		res[4] = new WriteBack(this, memWb);
		return res;
	}

	public void step() {
		for (InstrucaoWrapper registrador : dependenciasInstrucoes.keySet()) {
			dependenciasInstrucoes.put(registrador,
					dependenciasInstrucoes.get(registrador) - 1);
		}
		for (Fase f : fases) {
			f.carregarSinais();
		}
		for (Fase f : fases) {
			f.executarPasso1();
		}
		for (Fase f : fases) {
			System.out.println(f + " -" + f.getInstrucaoAtual());
			f.executarPasso2();
		}
		clockCount++;
		System.out.println(pc);
	}

	public boolean isFinished() {
		for (Fase f : fases) {
			if (!f.isReady() || f.isWorking())
				return false;
		}
		return !idEx.hasInstruction() && !exMem.hasInstruction()
				&& !memWb.hasInstruction() && !ifId.hasInstruction()
				&& pc >= instrucoes.limiteInstrucoes();
	}

	public void processar() {
		do {
			step();
			System.out.println("");
		} while (!isFinished());
	}

	public MemoriaInstrucoes getInstrucoes() {
		return instrucoes;
	}

	public void sinalizarFimdePrograma() {
		this.fimDePrograma = true;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public boolean temDependencia(InstrucaoWrapper instrucaoAtual) {
		for (Integer p : instrucaoAtual.getDependenciasRead()) {
			if (existeDependencia(p)) {
				System.out.println("Opa, tem dependencia");
				temDependencia = true;
				return true;
			}
		}
		temDependencia = false;
		return false;
	}

	protected boolean existeDependencia(int end) {
		if(dependencias.containsKey(end)){
			for(InstrucaoWrapper ins : dependencias.get(end)){
				if(dependenciasInstrucoes.get(ins)>0)
					return true;
			}
		}
		return false;
	}

	public void carregarNaMemoria(int endereco, int valor) {
		memoria.setValue(endereco, valor);
	}

	public void carregarNosRegistradores(String cod, int valor) {
		registradores.writeRegister(cod, valor);
	}

	public int pegarDaMemoria(int endereco) {
		return memoria.getValue(endereco);
	}

	public int pegardosRegistradores(String endereco) {
		return registradores.readRegister(endereco);
	}

	public void incrementarPC() {
		if (!temDependencia)
			pc = pc + 4;
		else
			temDependencia = false;
	}

	public void gerarLog() {
		Charset encoding = StandardCharsets.UTF_8;
		Path path = Paths.get("Saida-programa.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path, encoding)) {
			writer.write("Numero de clocks: " + clockCount);
			writer.newLine();
			writer.write("Instrucoes executadas:");
			writer.newLine();
			for (InstrucaoWrapper line : instrucoesCompletadas) {
				writer.write(line.toString());
				writer.newLine();
			}
			writer.newLine();
			writer.write("Estado final da memoria:");
			writer.newLine();
			for (int end : memoria.getEnderecosUtilizados()) {
				writer.write("" + end + " - " + memoria.getValue(end));
				writer.newLine();
			}
			writer.newLine();
			writer.write("Estado final dos registradores:");
			writer.newLine();
			for (int end = 0; end < 32; end++) {
				writer.write(""
						+ end
						+ " - "
						+ registradores.readRegister(Integer
								.toBinaryString(end)));
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public void executarSalto(int proximoEndereco) {
		dependenciasInstrucoes.remove(ifId.pegarInstrucao());
		ifId.limpar();
		dependenciasInstrucoes.remove(idEx.pegarInstrucao());
		idEx.limpar();
		dependenciasInstrucoes.remove(exMem.pegarInstrucao());
		exMem.limpar();
		setPc(proximoEndereco);
	}

	public void notificarEntrada(InstrucaoWrapper instrucaoAtual) {
		instrucaoAtual.setClockEntrada(pc);
		if (instrucaoAtual.getDependenciasWrite().size() > 0) {
			if (!dependencias.containsKey(instrucaoAtual.getDependenciasWrite()
					.get(0))) {
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						new ArrayList<InstrucaoWrapper>());
			}
			dependencias.get(instrucaoAtual.getDependenciasWrite().get(0)).add(
					instrucaoAtual);
			dependenciasInstrucoes.put(instrucaoAtual, 4);

		}
	}

	public void naoIncrementarPc() {
		temDependencia = true;
	}

}
