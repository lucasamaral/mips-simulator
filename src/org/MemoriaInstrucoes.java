package org;

public class MemoriaInstrucoes {
	
	private String[] instrucoes;

	public MemoriaInstrucoes(String[] Instrucoes){
		this.instrucoes = Instrucoes;
	}
	
	public String getInstrucao(int endereco){
		return instrucoes[endereco/4];
	}
	
	public int limiteInstrucoes(){
		return instrucoes.length;
	}

}
