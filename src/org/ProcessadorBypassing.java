package org;

import org.instrucoes.InstrucaoWrapper;

public class ProcessadorBypassing extends Processador{

	public ProcessadorBypassing(MemoriaDados mem, MemoriaInstrucoes ins) {
		super(mem, ins);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void notificarEntrada(InstrucaoWrapper instrucaoAtual) {
		if (instrucaoAtual.getDependenciasWrite().size() > 0) {
			switch (instrucaoAtual.getCodigo()) {
			case LW:
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						2);
			default:
				dependencias.put(instrucaoAtual.getDependenciasWrite().get(0),
						1);
			}
		}
	}
	
	@Override
	public int pegardosRegistradores(String endereco) {
		return exMem.getResultadoULA();
		
	}

}
