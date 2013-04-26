package org.latches;

public class LatchMEMWB extends Latch {

	private int resultadoULA;
	private int resultadoMem;
	
	public int getResultadoULA() {
		return resultadoULA;
	}

	public int getResultadoMem() {
		return resultadoMem;
	}
	
	public void setResultadoULA(int valor){
		resultadoULA = valor;
	}
	
	public void setResultadoMem(int valor){
		resultadoMem = valor;
	}

}
