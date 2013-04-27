package org;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.instrucoes.InstrucaoWrapper;

public class Desenhador extends JPanel {
	private static final long serialVersionUID = 1L;
	private Processador p;
	
	// Controle do programa
	private boolean run = false;
	
	// Botoes de controle
	private JButton botaoProximo = new JButton("Próximo");
	private JButton botaoRodar = new JButton("Rodar");
	private JButton botaoPausar = new JButton("Pausar");
	private JButton botaoAbrir = new JButton("Abrir");
	
	// Id. de instruções
	private JLabel[] fases = new JLabel[5];
	
	// Sinais de controle
	private JLabel regDst = new JLabel();
	private JLabel ALUOp1 = new JLabel();
	private JLabel ALUOp2 = new JLabel();
	private JLabel ALUSrc = new JLabel();
	
	private JLabel branch = new JLabel();
	private JLabel memRead = new JLabel();
	private JLabel memWrite = new JLabel();
	
	private JLabel regWrite = new JLabel();
	private JLabel memToReg = new JLabel();
	
	// Memoria recente usada
	private JLabel[] endRecentes = new JLabel[4];
	private JLabel[] valRecentes = new JLabel[4];
	
	// Informacoes
	private JLabel clock = new JLabel();
	private JLabel pc = new JLabel();
	private JLabel numInstConcluidas = new JLabel();
	private JLabel produtividade = new JLabel();
	
	// Registradores
	private JLabel[] registradores = new JLabel[32];
	

	public Desenhador(Processador p) {
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = new Insets(5, 10, 5, 10);
		this.p = p;
		
		setLayout(new GridBagLayout());
		c.anchor = GridBagConstraints.WEST;
		c.insets = insets;

		// todos os botoes na primeira linha
		c.gridy = 0;
		c.gridwidth = 2;
		botaoProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run = false;
				update();
			}
		});
		add(botaoProximo, c);
		botaoRodar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run = true;
				update();
			}
		});
		add(botaoRodar, c);
		add(botaoPausar, c);
		add(botaoAbrir, c);
		
		c.anchor = GridBagConstraints.WEST;
		
		// Id. das instruções
		c.gridy++;
		add(new JLabel("Id. da Inst. em IF"), c);
		add(new JLabel("Id. da Inst. em DI/RF"), c);
		add(new JLabel("Id. da Inst. em EX"), c);
		add(new JLabel("Id. da Inst. em MEM"), c);
		add(new JLabel("Id. da Inst. em WB"), c);
		
		// Labels dos Id. das instruçoes
		c.gridy++;
		for (int i = 0; i < 5; i++) {
			fases[i] = new JLabel();
			add(fases[i], c);
		}
		
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 1;
		add(new JLabel("RegDst"), c);
		c.gridx = GridBagConstraints.RELATIVE;
		add(regDst, c);
		add(new JLabel("Branch"), c);
		add(branch, c);
		add(new JLabel("RegWrite"), c);
		add(regWrite, c);
		c.gridy++;
		c.gridx = 4;
		add(new JLabel("ALUOp1"), c);
		c.gridx = GridBagConstraints.RELATIVE;
		add(ALUOp1, c);
		add(new JLabel("MemRead"), c);
		add(memRead, c);
		add(new JLabel("MemToReg"), c);
		add(memToReg, c);
		c.gridy++;
		c.gridx = 4;
		add(new JLabel("ALUOp2"), c);
		c.gridx = GridBagConstraints.RELATIVE;
		add(ALUOp2, c);
		add(new JLabel("MemWrite"), c);
		add(memWrite, c);
		c.gridy++;
		c.gridx = 4;
		add(new JLabel("ALUSrc"), c);
		add(ALUSrc, c);
		
		// Separador
		c.insets = new Insets(10, 0, 0, 0);
		c.gridy++;
		add(new JLabel(""), c);
		c.insets = insets;
		
		// Memoria recente usada
		c.gridwidth = 2;
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridy = 9;
		add(new JLabel("Memória recente usada"), c);
		c.gridy++;
		add(new JLabel("Endereço"), c);
		add(new JLabel("Valor"), c);
		
		for (int i = 0; i < 4; i++) {
			c.gridy++;
			endRecentes[i] = new JLabel();
			valRecentes[i] = new JLabel();
			add(endRecentes[i], c);
			add(valRecentes[i], c);
		}
		
		// Informacoes
		c.gridy = 9;
		c.gridx = 6;
		add(new JLabel("Clock corrente:"), c);
		c.gridx = 8;
		add(clock, c);
		
		c.gridy++;
		c.gridx = 6;
		add(new JLabel("PC:"), c);
		c.gridx = 8;
		add(pc, c);
		
		c.gridy++;
		c.gridx = 6;
		add(new JLabel("Número de instruções concluídas:"), c);
		c.gridx = 8;
		add(numInstConcluidas, c);
		
		c.gridy++;
		c.gridx = 6;
		add(new JLabel("Produtividade do pipeline:"), c);
		c.gridx = 8;
		add(produtividade, c);
		
		// Registradores
		c.gridy = 15;
		c.gridx = 0;
		c.insets = new Insets(15, 10, 0, 0);
		add(new JLabel("Registradores"), c);
		c.insets = insets;
		
		c.gridwidth = 1;
		for (int i = 0; i < 32; i++) {
			c.gridx = (int) Math.floor(i / 8) * 2;
			c.gridy = 16 + i % 8;
			add(new JLabel("R" + i), c);
			c.gridx++;
			registradores[i] = new JLabel();
			add(registradores[i], c);
		}
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if (p.isFinished())
			botaoProximo.setEnabled(false);
		
		for (int i = 0; i < 5; i++) {
			InstrucaoWrapper inst = p.fases[i].getInstrucaoAtual();
			if (inst == null)
				fases[i].setText("NOP");
			else
				fases[i].setText(inst.getDesc());
		}
		
		int clock = p.getClock();
		int numInstConcluidas = p.instrucoesCompletadas.size();
		float produtividade = clock > 0 ? (float)numInstConcluidas/clock : 0;
		this.clock.setText(String.valueOf(clock));
		this.pc.setText(String.valueOf(p.getPc()));
		this.numInstConcluidas.setText(String.valueOf(numInstConcluidas));
		this.produtividade.setText(String.format("%.5f", produtividade));
		
		for (int i = 0; i < 32; i++)
			registradores[i].setText(String.valueOf(p.pegardosRegistradores(Integer.toBinaryString(i))));
		
		Iterator<Integer> endRecentes = p.memoria.getUltimosEnderecos();
		for (int i = 0; i < 4; i++) {
			if (!endRecentes.hasNext())
				break;
			int mem = endRecentes.next();
			this.endRecentes[i].setText(String.valueOf(mem));
			this.valRecentes[i].setText(String.valueOf(p.memoria.getValue(mem)));
		}
	}
	
	public void update() {
		p.step();
		
		repaint();
	}
}