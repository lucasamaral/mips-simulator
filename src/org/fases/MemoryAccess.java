package org.fases;

import org.Processador;
import org.instrucoes.Itype.InstrucaoSw;
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
	public void executarPasso1() {
		instrucaoAtual = exMem.pegarInstrucao();
	}

	@Override
	public void executarPasso2() {
		if (instrucaoAtual != null) {
			memWb.adicionarInstrucao(instrucaoAtual);
			switch (instrucaoAtual.getCodigo()) {
			case SW:
				InstrucaoSw inss = (InstrucaoSw) instrucaoAtual.getInstrucao();
				processador.carregarNaMemoria(exMem.getResultadoULA(),
						inss.getValorRtCode());
			case LW:
				memWb.setResultadoMem(processador.pegarDaMemoria(exMem
						.getResultadoULA()));
			default:
				break;

			}
			if (instrucaoAtual.isBranch()) {
				if (exMem.getZero()) {
					processador.setPc(exMem.getProximoEndereco());
				} else {
					processador.incrementarPC();
				}
			}
			instrucaoAtual = null;
		}else{
			processador.incrementarPC();
		}

	}

	@Override
	public void carregarSinais() {
		// TODO Auto-generated method stub
		
	}

}
