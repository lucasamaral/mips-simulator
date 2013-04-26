package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoLw extends InstrucaoItype {

	public InstrucaoLw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.LW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
