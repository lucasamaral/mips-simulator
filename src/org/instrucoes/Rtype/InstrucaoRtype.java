package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.Instrucao;
import org.instrucoes.TipoInstrucao;

public abstract class InstrucaoRtype extends Instrucao {

	protected String rsCode;
	protected String rtCode;
	protected String rdCode;

	public InstrucaoRtype(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.RTYPE;
		codigo = CodigoInstrucao.ADD;
		rsCode = dados.substring(6, 11);
		rtCode = dados.substring(11, 16);
		rdCode = dados.substring(16, 21);
	}

	public String getRsCode() {
		return rsCode;
	}

	@Override
	public void writeBack(Processador banco, int valorULA, int valorMem) {
		banco.carregarNosRegistradores(rdCode, valorULA);
	}

	public String getRtCode() {
		return rtCode;
	}

	public String getRdCode() {
		return rdCode;
	}
	
	public boolean getALUOp1(){
		return true;
	}

	public boolean getALUOp2(){
		return false;
	}

}
