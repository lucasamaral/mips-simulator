package org.latches;

import org.instrucoes.InstrucaoWrapper;

public class Latch {

	InstrucaoWrapper instrucaoNoBuffer;

	public void adicionarInstrucao(InstrucaoWrapper instrucaoAtual) {
		instrucaoNoBuffer = instrucaoAtual;
	}

	public InstrucaoWrapper pegarInstrucao() {
		InstrucaoWrapper temp = instrucaoNoBuffer;
		instrucaoNoBuffer = null;
		return temp;
	}
	
	public boolean hasInstruction() {
		return instrucaoNoBuffer!=null;
	}

}
