package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
