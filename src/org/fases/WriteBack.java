package org.fases;

import org.Processador;
import org.latches.LatchMEMWB;

public class WriteBack extends FasePadrao {

	private LatchMEMWB memWb;

	public WriteBack(Processador p,LatchMEMWB memWb) {
		super(p);
		this.memWb = memWb;
	}

	@Override
	public void executarPasso1(){
	}
	
	@Override
	public void executarPasso2() {
		if(instrucaoAtual!=null){
			instrucaoAtual.writeBack(processador,memWb.getResultadoULA(),memWb.getResultadoMem());
		}
		processador.adicionarInstrucaoCompletada(instrucaoAtual);
		instrucaoAtual = null;
	}

	@Override
	public void carregarSinais() {
		instrucaoAtual = memWb.pegarInstrucao();
	}

}
