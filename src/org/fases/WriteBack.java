package org.fases;

import org.Processador;
import org.latches.LatchMEMWB;

public class WriteBack extends FasePadrao {

	private LatchMEMWB memWb;

	public WriteBack(Processador p,LatchMEMWB memWb) {
		super(p);
		this.memWb = memWb;
	}

	@Override
	public void executarPasso1(){
		instrucaoAtual = memWb.pegarInstrucao();
		super.executarPasso1();
	}
	
	@Override
	public void executarPasso2() {
		instrucaoAtual = null;
		super.executarPasso2();
	}

}
