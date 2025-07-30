import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
//System.out.println("ola você ira jogar Craps um jogo de dados de cassino");
//System.out.println("funciona assim você joga dois dados e faz a soma deles");
//System.out.println("se o numero da soma for 7 ou 11 você ganha instantaneamente");
//System.out.println("se for 2, 3 ou 12 perde instantaneamente");
//System.out.println("se não for nenhum dos casos o jogo continua");
//System.out.println("e os numeros jogados se tornam a meta se você acertar"); 
//System.out.println("o mesmo numero da soma de novo antes de somar 7 você ganha");
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		soma = RolarDados();
//		label.setText("o numero da somas dos dados foi: " + soma);
//	}
//}
// teste do jogo craps baseado no livro da faculdade
// import para os numeros aleatorios seguros
import java.security.SecureRandom;

// criei a classe 
public class CrapsGUI implements ActionListener {

	int clicks = 0;
	JLabel label;
	JPanel panel;
	JFrame frame;

	public static void main(String[] args) {
		new CrapsGUI();
	}

	public CrapsGUI() {
		frame = new JFrame();
		panel = new JPanel();
		JButton button1 = new JButton("jogar os dados");
		button1.addActionListener(this);
		label = new JLabel("o numero da somas dos dados foi: ");
		panel.setBorder(BorderFactory.createEmptyBorder(1000, 1000, 1000, 1000));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(button1);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CrapsGUI");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clicks++;
		label.setText("o numero da somas dos dados foi: " + clicks);
	}

	// cria o estado enum do jogo
	//private static final SecureRandom randomNumber = new SecureRandom();

	//private enum Status {
	//	CONTINUE, WON, LOST
	//};

	//// constantes para primeiro lançamento
	//private static final int SNAKE_EYES = 2;
	//private static final int TREY = 3;
	//private static final int SEVEN = 7;
	//private static final int YO_LEVEN = 11;
	//private static final int BOX_CARS = 12;


//	public static void main(String[] args) {
//		new CrapsGUI();
//		int Meta = 0;
//		Status gameStatus;
//
//		int Soma = RolarDados();
//
//		switch (Soma) {
//			case SEVEN:
//			case YO_LEVEN:
//				gameStatus = Status.WON;
//				break;
//			case SNAKE_EYES:
//			case TREY:
//			case BOX_CARS:
//				gameStatus = Status.LOST;
//				break;
//			default:
//				gameStatus = Status.CONTINUE;
//				Meta = Soma;
//				System.out.printf("A meta é %d%n", Meta);
//				break;
//		}
//
//		while (gameStatus == Status.CONTINUE) {
//			Soma = RolarDados();
//			if (Soma == Meta)
//				gameStatus = Status.WON;
//			else if (Soma == SEVEN)
//				gameStatus = Status.LOST;
//		}
//
//		if (gameStatus == Status.WON)
//			System.out.println("Parabens você ganhou");
//		else
//			System.out.println("Você perdeu");
//	}
//
//	// metodo para rolar dados
//	public static int RolarDados() {
//		int dado1 = 1 + randomNumber.nextInt(6);
//		int dado2 = 1 + randomNumber.nextInt(6);
//		int SomaDosDados = dado1 + dado2;
//		System.out.printf("O dado rolado foi %d + %d = %d%n", dado1, dado2, SomaDosDados);
//		return SomaDosDados;
//	}

	//public CrapsGUI() {
	//	frame = new JFrame();
	//	panel = new JPanel();
	//	button1 = new JButton("os dados foram apertados: " + clicks);
	//	button1.addActionListener(this);
	//	label = new JLabel("lala");
	//	panel.setBorder(BorderFactory.createEmptyBorder(1000, 1000, 1000, 1000));
	//	panel.setLayout(new GridLayout(0, 1));
	//	panel.add(label);
	//	panel.add(button1);
	//	frame.add(panel, BorderLayout.CENTER);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.setTitle("CrapsGUI");
	//	frame.pack();
	//	frame.setVisible(true);
	//}

	//@Override
	//public void actionPerformed(ActionEvent e) {
	//	clicks++;
	//	label.setText("o numero da somas dos dados foi: " + clicks);
	//}
}
