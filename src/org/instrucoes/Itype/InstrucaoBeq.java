package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.TipoInstrucao;


public class InstrucaoBeq extends InstrucaoItype {

	public InstrucaoBeq(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.BEQ;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
