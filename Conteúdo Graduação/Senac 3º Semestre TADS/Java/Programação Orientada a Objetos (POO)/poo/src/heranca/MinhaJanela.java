package heranca;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MinhaJanela extends JFrame {
	private JButton meuBotao;
	private Font fonte;
	
	public MinhaJanela() {
		// Fonte
		fonte = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
		
		// Botão
		meuBotao = new JButton("Botão");
		meuBotao.setBounds(10, 10, 150, 30);
		meuBotao.setFont(fonte);
		
		// Adicionando componentes
		getContentPane().setLayout(null);
		getContentPane().add(meuBotao);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setTitle("Minha Janela");
		setResizable(false);
		setCursor(Cursor.HAND_CURSOR);
		//setExtendedState(MAXIMIZED_BOTH);
	}
}
