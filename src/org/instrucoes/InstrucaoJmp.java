package org.instrucoes;

import org.BancoDeRegistradores;
import org.Processador;


public class InstrucaoJmp extends Instrucao {

	protected String immCode;
	
	public InstrucaoJmp(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.JMP;
		immCode = dados.substring(16, 32);
	}

	@Override
	public void writeBack(BancoDeRegistradores banco, int valorULA, int valorMem) { }

	@Override
	public int getResultadoULA(Processador proc) {
		return 0;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return true;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return Integer.parseInt(immCode, 2);
	}

}
