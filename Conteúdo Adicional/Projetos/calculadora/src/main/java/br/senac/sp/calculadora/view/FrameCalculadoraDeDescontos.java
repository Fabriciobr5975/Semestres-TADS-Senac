package br.senac.sp.calculadora.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class FrameCalculadoraDeDescontos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCalculadoraDeDescontos frame = new FrameCalculadoraDeDescontos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCalculadoraDeDescontos() {
		setTitle("Calculadora de Descontos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		
		JMenuBar mnuBarraMenu = new JMenuBar();
		setJMenuBar(mnuBarraMenu);
		
		JMenu mnuOpcoes = new JMenu("Calculadora");
		mnuBarraMenu.add(mnuOpcoes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][grow]"));
		
		JLabel lblMensagem = new JLabel("Digite o que deseja Calcular: ");
		lblMensagem.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblMensagem, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 1 0,growx");
		
		JLabel lblPrecoTotal = new JLabel("Insira o Valor (R$):");
		lblPrecoTotal.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblPrecoTotal, "cell 0 2,alignx left");
		
		JFormattedTextField ftfValorTotal = new JFormattedTextField();
		panel_1.add(ftfValorTotal, "cell 1 2,growx");
		
		JLabel lblValorDesconto = new JLabel("Insira o Valor do Desconto :");
		lblValorDesconto.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblValorDesconto, "cell 0 3,alignx left");
		
		JFormattedTextField ftfValorDesconto = new JFormattedTextField();
		panel_1.add(ftfValorDesconto, "cell 1 3,growx");
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblResultado, "cell 0 5,alignx left");
		
		JFormattedTextField ftfResultadoDesconto = new JFormattedTextField();
		panel_1.add(ftfResultadoDesconto, "cell 1 5,growx");
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea, "cell 0 7 2 1,grow");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 4, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
	}

}
