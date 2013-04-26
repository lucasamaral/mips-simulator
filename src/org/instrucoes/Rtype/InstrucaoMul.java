package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;

public class InstrucaoMul extends InstrucaoRtype {

	public InstrucaoMul(String entrada) {
		super(entrada);
	}
	
	@Override
	public void executar(Processador proc) {
		// Multiplica: rd = rs*rt
		BancoDeRegistradores banco = proc.getRegistradores();
		int multiplicacao;
		try {
			multiplicacao = banco.readRegister(rsCode)*banco.readRegister(rtCode);
			String mult = Integer.toBinaryString(multiplicacao);
			mult = mult.substring(mult.length()-32);
			resultado = Integer.parseInt(mult, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
