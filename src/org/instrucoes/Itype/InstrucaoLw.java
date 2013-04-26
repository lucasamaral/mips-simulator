package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoLw extends InstrucaoItype {

	public InstrucaoLw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.LW;
	}

	@Override
	public void writeBack(Processador banco,int valorULA,int valorMem) {
		banco.carregarNosRegistradores(rtCode, valorMem);
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int rsValue = proc.pegardosRegistradores(rsCode);
		return rsValue+ Integer.parseInt(immCode, 2);
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
