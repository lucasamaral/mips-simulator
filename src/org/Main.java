package org;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static JPanel container;

	public static void main(String[] args) throws IOException {
		String[] instrucoes = gerarAsInstrucoes();
		MemoriaInstrucoes memIns = new MemoriaInstrucoes(instrucoes);
		MemoriaDados mem = new MemoriaDados();
		mem.carregarMemoria("dados_AXPY.dados");
		Processador p = new ProcessadorBypassing(mem, memIns);
		p.initialStep();
		inicializarInterface(p);
		while(!p.isFinished()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		p.gerarLog();
	}

	private static void inicializarInterface(Processador p) {
		Desenhador d = new Desenhador(p);
		JFrame topFrame = criaFrame();
		container = new JPanel();
		container.add(d);
		topFrame.add(container);
		topFrame.pack();
		topFrame.setSize(new Dimension(800, 700));
		topFrame.setVisible(true);
	}

	private static String[] gerarAsInstrucoes() {
		return GeradorInstrucoesPrograma.gerarProgramadeArquivo("instrucoes.txt");
	}

	private static JFrame criaFrame() {
		JFrame f = new JFrame("MIPS Simulator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return f;
	}
}
