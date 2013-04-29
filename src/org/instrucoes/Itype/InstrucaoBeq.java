package org.instrucoes.Itype;

import java.util.ArrayList;
import java.util.List;

import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoBeq extends InstrucaoItype {

	public InstrucaoBeq(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BEQ;
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
		return rsValue == rtValue;
	}

	@Override
	public int getResultadoULAEndereco(Processador proc) {
		return proc.getPc() + 4 + analisarString(immCode);
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
	
	public boolean getALUOp1(){
		return false;
	}

	public boolean getALUOp2(){
		return true;
	}

}
