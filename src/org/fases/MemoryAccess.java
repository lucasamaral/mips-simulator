package org.fases;

import org.Processador;
import org.instrucoes.Itype.InstrucaoSw;
import org.latches.LatchEXMEM;
import org.latches.LatchMEMWB;

public class MemoryAccess extends FasePadrao {

	private LatchEXMEM exMem;
	private LatchMEMWB memWb;
	private boolean zeroULA;
	private int possivelProximoEndereco;
	private int resultadoULA;

	public MemoryAccess(Processador p, LatchEXMEM exMem, LatchMEMWB memWb) {
		super(p);
		this.exMem = exMem;
		this.memWb = memWb;
	}

	@Override
	public void executarPasso1() {
	}

	@Override
	public void executarPasso2() {
		if (instrucaoAtual != null) {
			memWb.adicionarInstrucao(instrucaoAtual);
			switch (instrucaoAtual.getCodigo()) {
			case SW:
				InstrucaoSw inss = (InstrucaoSw) instrucaoAtual.getInstrucao();
				inss.memory(resultadoULA, processador, exMem);
			case LW:
				memWb.setResultadoMem(processador.pegarDaMemoria(resultadoULA));
			default:
				break;

			}
		}
		memWb.setResultadoULA(resultadoULA);
		if (instrucaoAtual != null && instrucaoAtual.isBranch() && zeroULA) {
			fazerSalto();
		} else {
			processador.incrementarPC();
		}
		instrucaoAtual = null;
	}

	private void fazerSalto() {
		processador.executarSalto(possivelProximoEndereco);
	}

	@Override
	public void carregarSinais() {
		instrucaoAtual = exMem.pegarInstrucao();
		if(instrucaoAtual!=null){
			processador.setSinal("branch", instrucaoAtual.isBranch());
		}else{
			processador.setSinal("branch", false);
		}
		zeroULA = exMem.getZeroULA();
		possivelProximoEndereco = exMem.getProximoEndereco();
		resultadoULA = exMem.getResultadoULA();
	}

}
