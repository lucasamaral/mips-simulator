package org.instrucoes;

import org.Processador;


public class InstrucaoJmp extends Instrucao {

	public InstrucaoJmp(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.JMP;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
