package br.senac.sp.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.senac.sp.calculadora.service.CalculadoraService;
import br.senac.sp.calculadora.util.TelasUtil;

/**
 * Classe contendo a estrutura da calculadora simples. Essa classe tem os
 * componentes de uma calculadora simples, contendo as ações de somar, subtrair,
 * multiplicar, dividir, resto da divisão e calculos simples de porcentagem
 * 
 * @author Fabrício de Araújo Santana
 */
public class FrameCalculadora extends JFrame {

	// Atributos do Frame
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCabecalho;
	private BorderLayout painelPrincipal;
	private JTextField tfCampoVisualizacao;
	private JPanel panelBotoesCalculadora;
	private GroupLayout gl_panelCabecalho;

	// JButton para os itens dos Botão presentes na calculadora
	private JButton btnNumero0;
	private JButton btnNumero1;
	private JButton btnNumero2;
	private JButton btnNumero3;
	private JButton btnNumero4;
	private JButton btnNumero5;
	private JButton btnNumero6;
	private JButton btnNumero7;
	private JButton btnNumero8;
	private JButton btnNumero9;
	private JButton btnExpressaoNegativa;
	private JButton btnSimboloVirgula;
	private JButton btnLimpar;
	private JButton btnParenteses;
	private JButton btnPorcentagem;
	private JButton btnDivisao;
	private JButton btnMultiplicacao;
	private JButton btnSubtracao;
	private JButton btnSoma;
	private JButton btnRealizarCalculo;

