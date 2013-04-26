package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoAdd extends InstrucaoRtype {

	public InstrucaoAdd(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADD;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int soma = proc.pegardosRegistradores(rsCode) + proc.pegardosRegistradores(rtCode);
		return soma;
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
