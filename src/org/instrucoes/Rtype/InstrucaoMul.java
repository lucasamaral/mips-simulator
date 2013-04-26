package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public class InstrucaoMul extends InstrucaoRtype {

	public InstrucaoMul(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.MUL;
	}

	@Override
	public void executar(Processador proc) {
		// Multiplica: rd = rs*rt
		BancoDeRegistradores banco = proc.getRegistradores();
		int multiplicacao;
		multiplicacao = banco.readRegister(rsCode) * banco.readRegister(rtCode);
		String mult = Integer.toBinaryString(multiplicacao);
		mult = mult.substring(mult.length() - 32);
		resultado = Integer.parseInt(mult, 2);
	}

}
