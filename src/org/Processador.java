package org;

public class Processador {
	private String[] memoria;
	private String[] instrucoes;
	private Fase[] fases;
	
	public Processador(String[] memoria, String[] instrucoes) {
		this.memoria = memoria;
		this.instrucoes = instrucoes;
		fases = new Fase[5];
	}
	
	
	
}
