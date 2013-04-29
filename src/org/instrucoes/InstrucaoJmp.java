package org.instrucoes;

import java.util.ArrayList;
import java.util.List;

import org.Processador;


public class InstrucaoJmp extends Instrucao {

	protected String immCode;
	
	public InstrucaoJmp(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.JMP;
		tipo = TipoInstrucao.JTYPE;
		immCode = dados.substring(16, 32);
	}

	@Override
	public void writeBack(Processador banco, int valorULA, int valorMem) { }

	@Override
	public int getResultadoULA(Processador proc) {
		return 0;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return true;
	}

	@Override
	public int getResultadoULAEndereco(int pcAtual, Processador proc) {
		return Integer.parseInt(immCode, 2);
	}

	@Override
	public List<Integer> getDependenciasWrite() {
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getDependenciasRead() {
		return new ArrayList<>();
	}
	
	public boolean getALUOp1(){
		return false;
	}

	public boolean getALUOp2(){
		return false;
	}

	@Override
	public boolean isBranch() {
		return true;
	}

}
