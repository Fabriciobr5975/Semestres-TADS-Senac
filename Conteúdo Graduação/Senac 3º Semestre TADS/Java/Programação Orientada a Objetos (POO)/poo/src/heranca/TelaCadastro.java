package heranca;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame {
	// Label
	private JLabel id;
	private JLabel nome;
	
	// TextField
	private JTextField campoId;
	private JTextField campoNome;
	
	// Button
	private JButton botaoSalvar;
	private JButton botaoExcluir;
	private JButton botaoLimpar;
	
	public TelaCadastro() {
		// Adicionando as Labels na tela
		id = new JLabel("ID:");
		id.setBounds(10, 30, 150, 30);
		
		nome = new JLabel("NOME:");
		nome.setBounds(10, 100, 150, 30);
		
		// Adicionando os textfild na tela ao lado das labels
		campoId = new JTextField();
		campoId.setBounds(60, 30, 300, 30);
		
		campoNome = new JTextField();
		campoNome.setBounds(60, 100, 300, 30);
		
		// Adicionando os button
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(20, 200, 100, 30);
		
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(140, 200, 100, 30);
		
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(260, 200, 100, 30);
		
		// Adicionando os elementos na tela;
		getContentPane().setLayout(null);
		getContentPane().add(id);
		getContentPane().add(nome);
		getContentPane().add(campoId);
		getContentPane().add(campoNome);
		getContentPane().add(botaoSalvar);
		getContentPane().add(botaoExcluir);
		getContentPane().add(botaoLimpar);
		
		setTitle("Cadastro de Produtos:");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 200, 400, 300);
		setVisible(true);
	}
}
