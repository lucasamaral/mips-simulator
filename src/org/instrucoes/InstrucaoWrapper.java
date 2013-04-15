package org.instrucoes;

public class InstrucaoWrapper {

	private String dado;
	private String Instrucao;
	private TipoInstrucao tipo = TipoInstrucao.NOP;
	
	public InstrucaoWrapper(String dado){
		this.dado = dado;
	}
	
	public String getInstrucao() {
		return Instrucao;
	}
	public void setInstrucao(String instrucao) {
		Instrucao = instrucao;
	}

	public String getDado() {
		return dado;
	}

	public TipoInstrucao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInstrucao tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return tipo.name();
	}
	
}