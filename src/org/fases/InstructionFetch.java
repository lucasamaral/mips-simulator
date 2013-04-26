package org.fases;

import org.Processador;
import org.conversorInstrucoes.ConversorInstrucoes;
import org.instrucoes.InstrucaoWrapper;
import org.latches.Latch;

public class InstructionFetch extends FasePadrao {

	private Latch ifId;
	private int pc = 0;

	public InstructionFetch(Processador p, Latch ifId) {
		super(p);
		this.ifId = ifId;
	}

	@Override
	public void executarPasso1() {
		String dadosInstrucao = null;
		try {
			dadosInstrucao = this.getProcessador().getInstrucoes()
					.getInstrucao(pc);
		} catch (ArrayIndexOutOfBoundsException e) {
			this.getProcessador().sinalizarFimdePrograma();
			System.out.println(getNomeFase() + " sinalizando fim de programa");
			return;
		}
		pc += 4;
		instrucaoAtual = new InstrucaoWrapper(dadosInstrucao);
		instrucaoAtual.setInstrucaoReal(ConversorInstrucoes.converterInstrucao(instrucaoAtual.getDado()));
	}
	
	public void executarPasso2(){
		super.executarPasso2();
		processar(instrucaoAtual);
		ifId.adicionarInstrucao(instrucaoAtual);
		instrucaoAtual = null;
	}

	private void processar(InstrucaoWrapper instrucaoAtual) {
		// TODO Auto-generated method stub
	}

}
