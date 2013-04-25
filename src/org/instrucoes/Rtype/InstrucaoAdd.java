package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;

public class InstrucaoAdd extends InstrucaoRtype {
	
	public InstrucaoAdd(String entrada) {
		super(entrada);
	}
	
	@Override
	public void executar(Processador proc) {
		// Soma: rd = rs+rt
		BancoDeRegistradores banco = proc.getRegistradores();
		int soma;
		try {
			soma = banco.readRegister(rsCode) + banco.readRegister(rtCode);
			banco.writeRegister(rdCode, soma);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
