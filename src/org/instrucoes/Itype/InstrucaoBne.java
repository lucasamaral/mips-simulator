package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoBne extends InstrucaoItype {

	public InstrucaoBne(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BNE;
	}

	public boolean isBranch() {
		return true;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		return 0;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		int rsValue = proc.pegardosRegistradores(rsCode);
		int rtValue = proc.pegardosRegistradores(rtCode);
		return rsValue!=rtValue;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return proc.getPc() + 4 + Integer.parseInt(immCode, 2);
	}

}
