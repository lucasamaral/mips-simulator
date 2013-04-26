package org.instrucoes;

import org.Processador;

public class InstrucaoSub extends Instrucao {

	private byte[] rs;
	private byte[] rd;
	private byte[] rt;
	private byte[] shamt;
	private byte[] funct;

	public InstrucaoSub(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SUB;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
