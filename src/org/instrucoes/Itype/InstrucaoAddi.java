package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoAddi extends InstrucaoItype {

	public InstrucaoAddi(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADDI;
	}

	@Override
	public void executar(Processador proc) {
		// Calcular rt = rs + int(imm)
		BancoDeRegistradores banco = proc.getRegistradores();
		int soma;
		soma = banco.readRegister(rsCode) + Integer.parseInt(immCode, 2);
		resultado = soma;

	}

}
