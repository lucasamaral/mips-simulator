package org.instrucoes.Itype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;
import org.latches.LatchEXMEM;

public class InstrucaoSw extends InstrucaoItype {

	public InstrucaoSw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.SW;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int rsValue = proc.pegardosRegistradores(rsCode);
		return rsValue + Integer.parseInt(immCode, 2);
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return 0;
	}

	public void memory(int valor, Processador proc, LatchEXMEM exMem) {
		proc.carregarNaMemoria(valor, proc.pegardosRegistradores(rtCode));
	}

	@Override
	public List<Integer> getDependenciasWrite() {
		List<Integer> lista = new ArrayList<>(3);
		return lista;
	}

	@Override
	public List<Integer> getDependenciasRead() {
		List<Integer> lista = new ArrayList<>(3);
		lista.add(Integer.parseInt(rtCode, 2));
		lista.add(Integer.parseInt(rsCode, 2));
		return lista;
	}

}
