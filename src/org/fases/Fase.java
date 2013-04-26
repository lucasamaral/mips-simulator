package org.fases;

public interface Fase {

	public boolean isReady();

	public boolean isWorking();

	public void executarPasso1();

	public void executarPasso2();

	public void carregarSinais();

}
