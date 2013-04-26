package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoAddi extends InstrucaoItype {

	public InstrucaoAddi(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADDI;
	}

	@Override
	public void writeBack(BancoDeRegistradores banco,int valorULA, int valorMem) {
		banco.writeRegister(rtCode, valorULA);
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int soma;
		soma = proc.pegardosRegistradores(rsCode) + Integer.parseInt(immCode, 2);
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
