package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoBeq extends InstrucaoItype {

	public InstrucaoBeq(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BEQ;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
