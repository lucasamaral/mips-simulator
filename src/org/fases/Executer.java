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
	public void executarPasso1(){
		instrucaoAtual = idEx.pegarInstrucao();
	}
	
	@Override
	public void executarPasso2() {
		exMem.adicionarInstrucao(instrucaoAtual);
		instrucaoAtual = null;
		exMem.setResultadoULA(instrucaoAtual.getResultadoULA(processador));
		exMem.setZeroULA(instrucaoAtual.getCondicaoULA(processador));
		exMem.setEnderecoSomado(instrucaoAtual.getResultadoULAEndereco(processador));
	}

	@Override
	public void carregarSinais() {
		// TODO Auto-generated method stub
	}


}
