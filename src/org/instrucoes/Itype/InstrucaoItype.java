package org.instrucoes.Itype;

import org.instrucoes.Instrucao;


public abstract class InstrucaoItype extends Instrucao {

	protected int resultado;
	protected String rsCode;
	protected String rtCode;
	protected String immCode;
	
	public InstrucaoItype(String entrada) {
		super(entrada);
		rsCode = dados.substring(6, 11);
		rtCode = dados.substring(11, 16);
		immCode = dados.substring(16, 32);
	}
	

}
