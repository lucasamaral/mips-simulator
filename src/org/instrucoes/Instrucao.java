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

	public abstract void decode(Processador proc);

	public abstract void execute(Processador proc);

	public abstract void memory(MemoriaDados memoria);

	public abstract void writeBack(BancoDeRegistradores banco, int valorULA,
			int valorMem);

	public TipoInstrucao getType() {
		return tipo;
	}

	public boolean isBranch() {
		return false;
	}

	public abstract int getResultadoULA();

	public abstract boolean getCondicaoULA();

	public abstract int getResultadoULAEndereco();
}
