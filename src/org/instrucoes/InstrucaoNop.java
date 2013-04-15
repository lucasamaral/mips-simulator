package org.instrucoes;

public class InstrucaoNop extends Instrucao {
	public InstrucaoNop(String entrada) {
		super(entrada);
	}

	private byte[] rs;
	private byte[] rd;
	private byte[] rt;
	private byte[] shamt;
	private byte[] funct;
	
	@Override
	public void executar() {
		// TODO Implementar a soma: rs = rd+rt

	}

}
