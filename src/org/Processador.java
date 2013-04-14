package org;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.conversorInstrucoes.ConversorInstrucoes;
import org.fases.Executer;
import org.fases.Fase;
import org.fases.InstructionFetch;
import org.fases.MemoryAccess;
import org.fases.RegisterDecoder;
import org.fases.WriteBack;
import org.instrucoes.Instrucao;

public class Processador {
	private Memoria memoria;
	private BancodeRegistradores registradores;
	private Instrucao[] instrucoes;
	private Queue<Instrucao> instrucoesRestantes = new LinkedList<>();
	private List<Instrucao> instrucoesCompletadas = new LinkedList<>();
	private Fase[] fases;

	public Processador(Memoria mem, String[] instrucoes) {
		this.memoria = mem;
		this.registradores = new BancodeRegistradores();
		this.instrucoes = carregarInstrucoes(instrucoes);
		fases = construirFases();
	}

	private Fase[] construirFases() {
		Fase[] res = new Fase[5];
		res[0] = new InstructionFetch();
		res[1] = new RegisterDecoder();
		res[2] = new Executer();
		res[3] = new MemoryAccess();
		res[4] = new WriteBack();
		return res;
	}

	private Instrucao[] carregarInstrucoes(String[] novasInstrucoes) {
		Instrucao[] inst = new Instrucao[novasInstrucoes.length];
		for (int i = 0; i < novasInstrucoes.length; i++) {
			inst[i] = ConversorInstrucoes
					.converterInstrucao(novasInstrucoes[i]);
			instrucoesRestantes.add(inst[i]);
		}
		return inst;
	}

	public void step() {
		boolean pronto = true;
		for (Fase f : fases) {
			if (!f.isReady()) {
				pronto = false;
			}
		}
		if (pronto) {
			passarInstrucoes();
		}
		for (Fase f : fases) {
			f.executar();
		}
		System.out.println("");
	}

	private void passarInstrucoes() {
		Instrucao prox = pegarProximaInstrucao();
		for (Fase f : fases) {
			Instrucao temp = f.passarInstrucao();
			f.receber(prox);
			prox = temp;
		}
		if(prox!=null)
			instrucoesCompletadas.add(prox);
	}

	private Instrucao pegarProximaInstrucao() {
		return instrucoesRestantes.poll();
	}

	public boolean isFinished() {
		if(!instrucoesRestantes.isEmpty()){
			return false;
		}
		for(Fase f: fases){
			if(!f.isReady())
				return false;
		}
		return instrucoesCompletadas.size() == instrucoes.length;
	}

	public void processar() {
		while (!isFinished()) {
			step();
		}
	}

}
