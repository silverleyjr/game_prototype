import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.security.SecureRandom;
import javax.swing.*;
import java.awt.Color;
//System.out.println("ola você ira jogar Craps um jogo de dados de cassino");
//System.out.println("funciona assim você joga dois dados e faz a soma deles");
//System.out.println("se o numero da soma for 7 ou 11 você ganha instantaneamente");
//System.out.println("se for 2, 3 ou 12 perde instantaneamente");
//System.out.println("se não for nenhum dos casos o jogo continua");
//System.out.println("e os numeros jogados se tornam a meta se você acertar"); 
//System.out.println("o mesmo numero da soma de novo antes de somar 7 você ganha");
//se não for nenhum dos casos o jogo continua \ne os numeros jogados se tornam a meta se você acertar \no mesmo numero da soma de novo antes de somar 7 você ganha

public class gui implements ActionListener {

	public static int Soma = 0;
	public static int Meta = 0;
	public static Status gameStatus;
	// ImageIcon mesaCasino;
	JButton button1;
	JButton button2;
	JButton button3;
	JLabel label;
	JLabel label2;
	// JLabel introducao;
	// JLabel background;
	JPanel panel;
	JFrame frame;
	// cria o estado enum do jogo
	private static final SecureRandom randomNumber = new SecureRandom();

	private enum Status {
		CONTINUE, WON, LOST
	};

	// constantes para primeiro lançamento
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	public static void main(String[] args) {
		new gui();

		// switch (Soma) {
		// case SEVEN:
		// case YO_LEVEN:
		// gameStatus = Status.WON;
		// break;
		// case SNAKE_EYES:
		// case TREY:
		// case BOX_CARS:
		// gameStatus = Status.LOST;
		// break;
		// default:
		// gameStatus = Status.CONTINUE;
		// Meta = Soma;
		// System.out.printf("A meta é %d%n", Meta);
		// break;
		// }

		// while (gameStatus == Status.CONTINUE) {
		// Soma = RolarDados();
		// if (Soma == Meta)
		// gameStatus = Status.WON;
		// else if (Soma == SEVEN)
		// gameStatus = Status.LOST;
		// }

		// if (gameStatus == Status.WON)
		// System.out.println("Parabens você ganhou");
		// else
		// System.out.println("Você perdeu");
	}

	public gui() {
		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton("jogar os dados");
		button2 = new JButton("jogar os dados denovo");
		button3 = new JButton("sair");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		// button1.setBounds(270, 230, 150, 40);
		// mesaCasino = new ImageIcon("mesaCasino.jpg");
		// introducao = new JLabel(
		// "ola você ira jogar Craps um jogo de dados de cassino funciona assim você
		// joga dois dados e faz a soma deles \nse o numero da soma for 7 ou 11 você
		// ganha instantaneamente \nse for 2, 3 ou 12 perde instantaneamente \nse não
		// for nenhum dos casos o jogo continua \ne os numeros jogados se tornam a meta
		// se você acertar \no mesmo numero da soma de novo antes de somar 7 você
		// ganha");
		label = new JLabel("o numero resultado da soma dos dados é: ___");
		// introducao.setForeground(Color.decode("#d6d7fe"));
		// introducao.setBounds(215, 10, 400, 200);
		// label.setForeground(Color.decode("#d6d7fe"));
		// label.setBounds(215, 100, 300, 100);
		// background = new JLabel(mesaCasino);
		panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(button1);
		// panel.add(background);
		// background.setLayout(null);
		// background.add(introducao);
		// background.add(label);
		// background.add(button1);
		// frame.setContentPane(background);
		// frame.setSize(mesaCasino.getIconWidth(), mesaCasino.getIconHeight());
		frame.setSize(800, 800);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CrapsGUI");
		frame.pack();
		frame.setVisible(true);
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			Soma = RolarDados();
			label.setText("resultado da soma dos dados é: " + Soma);
			switch (Soma) {
				case SEVEN:
				case YO_LEVEN:
					gameStatus = Status.WON;
					label2 = new JLabel("parabens voce ganhou");
					panel.add(button3);
					panel.add(label2);
					panel.remove(button1);
					frame.setVisible(true);
					break;
				case SNAKE_EYES:
				case TREY:
				case BOX_CARS:
					gameStatus = Status.LOST;
					label2 = new JLabel("infelizmente voce perdeu");
					panel.add(button3);
					panel.add(label2);
					panel.remove(button1);
					frame.setVisible(true);
					break;
				default:
					gameStatus = Status.CONTINUE;
					Meta = Soma;
					label2 = new JLabel("sua meta agora é: " + Meta);
					System.out.printf("A meta é %d%n", Meta);
					Soma = 0;
					panel.add(button2);
					panel.add(label2);
					panel.remove(button1);
					frame.setVisible(true);
					break;
			}
		} else if (e.getSource() == button2) {
			Soma = RolarDados();
			label.setText("resultado da soma dos dados é: " + Soma);
			if (Soma == Meta) {
				gameStatus = Status.WON;
				panel.add(button3);
				label2.setText("parabens voce ganhou");
				panel.add(label2);
				panel.remove(button2);
				frame.setVisible(true);
			} else if (Soma == SEVEN) {
				gameStatus = Status.LOST;
				panel.add(button3);
				label2.setText("infelizmente voce perdeu");
				panel.add(label2);
				panel.remove(button2);
				frame.setVisible(true);
			} else {
				label2.setText("sua meta nao foi atingida sua meta é: " + Meta);
				panel.add(label2);
				frame.setVisible(true);
			}

		} else if (e.getSource() == button3) {
			System.exit(0);
		}
	}

	// metodo para rolar dados
	public static int RolarDados() {
		int dado1 = 1 + randomNumber.nextInt(6);
		int dado2 = 1 + randomNumber.nextInt(6);
		int SomaDosDados = dado1 + dado2;
		System.out.printf("O dado rolado foi %d + %d = %d%n", dado1, dado2, SomaDosDados);
		return SomaDosDados;
	}
}
