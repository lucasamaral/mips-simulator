package org.instrucoes.Itype;

import org.Processador;
import org.instrucoes.TipoInstrucao;

public class InstrucaoBle extends InstrucaoItype {

	public InstrucaoBle(String entrada) {
		super(entrada);
		tipo = TipoInstrucao.BLE;
	}

	@Override
	public void executar(Processador proc) {
		// TODO Auto-generated method stub

	}

}
