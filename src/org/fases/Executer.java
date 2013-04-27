package org.fases;

import org.Processador;
import org.latches.LatchEXMEM;
import org.latches.LatchIDEX;

public class Executer extends FasePadrao {

	private LatchIDEX idEx;
	private LatchEXMEM exMem;
	private int valorLidoRtParaSalvarNaMemoria;
	private int valorInicialDeClocks;

	public Executer(Processador p, LatchIDEX idEx, LatchEXMEM exMem) {
		super(p);
		this.idEx = idEx;
		this.exMem = exMem;
	}

	@Override
	public void executarPasso1() {
		if (instrucaoAtual != null) {
			instrucaoAtual.getInstrucao().decrementarNumerodeClocks();
		}
	}

	@Override
	public void executarPasso2() {
		if (instrucaoAtual != null
				&& instrucaoAtual.getInstrucao().getNumeroClocks() == valorInicialDeClocks - 1) {
			exMem.setResultadoULA(instrucaoAtual.getResultadoULA(processador));
			exMem.setZeroULA(instrucaoAtual.getCondicaoULA(processador));
			exMem.setEnderecoSomado(instrucaoAtual
					.getResultadoULAEndereco(processador));
			// Adicionado por Assis
			exMem.setValorEscreverNaMemoria(valorLidoRtParaSalvarNaMemoria);
		}
		if (instrucaoAtual != null
				&& instrucaoAtual.getInstrucao().getNumeroClocks() < 1) {
			exMem.adicionarInstrucao(instrucaoAtual);
			instrucaoAtual = null;
		}
	}

	@Override
	public void carregarSinais() {
		if (instrucaoAtual == null) {
			instrucaoAtual = idEx.pegarInstrucao();
			if (instrucaoAtual != null)
				valorInicialDeClocks = instrucaoAtual.getInstrucao()
						.getNumeroClocks();
			valorLidoRtParaSalvarNaMemoria = idEx
					.getValorLidoRtParaSalvarNaMemoria();
		}
		if (instrucaoAtual != null) {
			switch (instrucaoAtual.getType()) {
			case RTYPE:
				processador.setSinal("ALUOp1", true);
				processador.setSinal("ALUOp2", false);
				processador.setSinal("ALUSrc", false);
				processador.setSinal("regDst", true);
				break;
			case ITYPE:
				processador.setSinal("ALUSrc", true);
				processador.setSinal("regDst", false);
			default:
				break;
			}
			switch (instrucaoAtual.getCodigo()) {
			case LW:
				processador.setSinal("ALUOp1", false);
				processador.setSinal("ALUOp2", false);
				break;
			case SW:
				processador.setSinal("ALUOp1", false);
				processador.setSinal("ALUOp2", false);
				break;
			case BEQ:
				processador.setSinal("ALUOp1", false);
				processador.setSinal("ALUOp2", true);
				break;
			default:
				break;
			}
		}
	}

}
