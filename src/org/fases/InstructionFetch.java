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
	public void carregarSinais(){
		internalPc = processador.getPc();
	}

	@Override
	public void executarPasso1() {
		String dadosInstrucao = null;
		try {
			dadosInstrucao = this.getProcessador().getInstrucoes()
					.getInstrucao(internalPc);
		} catch (ArrayIndexOutOfBoundsException e) {
			processador.sinalizarFimdePrograma();
			return;
		}
		instrucaoAtual = new InstrucaoWrapper(dadosInstrucao);
		instrucaoAtual.setInstrucaoReal(ConversorInstrucoes.converterInstrucao(instrucaoAtual.getDado()));
	}
	
	public void executarPasso2(){
		super.executarPasso2();
		if(!processador.temDependencia(instrucaoAtual)){
			processador.setPc(internalPc+4);
			ifId.adicionarInstrucao(instrucaoAtual);
			instrucaoAtual = null;
		}
	}

}
