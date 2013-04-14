package org.fases;
import org.instrucoes.Instrucao;



public interface Fase {
	public void receber(Instrucao ins);
	public void executar();
	public Instrucao passarInstrucao();
	public boolean isReady();

}
