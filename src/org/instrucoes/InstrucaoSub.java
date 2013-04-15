package org.instrucoes;

public class InstrucaoSub extends Instrucao {

	private byte[] rs;
	private byte[] rd;
	private byte[] rt;
	private byte[] shamt;
	private byte[] funct;

	public InstrucaoSub(String entrada) {
		super(entrada);
	}

	@Override
	public void executar() {
		// TODO Auto-generated method stub

	}

}
