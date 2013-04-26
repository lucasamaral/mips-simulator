package org.instrucoes.Rtype;

import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoSub extends InstrucaoRtype {

	public InstrucaoSub(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SUB;
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
