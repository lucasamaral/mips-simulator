package org.latches;

import org.instrucoes.InstrucaoWrapper;

public class Latch {

	InstrucaoWrapper instrucaoNoBuffer;

	public void adicionarInstrucao(InstrucaoWrapper instrucaoAtual) {
		// TODO: Alguem tem que esperar caso o Buffer esteja ocupado
		instrucaoNoBuffer = instrucaoAtual;
	}

	public InstrucaoWrapper pegarInstrucao() {
		InstrucaoWrapper temp = instrucaoNoBuffer;
		instrucaoNoBuffer = null;
		return temp;
	}

	public boolean hasInstruction() {
		return instrucaoNoBuffer != null;
	}

}
