package org;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;
import org.latches.LatchIFID;
import org.latches.LatchMEMWB;

public class Processador {

	private CentralSinais centralSinais;
	private int pc;
	private Map<Integer, Integer> dependencias = new HashMap<>();
	private MemoriaDados memoria;
	private BancoDeRegistradores registradores;
	private MemoriaInstrucoes instrucoes;
	private int clockCount = 0;
	private List<InstrucaoWrapper> instrucoesCompletadas = new LinkedList<>();
	private LatchIFID ifId;
	private LatchIDEX idEx;
	private LatchEXMEM exMem;
	private LatchMEMWB memWb;
	private Fase[] fases;
	private boolean fimDePrograma = false;
	private boolean temDependencia;

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
		for (Integer registrador : dependencias.keySet()) {
			dependencias.put(registrador, dependencias.get(registrador) - 1);
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
			if (dependencias.containsKey(p) && dependencias.get(p) > 0){
				System.out.println("Opa, tem dependencia");
				temDependencia = true;
				return true;
			}
		}
		temDependencia = false;
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
		if(!temDependencia)
			pc = pc + 4;
		else
			temDependencia = false;
	}

	public void gerarLog() {
		Charset encoding = StandardCharsets.UTF_8;
		Path path = Paths.get("Saida-programa.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path, encoding)) {
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
		ifId.limpar();
		idEx.limpar();
		exMem.limpar();
		setPc(proximoEndereco);
	}

	public void notificarEntrada(InstrucaoWrapper instrucaoAtual) {
		if (instrucaoAtual.getDependenciasWrite().size() > 0) {
			switch (instrucaoAtual.getCodigo()) {
			case LW:
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						4);
			default:
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						4);
			}
		}
	}

}
