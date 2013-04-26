package org.instrucoes.Itype;

import org.BancoDeRegistradores;
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
	
	public int getValorRtCode(){
		return Integer.parseInt(rtCode, 2);
	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco,int valorULA, int valorMem) {}
}
