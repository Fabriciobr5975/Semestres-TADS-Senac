package atividades.imc;

import javax.swing.JOptionPane;

/**
 * Fabrício de Araújo Santana
 */
public class TestaImc {
	public static void main(String[] args) {
		// Variável de referência ao objeto Pessoa;
		Usuario usuario = null;
		// Variável para a manipulação do sistema;
		int opcao = 0;

		while (true) {
			try {
				if (opcao == 0) {
					usuario = cadastrarUsuario();
				}
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, formatarMenuOpcoes(), "Menu de Opções",
						JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				// Verificar o IMC;
				case 1 -> {
					JOptionPane.showMessageDialog(null,
							String.format("O seu IMC é: %3.1f kg/m2%n", Imc.calcularImcUsuario(usuario)),
							"Calculo do IMC", JOptionPane.INFORMATION_MESSAGE);
				}
				// Verificar o Peso Ideal;
				case 2 -> {
					JOptionPane.showMessageDialog(null,
							String.format("O seu Peso Ideal seria: %3.1f Kg%n", Imc.calcularPesoIdeal(usuario)),
							"Peso Ideal", JOptionPane.INFORMATION_MESSAGE);
				}
				/*
				 * Imprimir as informações do usuário, do IMC, do peso ideal e da avaliação do
				 * IMC
				 */
				case 3 -> {
					JOptionPane.showMessageDialog(null, Imc.imprimirInformacoesImc(usuario), "Dados",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// Criar outro usuário;
				case 4 -> {
					usuario = cadastrarUsuario();
				}
				// Sair do sistema;
				case 5 -> {
					int sairSistema = JOptionPane.showConfirmDialog(null,
							"Deseja sair do sistema? Aperte sim para sair | Aperte Não ou Cancelar para continuar no sistema",
							"Mensagem", JOptionPane.INFORMATION_MESSAGE);

					if (sairSistema == 0) {
						JOptionPane.showMessageDialog(null, "Fechando o sistema, aguarde um pouco",
								"Fechando o Sistema", JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					} else {
						continue;
					}

				}
				/*
				 * Opção default caso a opção que o usuário digite seja diferente das opções do
				 * sistema
				 */
				default -> {
					JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente", "Mensagem",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				}
			} catch (Exception ex) {
				String erro = ex.getMessage();

				if (erro.contains("Não é possível calcular o seu IMC sem um sexo definido")) {
					JOptionPane.showMessageDialog(null, "Para continuar cadastre um sexo", "Erro",
							JOptionPane.ERROR_MESSAGE);
					cadastrarSexo(usuario);
					continue;

				} else if (erro.contains("Cannot parse null string")) {
					JOptionPane.showMessageDialog(null, "Saindo do sistema, aguarde", "Sistema",
							JOptionPane.WARNING_MESSAGE);
					break;

				} else if (erro.contains("For input string:")) {
					JOptionPane.showMessageDialog(null, "Inserção inválida de dados", "Erro",
							JOptionPane.ERROR_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Método para formatar de uma forma simples o menu de opções
	 * 
	 * @return Retorna uma String contendo as opções do menu formatadas
	 */
	public static String formatarMenuOpcoes() {
		return "1 - Calcular o seu IMC\n2- Verificar qual seria o seu Peso Ideal\n3 - Imprimir informações"
				+ "\n4 - Testar outro Usuário\n5 - Sair";
	}

	/**
	 * Método para cadastrar um usuário
	 * 
	 * @return - Retorna um novo usuário (objeto)
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static Usuario cadastrarUsuario() throws Exception {
		// Variáveis para a criação de um usuário;
		String nome, sexo;
		int idade;
		double altura, peso;

		// Verificação para os dados do tipo String;
		do {
			nome = JOptionPane.showInputDialog(null, "Digite o seu nome", "Nome", JOptionPane.QUESTION_MESSAGE);

			// Se nome for igual a null significa que o usuário clicou em sair ou cancelar;
			if (nome == null) {
				throw new Exception("Cannot parse null string");
			}

			sexo = JOptionPane.showInputDialog(null, "Você é Homem ou Mulher?", "Sexo", JOptionPane.QUESTION_MESSAGE);

			// Se nome for igual a null significa que o usuário clicou em sair ou cancelar;
			if (sexo == null) {
				throw new Exception("Cannot parse null string");
			}

		} while (nome.isEmpty() || sexo.isEmpty());

		// Verificação para os dados do tipo int e double;
		do {
			idade = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Digite sua idade", "Idade", JOptionPane.QUESTION_MESSAGE));
			altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite sua altura em centrímetros. Ex: 172",
					"Altura", JOptionPane.QUESTION_MESSAGE));
			peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite seu peso: Ex: 62.5", "Peso",
					JOptionPane.QUESTION_MESSAGE));
		} while ((idade < 0 || idade > 130) || (altura < 0 || altura > 300) || (peso < 0 || peso >= 600));

		return new Usuario(nome, idade, altura, peso, sexo);
	}

	/**
	 * Método para pegar o sexo do usuário caso ele não tenha colocado um sexo
	 * válido. Esse método só é chamado caso o usuário queira calcular o IMC,
	 * verificar o peso ideal ou na hora de imprimir suas informações
	 * 
	 * @param usuario - Recebe o usuário (objeto) que está sendo manipulado
	 */
	public static void cadastrarSexo(Usuario usuario) {
		// Variável local para pegar o sexo;
		String sexo;

		// Verificando se o valor digitado pelo usuário é válido;
		do {
			sexo = JOptionPane.showInputDialog(null, "Você é Homem ou Mulher?", "Sexo", JOptionPane.QUESTION_MESSAGE);

			if (sexo.equalsIgnoreCase("Homem")) { // Válido, muda o sexo para Masculino e acaba o Loop;
				usuario.setSexo("Masculino");
				break;

			} else if (sexo.equalsIgnoreCase("Mulher")) { // Válido, muda o sexo para Feminino e acaba o Loop;
				usuario.setSexo("Feminino");
				break;

			} else { // Não é válido, continua o Loop
				JOptionPane.showMessageDialog(null, "Essa opção não é válida, digite novamente", "Sexo Inválido",
						JOptionPane.WARNING_MESSAGE);
				sexo = "";
				continue;
			}
		} while (true);
	}
}