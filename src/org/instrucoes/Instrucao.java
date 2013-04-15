package org.instrucoes;




public abstract class Instrucao {
	
	protected String dados;
	protected TipoInstrucao tipo;
	protected int numeroDeClocks;

	public Instrucao(String entrada){
		dados = entrada;
	}
	
	public abstract void executar();
}
