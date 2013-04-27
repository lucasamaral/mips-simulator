package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.Instrucao;
import org.instrucoes.TipoInstrucao;


public abstract class InstrucaoItype extends Instrucao {

	protected int resultado;
	protected String rsCode;
	protected String rtCode;
	protected String immCode;
	
	public InstrucaoItype(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.ITYPE;
		rsCode = dados.substring(6, 11);
		rtCode = dados.substring(11, 16);
		immCode = dados.substring(16, 32);
	}
	
	public String getValorRtCode(){
		return rtCode;
	}
	
	@Override
	public void writeBack(Processador banco,int valorULA, int valorMem) {}
	
	public boolean getALUOp1(){
		return false;
	}

	public boolean getALUOp2(){
		return false;
	}
}
