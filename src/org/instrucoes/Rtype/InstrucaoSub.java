package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.TipoInstrucao;

public class InstrucaoSub extends InstrucaoRtype {

	public InstrucaoSub(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.SUB;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
