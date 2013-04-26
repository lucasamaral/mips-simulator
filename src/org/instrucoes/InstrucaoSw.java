package org.instrucoes;

import org.Processador;


public class InstrucaoSw extends Instrucao {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
