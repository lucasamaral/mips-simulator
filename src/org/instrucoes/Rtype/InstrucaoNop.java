package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoNop extends InstrucaoRtype {

	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}

	@Override
	public void executar(Processador proc) {

	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco,int valorULA, int valorMEM) {

	}

}
