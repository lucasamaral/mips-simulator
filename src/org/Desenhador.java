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

	BufferedImage screen;
	Graphics2D graph;
	Processador p;

	public Desenhador(Processador p) {
		this.p = p;
		Dimension d = new Dimension(500, 500);
		screen = new BufferedImage((int) d.getWidth(), (int) d.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		JButton proximo = new JButton("Next");
		proximo.addActionListener(this);
		add(proximo);
		graph = (Graphics2D) screen.getGraphics();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void paint(Graphics g) {
		desenhar(g);
		g.drawImage(screen, 30, 20, null);
	}

	private void desenhar(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.step();
		repaint();
	}
}