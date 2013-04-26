package org.instrucoes;

import org.Processador;

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

	public void writeBack(Processador proc, int valorULA, int valorMEM) {
		instrucao.writeBack(proc, valorULA,valorMEM);
	}

	public boolean isBranch() {
		return instrucao.isBranch();
	}

	public int getResultadoULA(Processador proc) {
		return instrucao.getResultadoULA(proc);
	}

	public boolean getCondicaoULA(Processador proc) {
		return instrucao.getCondicaoULA(proc);
	}

	public int getResultadoULAEndereco(Processador proc) {
		return instrucao.getResultadoULAEndereco(proc);
	}
	
}