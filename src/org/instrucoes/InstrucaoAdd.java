package org.instrucoes;

public class InstrucaoAdd extends Instrucao {
	
	public InstrucaoAdd(String entrada) {
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
