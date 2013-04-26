package org.fases;

import org.Processador;
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;

public class Executer extends FasePadrao {

	private LatchIDEX idEx;
	private LatchEXMEM exMem;

	public Executer(Processador p, LatchIDEX idEx, LatchEXMEM exMem) {
		super(p);
		this.idEx = idEx;
		this.exMem = exMem;
	}

	@Override
	public void executarPasso1() {
	}

	@Override
	public void executarPasso2() {
		if(instrucaoAtual!=null){
			exMem.adicionarInstrucao(instrucaoAtual);
			exMem.setResultadoULA(instrucaoAtual.getResultadoULA(processador));
			exMem.setZeroULA(instrucaoAtual.getCondicaoULA(processador));
			exMem.setEnderecoSomado(instrucaoAtual
					.getResultadoULAEndereco(processador));
		}
		instrucaoAtual = null;
	}

	@Override
	public void carregarSinais() {
		instrucaoAtual = idEx.pegarInstrucao();
	}

}
