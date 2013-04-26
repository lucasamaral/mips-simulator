package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoBne extends InstrucaoItype {

	public InstrucaoBne(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BNE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
