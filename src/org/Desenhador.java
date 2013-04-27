package org;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Desenhador extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Processador p;
	
	// Botoes de controle
	private JButton botaoProximo = new JButton("Próximo");
	private JButton botaoRodar = new JButton("Rodar");
	private JButton botaoPausar = new JButton("Pausar");
	private JButton botaoAbrir = new JButton("Abrir");
	
	// Id. de instruções
	private JLabel idInstIF = new JLabel();
	private JLabel idInstDIRF = new JLabel();
	private JLabel idInstEX = new JLabel();
	private JLabel idInstMEM = new JLabel();
	private JLabel idInstWB = new JLabel();
	
	
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
		
		for (int i = 0; i < 4; i++) {
			endRecentes[i] = new JLabel();
			valRecentes[i] = new JLabel();
		}
		
		for (int i = 0; i < 32; i++)
			registradores[i] = new JLabel();
		
		setLayout(new GridBagLayout());
		c.insets = insets;

		// todos os botoes na primeira linha
		c.gridy = 0;
		c.gridwidth = 2;
		add(botaoProximo, c);
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
		add(idInstIF, c);
		add(idInstDIRF, c);
		add(idInstEX, c);
		add(idInstMEM, c);
		add(idInstWB, c);
		
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
		c.insets = new Insets(20, 0, 0, 0);
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
			add(endRecentes[i], c);
			add(valRecentes[i], c);
			System.out.println(c.gridy);
		}
		
		// Informacoes
		c.gridy = 9;
		c.gridx = 6;
		add(new JLabel("Clock corrente"), c);
		add(clock, c);
		
		c.gridy++;
		add(new JLabel("PC"), c);
		add(pc, c);
		
		c.gridy++;
		add(new JLabel("Número de instruções concluídas"), c);
		add(numInstConcluidas, c);
		
		c.gridy++;
		add(new JLabel("Produtividade do pipeline"), c);
		add(produtividade, c);
		
		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		add(new JLabel(""), c);
		c.insets = insets;
		
		// Registradores
		c.gridy++;
		c.gridx = 0;
		add(new JLabel("Registradores"), c);
		
		c.gridwidth = 1;
		for (int i = 0; i < 32; i++) {
			c.gridx = (int) Math.floor(i / 8) * 2;
			c.gridy = 15 + i % 8;
			add(new JLabel("R" + i), c);
		}
		
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