package org;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Desenhador extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private BufferedImage screen;
	private Graphics2D graph;
	private Processador p;
	private JButton botaoProximo = new JButton("Next");

	public Desenhador(Processador p) {
		this.p = p;
		Dimension d = new Dimension(800, 800);
		screen = new BufferedImage((int) d.getWidth(), (int) d.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		botaoProximo.addActionListener(this);
		add(botaoProximo);
		graph = (Graphics2D) screen.getGraphics();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void paint(Graphics g) {
		desenhar(g);
	}

	private void desenhar(Graphics g) {
		// TODO Auto-generated method stub
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