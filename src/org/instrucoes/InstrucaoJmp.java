package org.instrucoes;

import org.MemoriaDados;
import org.Processador;


public class InstrucaoJmp extends Instrucao {

	public InstrucaoJmp(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.JMP;
	}

	@Override
	public void execute(Processador proc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decode(Processador proc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memory(MemoriaDados memoria) {
		// TODO Auto-generated method stub
		
	}

}
