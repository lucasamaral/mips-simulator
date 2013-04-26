package org.instrucoes.Rtype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoAdd extends InstrucaoRtype {

	public InstrucaoAdd(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.ADD;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		int soma = proc.pegardosRegistradores(rsCode) + proc.pegardosRegistradores(rtCode);
		return soma;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		return false;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return 0;
	}
	
	@Override
	public List<Integer> getDependenciasWrite() {
		List<Integer> lista = new ArrayList<>(3);
		lista.add(Integer.parseInt(rdCode,2));
		return lista;
	}

	@Override
	public List<Integer> getDependenciasRead() {
		List<Integer> lista = new ArrayList<>(3);
		lista.add(Integer.parseInt(rsCode, 2));
		lista.add(Integer.parseInt(rtCode, 2));
		return lista;
	}
	

}
