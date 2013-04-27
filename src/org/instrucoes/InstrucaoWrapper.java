package org.instrucoes;

import java.util.List;

import org.Processador;

public class InstrucaoWrapper {

	private String dado;
	private Instrucao instrucao;
	private int clockEntrada;
	
	public InstrucaoWrapper(String dado){
		this.dado = dado;
	}

	public String getDado() {
		return dado;
	}
	
	public String getDesc() {
		if (instrucao == null)
			return "NOP";
		return dado.substring(dado.indexOf(";") + 2);
	}

	public CodigoInstrucao getCodigo() {
		if(instrucao!=null)
			return instrucao.codigo;
		return CodigoInstrucao.NOP;
	}
	
	public String toString(){
		return getCodigo().name();
	}

	public Instrucao getInstrucao() {
		return instrucao;
	}

	public void setInstrucaoReal(Instrucao instrucaoReal) {
		this.instrucao = instrucaoReal;
	}

	public TipoInstrucao getType() {
		return instrucao.getType();
	}

	public void writeBack(Processador proc, int valorULA, int valorMEM) {
		instrucao.writeBack(proc, valorULA,valorMEM);
	}

	public boolean isBranch() {
		return instrucao.isBranch();
	}

	public int getResultadoULA(Processador proc) {
		return instrucao.getResultadoULA(proc);
	}

	public boolean getCondicaoULA(Processador proc) {
		return instrucao.getCondicaoULA(proc);
	}

	public int getResultadoULAEndereco(Processador proc) {
		return instrucao.getResultadoULAEndereco(proc);
	}

	public List<Integer> getDependenciasWrite() {
		return instrucao.getDependenciasWrite();
	}
	
	public List<Integer> getDependenciasRead() {
		return instrucao.getDependenciasRead();
	}

	public void setClockEntrada(int pc) {
		this.clockEntrada = pc;
		
	}

	public boolean getALUOp1() {
		return instrucao.getALUOp1();
	}

	public boolean getALUOp2() {
		// TODO Auto-generated method stub
		return instrucao.getALUOp2();
	}
}