package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.Processador;

public class InstrucaoAddi extends InstrucaoItype {

	public InstrucaoAddi(String entrada) {
		super(entrada);
	}

	@Override
	public void executar(Processador proc) {
		// Calcular rt = rs + int(imm)
		BancoDeRegistradores banco = proc.getRegistradores();
		int soma;
		try {
			soma  = banco.readRegister(rsCode)+Integer.parseInt(immCode, 2);
			resultado = soma;
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
