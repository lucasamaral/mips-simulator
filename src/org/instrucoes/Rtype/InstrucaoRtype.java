package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.instrucoes.Instrucao;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public abstract class InstrucaoRtype extends Instrucao {

	protected int resultado;
	protected String rsCode;
	protected int rsValue;
	protected String rtCode;
	protected int rtValue;
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
	public void writeBack(BancoDeRegistradores banco, int valor) {
		banco.writeRegister(rdCode, valor);
	}

	public String getRtCode() {
		return rtCode;
	}

	public String getRdCode() {
		return rdCode;
	}

}
