package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public class InstrucaoNop extends InstrucaoRtype {

	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Implementar a soma: rs = rd+rt

	}

}
