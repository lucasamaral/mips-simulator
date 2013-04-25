package org.instrucoes;

import org.Processador;


public class InstrucaoLw extends Instrucao {

	public InstrucaoLw(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.LW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
