package org.instrucoes.Itype;

import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
	}


}
