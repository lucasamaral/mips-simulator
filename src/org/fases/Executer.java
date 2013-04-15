package org.fases;

import org.Processador;
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;


public class Executer extends FasePadrao {
	
	private LatchIDEX idEx;
	private LatchEXMEM exMem;
	
	public Executer(Processador p,LatchIDEX idEx, LatchEXMEM exMem) {
		super(p);
		this.idEx = idEx;
		this.exMem = exMem;
	}
	
	@Override
	public void executar(){
		instrucaoAtual = idEx.pegarInstrucao();
		super.executar();
		exMem.adicionarInstrucao(instrucaoAtual);
		instrucaoAtual = null;
	}

}
