package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.instrucoes.Instrucao;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public abstract class InstrucaoRtype extends Instrucao {
	
	protected int resultado;
	protected String rsCode;
	protected String rtCode;
	protected String rdCode;
		
	public String getRsCode() {
		return rsCode;
	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco,int valor) {
		try {
			banco.writeRegister(rdCode, valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRtCode() {
		return rtCode;
	}

	public String getRdCode() {
		return rdCode;
	}

	public InstrucaoRtype(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.RTYPE;
		codigo = CodigoInstrucao.ADD;
		rsCode = dados.substring(6, 11);
		rtCode = dados.substring(11, 16);
		rdCode = dados.substring(16, 21);
	}

}
