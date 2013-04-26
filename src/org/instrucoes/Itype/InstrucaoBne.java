package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.TipoInstrucao;

public class InstrucaoBne extends InstrucaoItype {

	public InstrucaoBne(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.BNE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
