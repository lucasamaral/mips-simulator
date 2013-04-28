package org.instrucoes.Itype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoBle extends InstrucaoItype {

	public InstrucaoBle(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BLE;
	}

	public boolean isBranch() {
		return true;
	}

	@Override
	public int getResultadoULA(Processador proc) {
		return 0;
	}

	@Override
	public boolean getCondicaoULA(Processador proc) {
		int rsValue = proc.pegardosRegistradores(rsCode);
		int rtValue = proc.pegardosRegistradores(rtCode);
		System.out.println(rsValue + " - " + rtValue);
		return rsValue <= rtValue;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		// Temporariamente mudando para seguir a documentacao do PA. Eu acho que
		// o certo era ser relativo mesmo
		return Integer.parseInt(immCode, 2);
	}

	@Override
	public List<Integer> getDependenciasWrite() {
		List<Integer> lista = new ArrayList<>(3);
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
