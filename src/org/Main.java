package org;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static JPanel container;

	public static void main(String[] args) {
		final JFileChooser fc = new JFileChooser();
		File file = null;
		int returnVal = fc.showOpenDialog(criaFrame());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        } else {
        }
        String[] instrucoes = gerarAsInstrucoes(file.getPath());
		MemoriaInstrucoes memIns = new MemoriaInstrucoes(instrucoes);
		MemoriaDados mem = new MemoriaDados();
		try {
			mem.carregarMemoria("dados_AXPY.dados");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		topFrame.setSize(new Dimension(900, 700));
		topFrame.setVisible(true);
	}

	private static String[] gerarAsInstrucoes(String filename) {
		GeradorArquivoInstrucoes.gerarArquivo(filename, "compilado.txt");
		return GeradorInstrucoesPrograma.gerarProgramadeArquivo("compilado.txt");
	}

	private static JFrame criaFrame() {
		JFrame f = new JFrame("MIPS Simulator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return f;
	}
}
