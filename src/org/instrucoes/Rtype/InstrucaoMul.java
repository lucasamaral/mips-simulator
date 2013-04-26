package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

//Multiplica: rd = rs*rt
public class InstrucaoMul extends InstrucaoRtype {

	public InstrucaoMul(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.MUL;
	}

	@Override
	public void writeBack(BancoDeRegistradores banco, int valorULA, int valorMem) {
		banco.writeRegister(rdCode, valorULA);
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int multiplicacao;
		multiplicacao = proc.pegardosRegistradores(rsCode) * proc.pegardosRegistradores(rtCode);
		String mult = Integer.toBinaryString(multiplicacao);
		mult = mult.substring(mult.length() - 32);
		multiplicacao = Integer.parseInt(mult, 2);
		return multiplicacao;
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
