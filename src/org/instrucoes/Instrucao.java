package org.instrucoes;

import java.util.List;

import org.Processador;

public abstract class Instrucao {

	protected String dados;
	protected CodigoInstrucao codigo;
	protected TipoInstrucao tipo;
	protected int numeroDeClocks = 1;

	public Instrucao(String entrada) {
		dados = entrada;
	}
	
	public int getNumeroClocks(){
		return numeroDeClocks;
	}
	
	public void decrementarNumerodeClocks(){
		numeroDeClocks--;
	}

	public abstract void writeBack(Processador banco, int valorULA,
			int valorMem);

	public TipoInstrucao getType() {
		return tipo;
	}

	public boolean isBranch() {
		return false;
	}
	
	public Integer analisarString(String complemento2){
		if(complemento2.charAt(0)=='0'){
			return Integer.parseInt(complemento2, 2);
		} else {
			return -(int)Math.pow(2, 15)+Integer.parseInt(complemento2.substring(1),2);
		}
	}
	
	
	public abstract int getResultadoULA(Processador proc);

	public abstract boolean getCondicaoULA(Processador proc);

	public abstract int getResultadoULAEndereco(int pc, Processador proc);

	public abstract List<Integer> getDependenciasWrite();

	public abstract List<Integer> getDependenciasRead();

	public abstract boolean getALUOp1();

	public abstract boolean getALUOp2();
}
