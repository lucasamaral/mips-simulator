package org.instrucoes;

import org.Processador;

public class InstrucaoBne extends Instrucao {

	public InstrucaoBne(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.BNE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
