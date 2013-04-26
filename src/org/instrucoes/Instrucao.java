package org.instrucoes;

import org.BancoDeRegistradores;
import org.Processador;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sun.org.apache.xml.internal.utils.UnImplNode;




public abstract class Instrucao {
	
	protected String dados;
	protected CodigoInstrucao codigo;
	protected TipoInstrucao tipo;
	protected int numeroDeClocks;

	public Instrucao(String entrada){
		dados = entrada;
	}
	
	public abstract void executar(Processador proc);

	public TipoInstrucao getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeBack(BancoDeRegistradores banco, int valor) {
		throw new RuntimeException();
	}
}
