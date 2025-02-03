package bancointerface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MeuFrame extends JFrame implements ActionListener {
	JButton meuBotao;

	public MeuFrame() {
		// meu botão
		meuBotao = new JButton();
		meuBotao.setBounds(20, 20, 100, 30);
		meuBotao.setText("Meu Botão");
		meuBotao.addActionListener(this);
		meuBotao.addActionListener(new MeuActionListener());

		/*
		 * Criando uma classe anônima que implementa ActionListener, instanciando uma
		 * classe dentro do parâmetro
		 */
		meuBotao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cliquei no botão pela 3º vez");

			}
		});
		
		// Expressão Lambda
		meuBotao.addActionListener(e -> {
			System.out.println("Cliquei no botão com expressão lambda");
		});

		meuBotao.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				meuBotao.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				meuBotao.setVisible(true);
			}
		});

		// frame
		getContentPane().setLayout(null);
		getContentPane().add(meuBotao);
		setBounds(300, 100, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MeuFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cliquei no botão");

	}

	public class MeuActionListener implements ActionListener {
		// Ele vai empilhando as ações;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cliquei no botão através de uma classe");
		}

	}
}
