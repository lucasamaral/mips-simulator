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
		Desenhador d = new Desenhador(p);
		JFrame topFrame = criaFrame();
		container = new JPanel();
		container.add(d);
		topFrame.add(container);
		topFrame.pack();
		topFrame.setSize(new Dimension(500, 500));
		topFrame.setVisible(true);
		System.out.println("Projeto Paulo André");
	}

	private static String[] gerarAsInstrucoes() {
		return new String[] {
				"00100000000010100000000001100100 ;I1: addi R10,R0,100",
				"10101100000000000000000000011000			; I2: sw R0,24(R0)",
				"10101100000000000000000000011100			; I3: sw R0,28(R0)",
				"10001100000001100000000000011100			; I4: lw R6,28(R0)",
				"00000000110001100011100000011000			; I5: mul R7,R6,R6",
				"10001100000000010000000000011000			; I6: lw R1,24(R0)",
				"00000000001001110100100000100000			; I7: add R9,R1,R7",
				"10101100000010010000000000011000			; I8: sw R9,24(R0)",
				"00100000110001100000000000000001			; I9: addi R6,R6,1",
				"10101100000001100000000000011100			; I10: sw R6,28(R0)",
				"00011100110010100000000000001100			; I11: ble R6,R10,12" };
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
