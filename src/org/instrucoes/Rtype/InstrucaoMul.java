package org.instrucoes.Rtype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.instrucoes.TipoInstrucao;

//Multiplica: rd = rs*rt
public class InstrucaoMul extends InstrucaoRtype {

	public InstrucaoMul(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.MUL;
	}

	@Override
	public void decode(Processador proc) {
		BancoDeRegistradores banco = proc.getRegistradores();
		rsValue = banco.readRegister(rsCode);
		rtValue = banco.readRegister(rtCode);
	}
	
	@Override
	public void execute(Processador proc) {
		int multiplicacao;
		multiplicacao = rsValue * rtValue;
		String mult = Integer.toBinaryString(multiplicacao);
		mult = mult.substring(mult.length() - 32);
		resultado = Integer.parseInt(mult, 2);
	}

	@Override
	public void memory(MemoriaDados memoria) {
		// Mul não faz nada com memory
	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco, int valor) {
		banco.writeRegister(rdCode, resultado);
	}

}
