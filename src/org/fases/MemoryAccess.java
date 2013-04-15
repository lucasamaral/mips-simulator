package org.fases;

import org.Processador;
import org.latches.LatchEXMEM;
import org.latches.LatchMEMWB;

public class MemoryAccess extends FasePadrao {

	private LatchEXMEM exMem;
	private LatchMEMWB memWb;

	public MemoryAccess(Processador p, LatchEXMEM exMem, LatchMEMWB memWb) {
		super(p);
		this.exMem = exMem;
		this.memWb = memWb;
	}

	@Override
	public void executar() {
		instrucaoAtual = exMem.pegarInstrucao();
		super.executar();
		memWb.adicionarInstrucao(instrucaoAtual);
		instrucaoAtual = null;
	}

}
