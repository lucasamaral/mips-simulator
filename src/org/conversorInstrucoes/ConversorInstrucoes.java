package org.conversorInstrucoes;

import org.instrucoes.Instrucao;
import org.instrucoes.InstrucaoJmp;
import org.instrucoes.Itype.InstrucaoAddi;
import org.instrucoes.Itype.InstrucaoBeq;
import org.instrucoes.Itype.InstrucaoBle;
import org.instrucoes.Itype.InstrucaoBne;
import org.instrucoes.Itype.InstrucaoLw;
import org.instrucoes.Itype.InstrucaoSw;
import org.instrucoes.Rtype.InstrucaoAdd;
import org.instrucoes.Rtype.InstrucaoMul;
import org.instrucoes.Rtype.InstrucaoNop;
import org.instrucoes.Rtype.InstrucaoSub;

public class ConversorInstrucoes {

	public static Instrucao converterInstrucao(String instrucao) throws Exception {
		switch (instrucao.substring(0, 6)) {
		case "000000":
			switch (instrucao.substring(26,32)) {
			case "100000":	
				return new InstrucaoAdd(instrucao);
			case "011000":
				return new InstrucaoMul(instrucao);
			case "100010":
				return new InstrucaoSub(instrucao);
			case "000000":
				return new InstrucaoNop(instrucao);
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
			throw new Exception("Instrução com código não suportado");
		}
	}

}
