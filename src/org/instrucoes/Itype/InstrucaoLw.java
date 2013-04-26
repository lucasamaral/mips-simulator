package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.TipoInstrucao;


public class InstrucaoLw extends InstrucaoItype {

	public InstrucaoLw(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.LW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
