package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.Processador;
import org.instrucoes.TipoInstrucao;

public class InstrucaoAdd extends InstrucaoRtype {

	public InstrucaoAdd(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.ADD;
	}

	@Override
	public void executar(Processador proc) {
		// Soma: rd = rs+rt
		BancoDeRegistradores banco = proc.getRegistradores();
		int soma;
		soma = banco.readRegister(rsCode) + banco.readRegister(rtCode);
		resultado = soma;
	}

}
