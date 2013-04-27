package org;

import java.util.ArrayList;
import java.util.HashMap;

import org.instrucoes.InstrucaoWrapper;

public class ProcessadorBypassing extends Processador {

	private HashMap<InstrucaoWrapper, Integer> posicaoAtual = new HashMap<>();

	public ProcessadorBypassing(MemoriaDados mem, MemoriaInstrucoes ins) {
		super(mem, ins);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step() {
		for (InstrucaoWrapper ins : posicaoAtual.keySet()) {
			posicaoAtual.put(ins, posicaoAtual.get(ins) + 1);
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
		if (existeDependencia(end)) {
			for (InstrucaoWrapper ins : dependencias.get(end)) {
				int pos = posicaoAtual.get(ins);
				if (pos < 5) {
					switch (ins.getCodigo()) {
					case LW:
						System.out.println("Pegando da memoria");
						return memWb.getResultadoMem();
					default:
						System.out.println("Pegando da ULA");
						switch (pos) {
						case 3:
							return exMem.getResultadoULA();
						case 4:
							return memWb.getResultadoULA();
						}
					}
				}
			}
			return exMem.getResultadoULA();
		} else {
			return super.pegardosRegistradores(endereco);
		}

	}

}
