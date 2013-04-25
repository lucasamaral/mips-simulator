package org.instrucoes;

import org.Processador;

public class InstrucaoAddi extends Instrucao {

	public InstrucaoAddi(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.ADDI;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
