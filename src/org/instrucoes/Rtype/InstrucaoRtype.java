package org.instrucoes.Rtype;

import org.instrucoes.Instrucao;
import org.instrucoes.TipoInstrucao;

public abstract class InstrucaoRtype extends Instrucao {
	
	protected int resultado;
	protected String rsCode;
	protected String rtCode;
	protected String rdCode;
	
	public InstrucaoRtype(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.ADD;
		rsCode = dados.substring(6, 11);
		rtCode = dados.substring(11, 16);
		rdCode = dados.substring(16, 21);
	}

}
