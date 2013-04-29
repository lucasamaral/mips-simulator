package org.instrucoes.Itype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoAddi extends InstrucaoItype {

	public InstrucaoAddi(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADDI;
	}
	
	@Override
	public List<Integer> getDependenciasWrite() {
		List<Integer> lista = new ArrayList<>(3);
		lista.add(Integer.parseInt(rtCode, 2));
		return lista;
	}

	@Override
	public List<Integer> getDependenciasRead() {
		List<Integer> lista = new ArrayList<>(3);
		lista.add(Integer.parseInt(rsCode, 2));
		return lista;
	}

	@Override
	public void writeBack(Processador banco, int valorULA, int valorMem) {
		banco.carregarNosRegistradores(rtCode, valorULA);
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int soma = proc.pegardosRegistradores(rsCode)
				+ analisarString(immCode);
		return soma;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(int pcAtual, Processador proc) {
		return 0;
	}

}
