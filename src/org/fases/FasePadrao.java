package org.fases;

import org.Processador;
import org.instrucoes.InstrucaoWrapper;

public abstract class FasePadrao implements Fase {

	protected InstrucaoWrapper instrucaoAtual;
	protected Processador processador;

	public FasePadrao(Processador p) {
		processador = p;
	}

	public String getNomeFase() {
		return this.getClass().getName();
	}

	public Processador getProcessador() {
		return this.processador;
	}

	@Override
	public boolean isReady() {
		return true;
	}

	public boolean isWorking() {
		return instrucaoAtual != null;
	}

}
