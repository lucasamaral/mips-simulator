package org;

import java.util.LinkedList;
import java.util.List;

import org.fases.Executer;
import org.fases.Fase;
import org.fases.InstructionFetch;
import org.fases.MemoryAccess;
import org.fases.RegisterDecoder;
import org.fases.WriteBack;
import org.instrucoes.InstrucaoWrapper;
import org.latches.Latch;
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;
import org.latches.LatchIFID;
import org.latches.LatchMEMWB;

public class Processador {
	private MemoriaDados memoria;
	private BancodeRegistradores registradores;
	private MemoriaInstrucoes instrucoes;
	private List<InstrucaoWrapper> instrucoesCompletadas = new LinkedList<>();
	private Latch ifId;
	private LatchIDEX idEx;
	private LatchEXMEM exMem;
	private LatchMEMWB memWb;
	private Fase[] fases;
	private boolean fimDePrograma = false;

	public Processador(MemoriaDados mem, MemoriaInstrucoes ins) {
		this.memoria = (mem);
		this.registradores = (new BancodeRegistradores());
		this.instrucoes = (ins);
		construirLatches();
		fases = construirFases();
	}

	private void construirLatches() {
		ifId = new LatchIFID();
		idEx = new LatchIDEX();
		exMem = new LatchEXMEM();
		memWb = new LatchMEMWB();
	}

	private Fase[] construirFases() {
		Fase[] res = new Fase[5];
		res[0] = new InstructionFetch(this, ifId);
		res[1] = new RegisterDecoder(this, ifId, idEx);
		res[2] = new Executer(this, idEx, exMem);
		res[3] = new MemoryAccess(this, exMem, memWb);
		res[4] = new WriteBack(this, memWb);
		return res;
	}

	public void step() {
		for (int i = fases.length - 1; i >= 0; i--) {
			fases[i].executarPasso1();
		}
		for (int i = fases.length - 1; i >= 0; i--) {
			fases[i].executarPasso2();
		}
	}

	public boolean isFinished() {
		for (Fase f : fases) {
			if (!f.isReady() || f.isWorking())
				return false;
		}
		return !idEx.hasInstruction() && !exMem.hasInstruction()
				&& !memWb.hasInstruction() && !ifId.hasInstruction()
				&& fimDePrograma;
	}

	public void processar() {
		do {
			step();
			System.out.println("");
		} while (!isFinished());
	}

	public MemoriaDados getMemoria() {
		return memoria;
	}

	public BancodeRegistradores getRegistradores() {
		return registradores;
	}

	public MemoriaInstrucoes getInstrucoes() {
		return instrucoes;
	}

	public boolean isFimDePrograma() {
		return fimDePrograma;
	}

	public void sinalizarFimdePrograma() {
		this.fimDePrograma = true;
	}

}
