package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.TipoInstrucao;


public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.SW;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