	// Atributos adicionais
	private String expressaoNumerica;
	private char valorBotao;
	CalculadoraService calculadoraService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCalculadora frame = new FrameCalculadora();
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
	public FrameCalculadora() {
		calculadoraService = new CalculadoraService();

		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		TelasUtil.centralizarJFrame(this);

		try {
			this.setIconImage(TelasUtil.receberImageIconDoJFrame().getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setContentPane(contentPane);
		painelPrincipal = new BorderLayout(0, 0);

		contentPane.setLayout(painelPrincipal);

		panelCabecalho = new JPanel();
		panelCabecalho.setBackground(Color.LIGHT_GRAY);
		panelCabecalho.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		contentPane.add(panelCabecalho, BorderLayout.NORTH);

		tfCampoVisualizacao = new JTextField();
		tfCampoVisualizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCampoVisualizacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCampoVisualizacao.setBorder(new LineBorder(Color.BLACK, 2));
		tfCampoVisualizacao.setEditable(false);
		tfCampoVisualizacao.setColumns(10);
		gl_panelCabecalho = new GroupLayout(panelCabecalho);
		gl_panelCabecalho.setHorizontalGroup(gl_panelCabecalho.createParallelGroup(Alignment.LEADING)
				.addComponent(tfCampoVisualizacao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE));
		gl_panelCabecalho.setVerticalGroup(gl_panelCabecalho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCabecalho.createSequentialGroup()
						.addComponent(tfCampoVisualizacao, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addContainerGap()));
		panelCabecalho.setLayout(gl_panelCabecalho);

		panelBotoesCalculadora = new JPanel(new GridLayout(5, 4, 5, 5));
		contentPane.add(panelBotoesCalculadora, BorderLayout.CENTER);
		panelBotoesCalculadora.setBackground(Color.LIGHT_GRAY);

		btnNumero1 = new JButton("1");
		btnNumero1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero1.setForeground(Color.WHITE);
		btnNumero1.setBackground(Color.DARK_GRAY);
		btnNumero1.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero1.addActionListener(e -> {
			this.valorBotao = '1';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero2 = new JButton("2");
		btnNumero2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero2.setForeground(Color.WHITE);
		btnNumero2.setBackground(Color.DARK_GRAY);
		btnNumero2.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero2.addActionListener(e -> {
			this.valorBotao = '2';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero3 = new JButton("3");
		btnNumero3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero3.setForeground(Color.WHITE);
		btnNumero3.setBackground(Color.DARK_GRAY);
		btnNumero3.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero3.addActionListener(e -> {
			this.valorBotao = '3';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero4 = new JButton("4");
		btnNumero4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero4.setForeground(Color.WHITE);
		btnNumero4.setBackground(Color.DARK_GRAY);
		btnNumero4.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero4.addActionListener(e -> {
			this.valorBotao = '4';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero5 = new JButton("5");
		btnNumero5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero5.setForeground(Color.WHITE);
		btnNumero5.setBackground(Color.DARK_GRAY);
		btnNumero5.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero5.addActionListener(e -> {
			this.valorBotao = '5';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero6 = new JButton("6");
		btnNumero6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero6.setForeground(Color.WHITE);
		btnNumero6.setBackground(Color.DARK_GRAY);
		btnNumero6.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero6.addActionListener(e -> {
			this.valorBotao = '6';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero7 = new JButton("7");
		btnNumero7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero7.setForeground(Color.WHITE);
		btnNumero7.setBackground(Color.DARK_GRAY);
		btnNumero7.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero7.addActionListener(e -> {
			this.valorBotao = '7';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero8 = new JButton("8");
		btnNumero8.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero8.setForeground(Color.WHITE);
		btnNumero8.setBackground(Color.DARK_GRAY);
		btnNumero8.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero8.addActionListener(e -> {
			this.valorBotao = '8';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnNumero9 = new JButton("9");
		btnNumero9.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero9.setForeground(Color.WHITE);
		btnNumero9.setBackground(Color.DARK_GRAY);
		btnNumero9.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero9.addActionListener(e -> {
			this.valorBotao = '9';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnExpressaoNegativa = new JButton("+/-");
		btnExpressaoNegativa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExpressaoNegativa.setForeground(Color.WHITE);
		btnExpressaoNegativa.setBackground(Color.DARK_GRAY);
		btnExpressaoNegativa.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero0 = new JButton("0");
		btnNumero0.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNumero0.setForeground(Color.WHITE);
		btnNumero0.setBackground(Color.DARK_GRAY);
		btnNumero0.setBorder(new LineBorder(Color.BLACK, 2));

		btnNumero0.addActionListener(e -> {
			this.valorBotao = '0';
			this.expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(expressaoNumerica, valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();

		});

		btnSimboloVirgula = new JButton(",");
		btnSimboloVirgula.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSimboloVirgula.setForeground(Color.WHITE);
		btnSimboloVirgula.setBackground(Color.DARK_GRAY);
		btnSimboloVirgula.setBorder(new LineBorder(Color.BLACK, 2));

		btnSimboloVirgula.addActionListener(e -> {
			this.valorBotao = ',';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnLimpar = new JButton("C");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setForeground(new Color(153, 0, 0));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setBorder(new LineBorder(Color.BLACK, 2));

		btnLimpar.addActionListener(e -> {
			limparCampo();
			contentPane.requestFocusInWindow();
		});

		btnParenteses = new JButton("()");
		btnParenteses.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnParenteses.setForeground(new Color(0, 102, 0));
		btnParenteses.setBackground(Color.LIGHT_GRAY);
		btnParenteses.setBorder(new LineBorder(Color.BLACK, 2));

		btnParenteses.addActionListener(e -> {
			this.expressaoNumerica = calculadoraService.adicionarParentesesExpressaoNumerica(this.expressaoNumerica);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnPorcentagem = new JButton("%");
		btnPorcentagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPorcentagem.setForeground(new Color(0, 102, 0));
		btnPorcentagem.setBackground(Color.LIGHT_GRAY);
		btnPorcentagem.setBorder(new LineBorder(Color.BLACK, 2));

		btnPorcentagem.addActionListener(e -> {
			this.valorBotao = '%';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnDivisao = new JButton("÷");
		btnDivisao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDivisao.setForeground(new Color(0, 102, 0));
		btnDivisao.setBackground(Color.LIGHT_GRAY);
		btnDivisao.setBorder(new LineBorder(Color.BLACK, 2));

		btnDivisao.addActionListener(e -> {
			this.valorBotao = '/';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnMultiplicacao = new JButton("X");
		btnMultiplicacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMultiplicacao.setForeground(new Color(0, 102, 0));
		btnMultiplicacao.setBackground(Color.LIGHT_GRAY);
		btnMultiplicacao.setBorder(new LineBorder(Color.BLACK, 2));

		btnMultiplicacao.addActionListener(e -> {
			this.valorBotao = '*';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnSubtracao = new JButton("-");
		btnSubtracao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubtracao.setForeground(new Color(0, 102, 0));
		btnSubtracao.setBackground(Color.LIGHT_GRAY);
		btnSubtracao.setBorder(new LineBorder(Color.BLACK, 2));

		btnSubtracao.addActionListener(e -> {
			this.valorBotao = '-';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnSoma = new JButton("+");
		btnSoma.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSoma.setForeground(new Color(0, 102, 0));
		btnSoma.setBackground(Color.LIGHT_GRAY);
		btnSoma.setBorder(new LineBorder(Color.BLACK, 2));

		btnSoma.addActionListener(e -> {
			this.valorBotao = '+';
			this.expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(this.expressaoNumerica,
					valorBotao);
			tfCampoVisualizacao.setText(expressaoNumerica);
			contentPane.requestFocusInWindow();
		});

		btnRealizarCalculo = new JButton("=");
		btnRealizarCalculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRealizarCalculo.setForeground(Color.WHITE);
		btnRealizarCalculo.setBackground(new Color(0, 102, 0));
		btnRealizarCalculo.setBorder(new LineBorder(Color.BLACK, 2));

		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();

		btnRealizarCalculo.addActionListener(e -> {
			try {
				verificarSeCampoDeVisualizarEstaVazio(tfCampoVisualizacao.getText().trim());
				char ultimoDigito = expressaoNumerica.charAt(expressaoNumerica.length() - 1);

				if (calculadoraService.verificarUltimoDigito(ultimoDigito)) {
					// Gerenciador do motor de script
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("graal.js");

					// Verifique se o motor de script GraalVM foi carregado corretamente
					if (engine == null) {
						System.out.println("Motor de script GraalVM não encontrado.");
						return;
					}

					// Avalia a expressão e converte para int
					int resultadoInt = ((Number) engine.eval(expressaoNumerica)).intValue();
					System.out.println("Resultado (int): " + resultadoInt);

					// Avalia a expressão e converte para double
					double resultadoDouble = ((Number) engine.eval(expressaoNumerica)).doubleValue();
					System.out.println("Resultado (double): " + resultadoDouble);

					this.tfCampoVisualizacao.setText("" + resultadoDouble);
					this.expressaoNumerica = null;
				}

			} catch (IllegalArgumentException | ScriptException e1) {
				if (e1 instanceof IllegalArgumentException) {
					JOptionPane.showMessageDialog(FrameCalculadora.this, e1.getMessage(), "Mensagem do Sistema",
							JOptionPane.WARNING_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(FrameCalculadora.this, "Erro: " + e1.getMessage(),
							"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		});

		panelBotoesCalculadora.add(btnLimpar);
		panelBotoesCalculadora.add(btnParenteses);
		panelBotoesCalculadora.add(btnPorcentagem);
		panelBotoesCalculadora.add(btnDivisao);
		panelBotoesCalculadora.add(btnNumero1);
		panelBotoesCalculadora.add(btnNumero2);
		panelBotoesCalculadora.add(btnNumero3);
		panelBotoesCalculadora.add(btnMultiplicacao);
		panelBotoesCalculadora.add(btnNumero4);
		panelBotoesCalculadora.add(btnNumero5);
		panelBotoesCalculadora.add(btnNumero6);
		panelBotoesCalculadora.add(btnSubtracao);
		panelBotoesCalculadora.add(btnNumero7);
		panelBotoesCalculadora.add(btnNumero8);
		panelBotoesCalculadora.add(btnNumero9);
		panelBotoesCalculadora.add(btnSoma);
		panelBotoesCalculadora.add(btnExpressaoNegativa);
		panelBotoesCalculadora.add(btnNumero0);
		panelBotoesCalculadora.add(btnSimboloVirgula);
		panelBotoesCalculadora.add(btnRealizarCalculo);

		keyListener();
	}

	/**
	 * Método que limpa os dados da manipulação da calculadora;
	 */
	private void limparCampo() {
		tfCampoVisualizacao.setText("");
		this.expressaoNumerica = null;
	}

	/**
	 * Método que pega o clique do usuário e coloca o dígito ou o símbolo matemático
	 * na expressão e na tela da calculadora
	 */
	private void keyListener() {
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar())) {
					expressaoNumerica = calculadoraService.adicionarValorNumericoAoCampo(expressaoNumerica,
							e.getKeyChar());
					tfCampoVisualizacao.setText(expressaoNumerica);

				} else if (e.getKeyCode() == KeyEvent.VK_5 && e.isShiftDown()) {
					expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(expressaoNumerica, '%');
					tfCampoVisualizacao.setText(expressaoNumerica);

				} else {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_PLUS:
					case KeyEvent.VK_ADD: {
						expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(expressaoNumerica,
								'+');
						tfCampoVisualizacao.setText(expressaoNumerica);
						break;
					}
					case KeyEvent.VK_MINUS:
					case KeyEvent.VK_SUBTRACT: {
						expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(expressaoNumerica,
								'-');
						tfCampoVisualizacao.setText(expressaoNumerica);
						break;
					}
					case KeyEvent.VK_MULTIPLY: {
						expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(expressaoNumerica,
								'*');
						tfCampoVisualizacao.setText(expressaoNumerica);
						break;
					}
					case KeyEvent.VK_DIVIDE: {
						expressaoNumerica = calculadoraService.adicionarCaracteresEspeciaisAoCampo(expressaoNumerica,
								'/');
						tfCampoVisualizacao.setText(expressaoNumerica);
						break;
					}
					case KeyEvent.VK_C: {
						limparCampo();
						break;
					}
					case KeyEvent.VK_ENTER:
					case KeyEvent.VK_ACCEPT: {
						break;
					}
					}
				}
			}
		});
	}

	/**
	 * Método que verifica se o campo da expressão numérica está vazio
	 * 
	 * @param campo - Recebe o campo da expressão numérica
	 * @throws IllegalArgumentException Caso a campo esteja vazio
	 */
	private void verificarSeCampoDeVisualizarEstaVazio(String campo) throws IllegalArgumentException {
		if (campo == null || campo.isEmpty()) {
			throw new IllegalArgumentException(
					"O campo não pode ficar vazio, por favor digite uma expressão matemática que deseja calcular");
		}
	}
}
