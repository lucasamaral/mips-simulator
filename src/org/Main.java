package org;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static JPanel container;

	public static void main(String[] args) {
		String[] instrucoes = gerarAsInstrucoes();
		MemoriaInstrucoes memIns = new MemoriaInstrucoes(instrucoes);
		Processador p = new Processador(new MemoriaDados(), memIns);
		inicializarInterface(p);
		System.out.println("Projeto Paulo André");
	}

	private static void inicializarInterface(Processador p) {
		Desenhador d = new Desenhador(p);
		JFrame topFrame = criaFrame();
		container = new JPanel();
		container.add(d);
		topFrame.add(container);
		topFrame.pack();
		topFrame.setSize(new Dimension(800, 600));
		topFrame.setVisible(true);
	}

	private static String[] gerarAsInstrucoes() {
		return GeradorInstrucoesPrograma.gerarProgramaPadrao();
	}

	private static JFrame criaFrame() {
		JFrame f = new JFrame("MIPS Simulator");
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}
		});
		return f;
	}
}
