package org.instrucoes;

public class InstrucaoWrapper {

	private String dado;
	private Instrucao instrucao;
	
	public InstrucaoWrapper(String dado){
		this.dado = dado;
	}

	public String getDado() {
		return dado;
	}

	public TipoInstrucao getTipo() {
		if(instrucao!=null)
			return instrucao.tipo;
		return TipoInstrucao.NOP;
	}
	
	public String toString(){
		return getTipo().name();
	}

	public Instrucao getInstrucao() {
		return instrucao;
	}

	public void setInstrucaoReal(Instrucao instrucaoReal) {
		this.instrucao = instrucaoReal;
	}
	
}