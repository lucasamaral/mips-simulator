package org.fases;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.Itype.InstrucaoItype;
import org.instrucoes.Rtype.InstrucaoRtype;
import org.latches.LatchMEMWB;

public class WriteBack extends FasePadrao {

	private LatchMEMWB memWb;

	public WriteBack(Processador p,LatchMEMWB memWb) {
		super(p);
		this.memWb = memWb;
	}

	@Override
	public void executarPasso1(){
		instrucaoAtual = memWb.pegarInstrucao();
		super.executarPasso1();
	}
	
	@Override
	public void executarPasso2() {
		BancoDeRegistradores banco = processador.getRegistradores();
		instrucaoAtual.writeBack(banco,memWb.getResultadoULA());
		instrucaoAtual = null;
		super.executarPasso2();
	}

}
