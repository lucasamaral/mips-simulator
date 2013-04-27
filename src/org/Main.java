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
		while(!p.isFinished()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		p.gerarLog();
		System.out.println("Projeto Paulo Andr��");
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
		return GeradorInstrucoesPrograma.gerarProgramaPadrao();
	}

	private static JFrame criaFrame() {
		JFrame f = new JFrame("MIPS Simulator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return f;
	}
}
