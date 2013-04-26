package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.latches.LatchEXMEM;

public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int rsValue = proc.pegardosRegistradores(rsCode);
		return rsValue + Integer.parseInt(immCode, 2);
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return 0;
	}

	public void memory(LatchEXMEM exMem, Processador proc) {
		proc.carregarNaMemoria(exMem.getResultadoULA(), proc.pegardosRegistradores(rtCode));
	}

}
