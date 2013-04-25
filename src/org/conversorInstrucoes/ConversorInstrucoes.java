package org.conversorInstrucoes;

import org.instrucoes.Instrucao;
import org.instrucoes.InstrucaoAddi;
import org.instrucoes.InstrucaoBeq;
import org.instrucoes.InstrucaoBle;
import org.instrucoes.InstrucaoBne;
import org.instrucoes.InstrucaoJmp;
import org.instrucoes.InstrucaoLw;
import org.instrucoes.InstrucaoNop;
import org.instrucoes.InstrucaoSw;
import org.instrucoes.Rtype.InstrucaoAdd;
import org.instrucoes.Rtype.InstrucaoMul;

public class ConversorInstrucoes {

	public static Instrucao converterInstrucao(String instrucao) {
		switch (instrucao.substring(0, 6)) {
		case "000000":
			switch (instrucao.substring(26,32)) {
			case "100000":	
				return new InstrucaoAdd(instrucao);
			case "011000":
				return new InstrucaoMul(instrucao);
			}
		case "001000":
			return new InstrucaoAddi(instrucao);
		case "000101":
			return new InstrucaoBeq(instrucao);
		case "000111":
			return new InstrucaoBle(instrucao);
		case "000100":
			return new InstrucaoBne(instrucao);
		case "000010":
			return new InstrucaoJmp(instrucao);
		case "100011":
			return new InstrucaoLw(instrucao);
		case "101011":
			return new InstrucaoSw(instrucao);
		default:
			return new InstrucaoNop(instrucao);
		}
	}

}
