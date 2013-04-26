package org.instrucoes;

import org.BancoDeRegistradores;

public class InstrucaoWrapper {

	private String dado;
	private Instrucao instrucao;
	
	public InstrucaoWrapper(String dado){
		this.dado = dado;
	}

	public String getDado() {
		return dado;
	}

	public CodigoInstrucao getCodigo() {
		if(instrucao!=null)
			return instrucao.codigo;
		return CodigoInstrucao.NOP;
	}
	
	public String toString(){
		return getCodigo().name();
	}

	public Instrucao getInstrucao() {
		return instrucao;
	}

	public void setInstrucaoReal(Instrucao instrucaoReal) {
		this.instrucao = instrucaoReal;
	}

	public TipoInstrucao getType() {
		return instrucao.getType();
	}

	public void writeBack(BancoDeRegistradores banco, int valorULA, int valorMEM) {
		instrucao.writeBack(banco, valorULA,valorMEM);
	}

	public boolean isBranch() {
		return instrucao.isBranch();
	}
	
}