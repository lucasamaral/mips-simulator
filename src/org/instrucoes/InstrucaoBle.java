package org.instrucoes;

import org.Processador;

public class InstrucaoBle extends Instrucao {

	public InstrucaoBle(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BLE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
