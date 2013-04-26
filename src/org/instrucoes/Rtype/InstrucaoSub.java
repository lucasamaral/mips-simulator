package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoSub extends InstrucaoRtype {

	public InstrucaoSub(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SUB;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int sub;
		sub = proc.pegardosRegistradores(rsCode) - proc.pegardosRegistradores(rtCode);
		return sub;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return 0;
	}

}
