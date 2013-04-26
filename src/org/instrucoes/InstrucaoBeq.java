package org.instrucoes;

import org.Processador;


public class InstrucaoBeq extends Instrucao {

	public InstrucaoBeq(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BEQ;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
