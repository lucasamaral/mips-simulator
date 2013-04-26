package org.instrucoes.Itype;

import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
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
