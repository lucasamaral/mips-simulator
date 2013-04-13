package org.instrucoes;




public abstract class Instrucao {
	protected TipoInstrucao tipo;
	protected int numeroDeClocks;

	public abstract void executar();
}
