package org.fases;

import org.Processador;
import org.latches.Latch;
import org.latches.LatchIDEX;

public class RegisterDecoder extends FasePadrao {

	private Latch ifId;
	private LatchIDEX idEx;

	public RegisterDecoder(Processador p, Latch ifId, LatchIDEX idEx) {
		super(p);
		this.ifId = ifId;
		this.idEx = idEx;
	}

	@Override
	public void executarPasso1() {
		instrucaoAtual = ifId.pegarInstrucao();
		super.executarPasso1();
		processar();
	}
	
	@Override
	public void executarPasso2() {
		super.executarPasso2();
		idEx.adicionarInstrucao(instrucaoAtual);
		instrucaoAtual = null;
	}


	private void processar() {
		// TODO Auto-generated method stub

	}

}
