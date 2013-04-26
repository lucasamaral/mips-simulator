package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoSub extends InstrucaoRtype {

	public InstrucaoSub(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SUB;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
