package org.fases;

import org.instrucoes.Instrucao;

public abstract class FasePadrao implements Fase {

	private Instrucao instrucaoAtual;

	public String getNomeFase(){
			return this.getClass().getName();
	}

	@Override
	public void receber(Instrucao ins) {
		//System.out.println(this + " recebendo instrucao " + ins);
		this.instrucaoAtual = ins;

	}

	@Override
	public void executar() {
		System.out.println(this + " executando instrucao " + instrucaoAtual);

	}

	@Override
	public Instrucao passarInstrucao() {
		//System.out.println(this + " passando instrucao " + instrucaoAtual);
		return this.instrucaoAtual;
	}

	@Override
	public boolean isReady() {
		return true;
	}

}
