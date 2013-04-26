package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

public class InstrucaoAdd extends InstrucaoRtype {

	public InstrucaoAdd(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADD;
	}

	@Override
	public void execute(Processador proc) {
		// Soma: rd = rs+rt
		BancoDeRegistradores banco = proc.getRegistradores();
		int soma;
		soma = banco.readRegister(rsCode) + banco.readRegister(rtCode);
		resultado = soma;
	}

	@Override
	public void decode(Processador proc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memory(MemoriaDados memoria) {
		// TODO Auto-generated method stub
		
	}

}
