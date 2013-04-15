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
	public void executar(){
		instrucaoAtual = memWb.pegarInstrucao();
		super.executar();
		instrucaoAtual = null;
	}
}
