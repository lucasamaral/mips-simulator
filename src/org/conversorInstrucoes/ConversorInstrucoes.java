package org.conversorInstrucoes;

import org.instrucoes.Instrucao;
import org.instrucoes.InstrucaoAdd;

public class ConversorInstrucoes {

	public static Instrucao converterInstrucao(String instrucao) {
		return new InstrucaoAdd(instrucao);
	}

}
