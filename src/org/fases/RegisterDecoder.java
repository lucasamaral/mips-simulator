package org.fases;

import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.Itype.InstrucaoSw;
import org.latches.Latch;
import org.latches.LatchIDEX;

public class RegisterDecoder extends FasePadrao {

	private Latch ifId;
	private LatchIDEX idEx;

	public RegisterDecoder(Processador p, Latch ifId, LatchIDEX idEx) {
		super(p);
		this.ifId = ifId;
		this.idEx = idEx;
	}

	@Override
	public void executarPasso1() {
	}
	
	@Override
	public void executarPasso2() {
		idEx.adicionarInstrucao(instrucaoAtual);
		//adicionado por Assis
		if(instrucaoAtual.getCodigo().equals(CodigoInstrucao.SW)){
			InstrucaoSw instSw = (InstrucaoSw) instrucaoAtual.getInstrucao();
			idEx.setValorLidoRtParaSalvarNaMemoria(processador.pegardosRegistradores(instSw.getValorRtCode()));
		}
		//até aqui
		instrucaoAtual = null;
	}

	@Override
	public void carregarSinais() {
		instrucaoAtual = ifId.pegarInstrucao();
	}

}
