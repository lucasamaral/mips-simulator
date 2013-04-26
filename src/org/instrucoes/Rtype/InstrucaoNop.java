package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoNop extends InstrucaoRtype {

	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco,int valorULA, int valorMEM) {


	}

	@Override
	public void decode(Processador proc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memory(MemoriaDados memoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Processador proc) {
		// TODO Auto-generated method stub
		
	}

}
