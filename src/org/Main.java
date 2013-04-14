package org;

public class Main {

	public static void main(String[] args) {
		String[] instrucoes = gerarAsInstrucoes();
		Memoria mem = new Memoria();
		Processador p = new Processador(mem, instrucoes);
		p.processar();
		System.out.println("Projeto Paulo André");
	}

	private static String[] gerarAsInstrucoes() {
		return new String[]{"AA","BB"};
	}

}
