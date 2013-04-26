package org.latches;

public class LatchEXMEM extends Latch {

	private boolean zeroULA;
	private int possivelProximoEndereco;
	private int resultadoULA;
	private int valorEscreverNaMemoria;

	public int getResultadoULA() {
		return resultadoULA;
	}

	public int getProximoEndereco() {
		return possivelProximoEndereco;
	}

	public boolean getZeroULA() {
		return zeroULA;
	}

	public void setResultadoULA(int resultadoULA) {
		this.resultadoULA = resultadoULA;

	}

	public void setZeroULA(boolean condicaoULA) {
		zeroULA = condicaoULA;
	}

	public void setEnderecoSomado(int resultadoULAEndereco) {
		possivelProximoEndereco = resultadoULAEndereco;
	}

	public int getValorEscreverNaMemoria() {
		return valorEscreverNaMemoria;
	}

	public void setValorEscreverNaMemoria(int valorLidoDeRt) {
		this.valorEscreverNaMemoria = valorLidoDeRt;
	}

	@Override
	public void limpar() {
		super.limpar();
		zeroULA = false;
		possivelProximoEndereco = 0;
		resultadoULA = 0;
		valorEscreverNaMemoria = 0;
	}

}
