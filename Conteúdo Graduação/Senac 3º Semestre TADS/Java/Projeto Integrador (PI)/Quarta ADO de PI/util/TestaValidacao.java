package atividades.util;

import javax.swing.JOptionPane;

/**
 * Classe de teste para as validações de alguns documentos como o CNPJ, o CPF, a
 * Inscrição Estadual (IE) e o RG de São Paulo
 * 
 * @author Fabrício de Araújo Santana
 */
public class TestaValidacao {
	// Método main;
	public static void main(String[] args) {
		// Variável para a manipulação do programa;
		int opcao = 0;

		while (true) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, formatarMenuDeOpcoes(),
						"Validador de Documentos", JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				// Validar o CNPJ;
				case 1 -> {
					String cnpj = receberCnpj();

					if (ValidacaoDocumento.validarCnpj(cnpj)) {
						JOptionPane.showMessageDialog(null, String.format("O CPNJ: %s passou na validação", cnpj),
								"Validação do CNPJ", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, String.format("O CPNJ: %s não passou na validação", cnpj),
								"Validação do CNPJ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Validar o CPF;
				case 2 -> {
					String cpf = receberCpf();

					if (ValidacaoDocumento.validarCpf(cpf)) {
						JOptionPane.showMessageDialog(null, String.format("O CPF: %s passou na validação", cpf),
								"Validação do CPF", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, String.format("O CPF: %s não passou na validação", cpf),
								"Validação do CPF", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Validar a Inscrição Estadual (IE);
				case 3 -> {
					String ie = receberInscricaoEstadual();

					if (ValidacaoDocumento.validarInscricaoEstadual(ie)) {
						JOptionPane.showMessageDialog(null, String.format("A IE : %s passou na validação", ie),
								"Validação da Inscrição Estadual", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, String.format("O IE: %s não passou na validação", ie),
								"Validação da Inscrição Estadual", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Validar o RG de São Paulo;
				case 4 -> {
					String rg = receberRgSaoPaulo();

					if (ValidacaoDocumento.validarRgSaoPaulo(rg)) {
						JOptionPane.showMessageDialog(null, String.format("O RG : %s passou na validação", rg),
								"Validação do RG de São Paulo", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, String.format("O RG : %s não passou na validação", rg),
								"Validação do RG de São Paulo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Caso a opção informada seja diferente das opções acima;
				default -> {
					JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente", "Opção Inválida",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				}
			} catch (Exception ex) {
				String erro = ex.getMessage();

				if (erro.contains("Cannot parse null string")) {
					int opcaoSair = 0;

					opcaoSair = JOptionPane.showConfirmDialog(null,
							"Deseja sair do sistema? Aperte Sim para sair | Aperte Cancelar para continuar no sistema",
							"Sair do Sistema", JOptionPane.WARNING_MESSAGE);

					if (opcaoSair != 0) {
						continue;
					}
					System.exit(0);

				} else if (erro.contains("For input string")) {
					JOptionPane.showMessageDialog(null, "Inserção inválida de dados", "Erro",
							JOptionPane.ERROR_MESSAGE);
					continue;

				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Método para formatar as opções do menu
	 * 
	 * @return Retorna uma String contendo as opções válidas do menu
	 */
	public static String formatarMenuDeOpcoes() {
		return "1 - Validar CNPJ\n2 - Validar CPF\n3 - Validar Inscrição Estadual"
				+ "\n4 - Validar RG de São Paulo";
	}

	/**
	 * Método para receber um CNPJ do usuário
	 * 
	 * @return Retorna o CPNJ do usuário para o método que faz a validação do CNPJ
	 * @throws Exception Caso o usuário aperte em cancelar ou no botão de fechar do
	 *                   JOptionPane
	 */
	public static String receberCnpj() throws Exception {
		String cnpj = "";

		do {
			cnpj = JOptionPane.showInputDialog(null,
					"Digite o CNPJ seguindo os exemplos: 11.222.333/0001-81 ou 11222333000181", "Entrada do CNPJ",
					JOptionPane.INFORMATION_MESSAGE);

			// Se o usuário clicar em cancelar ou em fechar no JOptionPane;
			if (cnpj == null) {
				throw new Exception("Cannot parse null string");
			}

			// Caso o CNPJ não esteja com todos os digitos necessários;
			if (cnpj.length() < 14 || cnpj.length() > 18) {
				JOptionPane.showMessageDialog(null, "Digite um CNPJ válido", "Erro na Entrada do CNPJ",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			break;

		} while (true);

		return cnpj;
	}

	/**
	 * Método para receber um CPF do usuário
	 * 
	 * @return Retorna o CPF do usuário para o método que faz a validação do CPF
	 * @throws Exception Caso o usuário aperte em cancelar ou no botão de fechar do
	 *                   JOptionPane
	 */
	public static String receberCpf() throws Exception {
		String cpf = "";

		do {
			cpf = JOptionPane.showInputDialog(null, "Digite o CPF seguindo os exemplos: 111.444.777-35 ou 11144477735",
					"Entrada do CPF", JOptionPane.INFORMATION_MESSAGE);

			// Se o usuário clicar em cancelar ou em fechar no JOptionPane;
			if (cpf == null) {
				throw new Exception("Cannot parse null string");
			}
			// Caso o CPF não esteja com todos os digitos necessários;
			if (cpf.length() < 11 || cpf.length() > 14) {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido", "Erro na Entrada do CPF",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			break;

		} while (true);

		return cpf;
	}

	/**
	 * Método para receber uma Inscrição Estadual (IE) do usuário. Porém não é
	 * garantido que a IE passe na validação, mesmo ela sendo válida, pois cada
	 * estado tem sua IE e pode fazer a validação de um jeito diferente. Então não
	 * se assuste, caso a IE que você passe retorne false mesmo ela sendo verdadeira
	 * 
	 * @return Retorna a IE do usuário para o método que faz a validação do IE
	 * @throws Exception Caso o usuário aperte em cancelar ou no botão de fechar do
	 *                   JOptionPane
	 */
	public static String receberInscricaoEstadual() throws Exception {
		String ie = "";

		do {
			ie = JOptionPane.showInputDialog(null,
					"Digite a IE seguindo os exemplos: [955.608.221.878 ou 955608221878] ou [120.000.385 ou 120000385]",
					"Entrada da Inscrição Estadual", JOptionPane.INFORMATION_MESSAGE);

			// Se o usuário clicar em cancelar ou em fechar no JOptionPane;
			if (ie == null) {
				throw new Exception("Cannot parse null string");
			}
			// Caso o IE não esteja com todos os digitos necessários;
			if (ie.length() < 9 || ie.length() > 15) {
				JOptionPane.showMessageDialog(null, "Digite um IE válido", "Erro na Entrada do Inscrição Estadual",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			break;

		} while (true);

		return ie;
	}

	/**
	 * Método para receber um RG do estado de São Paulo do usuário
	 * 
	 * @return Retorna o RG do usuário para o método que faz a validação do RG de
	 *         São Paulo
	 * @throws Exception Caso o usuário aperte em cancelar ou no botão de fechar do
	 *                   JOptionPane
	 */
	public static String receberRgSaoPaulo() throws Exception {
		String rg = "";

		do {
			rg = JOptionPane.showInputDialog(null, "Digite o RG seguindo os exemplos: 25.684.449-5 ou 256844495",
					"Entrada do RG de São Paulo", JOptionPane.INFORMATION_MESSAGE);

			// Se o usuário clicar em cancelar ou em fechar no JOptionPane;
			if (rg == null) {
				throw new Exception("Cannot parse null string");
			}
			// Caso o RG não esteja com todos os digitos necessários;
			if (rg.length() < 9 || rg.length() > 12) {
				JOptionPane.showMessageDialog(null, "Digite um RG válido", "Erro na Entrada do RG de São Paulo",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			break;

		} while (true);

		return rg;
	}
}
