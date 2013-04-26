package org.instrucoes.Rtype;

import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public class InstrucaoNop extends InstrucaoRtype {

	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}

	@Override
	public void execute(Processador proc) {
		// TODO Implementar a soma: rs = rd+rt

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
