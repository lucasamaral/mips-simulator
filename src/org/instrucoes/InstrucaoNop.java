package org.instrucoes;

import org.Processador;

public class InstrucaoNop extends Instrucao {
	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}

	private byte[] rs;
	private byte[] rd;
	private byte[] rt;
	private byte[] shamt;
	private byte[] funct;
	
	@Override
	public void executar(Processador proc) {
		// TODO Implementar a soma: rs = rd+rt

	}

}
