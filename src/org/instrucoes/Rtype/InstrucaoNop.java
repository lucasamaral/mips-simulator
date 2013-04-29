package org.instrucoes.Rtype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoNop extends InstrucaoRtype {

	public InstrucaoNop(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.NOP;
	}

	@Override
	public void writeBack(Processador banco, int valorULA, int valorMEM) {

	}

	@Override
	public int getResultadoULA(Processador proc) {
		return 0;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public List<Integer> getDependenciasWrite() {
		List<Integer> lista = new ArrayList<>(3);
		return lista;
	}

	@Override
	public List<Integer> getDependenciasRead() {
		List<Integer> lista = new ArrayList<>(3);
		return lista;
	}
}
