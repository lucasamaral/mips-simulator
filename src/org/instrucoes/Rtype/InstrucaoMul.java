package org.instrucoes.Rtype;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

//Multiplica: rd = rs*rt
public class InstrucaoMul extends InstrucaoRtype {

	public InstrucaoMul(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.MUL;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int multiplicacao;
		multiplicacao = proc.pegardosRegistradores(rsCode)
				* proc.pegardosRegistradores(rtCode);
		return multiplicacao % (int) Math.pow(2, 32);
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return 0;
	}

}
