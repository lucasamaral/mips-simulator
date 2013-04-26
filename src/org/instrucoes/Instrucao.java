package org.instrucoes;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;

public abstract class Instrucao {

	protected String dados;
	protected CodigoInstrucao codigo;
	protected TipoInstrucao tipo;
	protected int numeroDeClocks;

	public Instrucao(String entrada) {
		dados = entrada;
	}

	public abstract void writeBack(BancoDeRegistradores banco, int valorULA,
			int valorMem);

	public TipoInstrucao getType() {
		return tipo;
	}

	public boolean isBranch() {
		return false;
	}
	
	
	public abstract int getResultadoULA(Processador proc);

	public abstract boolean getCondicaoULA(Processador proc);

	public abstract int getResultadoULAEndereco(Processador proc);
}
