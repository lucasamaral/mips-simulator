package org.fases;

import org.Processador;
import org.conversorInstrucoes.ConversorInstrucoes;
import org.instrucoes.InstrucaoWrapper;
import org.latches.Latch;

public class InstructionFetch extends FasePadrao {

	private Latch ifId;
	private int internalPc = 0;

	public InstructionFetch(Processador p, Latch ifId) {
		super(p);
		this.ifId = ifId;
	}

	@Override
	public void carregarSinais() {
		internalPc = processador.getPc();
	}

	@Override
	public void executarPasso1() {
		String dadosInstrucao = null;
		try {
			dadosInstrucao = this.getProcessador().getInstrucoes()
					.getInstrucao(internalPc);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		instrucaoAtual = new InstrucaoWrapper(dadosInstrucao);
		instrucaoAtual.setInstrucaoReal(ConversorInstrucoes
				.converterInstrucao(instrucaoAtual.getDado()));
	}

	public void executarPasso2() {
		if(ifId.hasInstruction()){
			processador.naoIncrementarPc();
			return;
		}
		if (instrucaoAtual != null
				&& !processador.temDependencia(instrucaoAtual)) {
			processador.notificarEntrada(instrucaoAtual);
			ifId.adicionarInstrucao(instrucaoAtual);
			instrucaoAtual = null;
		}
	}

}
