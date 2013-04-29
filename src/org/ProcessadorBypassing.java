package org;

import java.util.ArrayList;
import java.util.HashMap;

import org.instrucoes.CodigoInstrucao;
import org.instrucoes.InstrucaoWrapper;

public class ProcessadorBypassing extends Processador {

	private HashMap<InstrucaoWrapper, Integer> posicaoAtual = new HashMap<>();

	public ProcessadorBypassing(MemoriaDados mem, MemoriaInstrucoes ins) {
		super(mem, ins);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step() {
		InstrucaoWrapper ins = fases[2].getInstrucaoAtual();
		if (ins == null || ins.getInstrucao().getNumeroClocks() < 1) {
			for (InstrucaoWrapper insp : posicaoAtual.keySet()) {
				posicaoAtual.put(insp, posicaoAtual.get(insp) + 1);
			}
		}
		super.step();
	}

	@Override
	public void notificarEntrada(InstrucaoWrapper instrucaoAtual) {
		posicaoAtual.put(instrucaoAtual, 0);
		instrucaoAtual.setClockEntrada(pc);
		if (instrucaoAtual.getDependenciasWrite().size() > 0) {
			if (!dependencias.containsKey(instrucaoAtual.getDependenciasWrite()
					.get(0))) {
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						new ArrayList<InstrucaoWrapper>());
			}
			switch (instrucaoAtual.getCodigo()) {
			case LW:
				dependencias.get(instrucaoAtual.getDependenciasWrite().get(0))
						.add(instrucaoAtual);
				dependenciasInstrucoes.put(instrucaoAtual, 2);
				break;
			default:
				dependencias.get(instrucaoAtual.getDependenciasWrite().get(0))
						.add(instrucaoAtual);
				dependenciasInstrucoes.put(instrucaoAtual, 1);
			}

		}
	}

	@Override
	public int pegardosRegistradores(String endereco) {
		int end = Integer.parseInt(endereco, 2);
		if (fases[3].getInstrucaoAtual() != null
				&& fases[3].getInstrucaoAtual().getDependenciasWrite()
						.contains(end)) {
			return exMem.getResultadoULA();
		}
		if (fases[4].getInstrucaoAtual() != null
				&& fases[4].getInstrucaoAtual().getDependenciasWrite()
						.contains(end)) {
			if (fases[4].getInstrucaoAtual().getCodigo() == CodigoInstrucao.LW)
				return memWb.getResultadoMem();
			return memWb.getResultadoULA();
		}
		return super.pegardosRegistradores(endereco);

	}

}
