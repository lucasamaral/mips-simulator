package org.latches;

public class LatchIDEX extends Latch {
	private int valorLidoRtParaSalvarNaMemoria;

	public int getValorLidoRtParaSalvarNaMemoria() {
		return valorLidoRtParaSalvarNaMemoria;
	}

	public void setValorLidoRtParaSalvarNaMemoria(int valorLidoRt) {
		this.valorLidoRtParaSalvarNaMemoria = valorLidoRt;
	}

	@Override
	public void limpar() {
		super.limpar();
		valorLidoRtParaSalvarNaMemoria = 0;
	}

}
