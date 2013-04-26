package org.fases;

import org.BancoDeRegistradores;
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
		BancoDeRegistradores banco = processador.getRegistradores();
		if(instrucaoAtual!=null){
			instrucaoAtual.writeBack(banco,memWb.getResultadoULA(),memWb.getResultadoMem());
		}
		instrucaoAtual = null;
	}

	@Override
	public void carregarSinais() {
		instrucaoAtual = memWb.pegarInstrucao();
	}

}
