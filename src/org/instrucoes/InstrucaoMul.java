package org.instrucoes;

public class InstrucaoMul extends Instrucao {
	

	public InstrucaoMul(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.MUL;
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
