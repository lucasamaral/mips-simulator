package org.instrucoes;

import org.Processador;

public class InstrucaoBle extends Instrucao {

	public InstrucaoBle(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.BLE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
