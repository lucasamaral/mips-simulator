package org;

import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Desenhador extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private BufferedImage screen;
	private Graphics2D graph;
	private Processador p;
	
	// Botoes de controle
	private JButton botaoProximo = new JButton("Próximo");
	private JButton botaoRodar = new JButton("Rodar");
	private JButton botaoPausar = new JButton("Pausar");
	private JButton botaoAbrir = new JButton("Abrir");
	
	// Labels de informação
	private JLabel idInstIF = new JLabel();
	private JLabel idInstDIRF = new JLabel();
	private JLabel idInstEX = new JLabel();
	private JLabel idInstMEM = new JLabel();
	private JLabel idInstWB = new JLabel();

	public Desenhador(Processador p) {
		GridBagConstraints c = new GridBagConstraints();
		JLabel label;
		this.p = p;
		
		setLayout(new GridBagLayout());
		c.insets = new Insets(5, 10, 5, 10);
		c.fill = GridBagConstraints.BOTH;

		// todos os botoes na primeira linha
		c.gridwidth = 2;
		add(botaoProximo, c);
		add(botaoRodar, c);
		add(botaoPausar, c);
		add(botaoAbrir, c);
		
		// Id. das instruções
		c.gridy = 1;
		label = new JLabel("Id. da Inst. em IF");
		add(label, c);

		label = new JLabel("Id. da Inst. em DI/RF");
		add(label, c);

		label = new JLabel("Id. da Inst. em EX");
		add(label, c);

		label = new JLabel("Id. da Inst. em MEM");
		add(label, c);
		
		label = new JLabel("Id. da Inst. em WB");
		add(label, c);
		
		// Labels dos Id. das instruçoes
		c.gridy = 2;
		add(idInstIF, c);
		add(idInstDIRF, c);
		add(idInstEX, c);
		add(idInstMEM, c);
		add(idInstWB, c);
		
		c.insets = new Insets(20, 0, 0, 0);
		c.gridy = 3;
		label = new JLabel("Memória recente usada");
		add(label, c);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0;
		while(i < 25 && !p.isFinished()){
			p.step();
			i++;
		}
		if(p.isFinished()){
			botaoProximo.setEnabled(false);
		}
		repaint();
	}
}