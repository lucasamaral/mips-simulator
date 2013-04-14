package org;

import org.fases.Executer;
import org.fases.Fase;
import org.fases.InstructionFetch;
import org.fases.MemoryAccess;
import org.fases.RegisterDecoder;
import org.fases.WriteBack;
import org.instrucoes.Instrucao;

public class Processador {
	private Memoria memoria;
	private Instrucao[] instrucoes;
	private Fase[] fases;

	public Processador(Memoria memoria, String[] instrucoes) {
		this.memoria = memoria;
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
			inst[i] = gerarInstrucao(novasInstrucoes[i]);
		}
		return inst;
	}

	private Instrucao gerarInstrucao(String instrucao) {
		// TODO Auto-generated method stub
		return null;
	}

	public void step() {

	}

	public boolean isFinished() {
		return true;
	}

	public void processar() {
		while (!isFinished()) {
			step();
		}
	}

}
