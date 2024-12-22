package atividades.veiculo;

import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 * @author Fabrício de Araújo Santana
 */
public class TesteVeiculo {
	public static void main(String[] args) {
		// Criando a varíavel de referência aos objetos da classe Veículo
		Veiculo veiculo = null;
		// Criando um ArraysList para armazenar os veículos salvos
		ArrayList<Veiculo> veiculosSalvos = new ArrayList<>();

		while (true) {
			try {
				// Pegando a opção do menu;
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, imprimirMenuOpcao(), "Menu de Opções",
						JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				// Criar um objeto do tipo Veículo;
				case 1 -> {
					veiculo = cadastrarVeiculos();
					veiculosSalvos.add(veiculo);
				}
				// Ligar o veículo;
				case 2 -> {
					JOptionPane.showMessageDialog(null, veiculo.ligarVeiculo(), "Ligar Veículo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// Desligar o veículo;
				case 3 -> {
					JOptionPane.showMessageDialog(null, veiculo.desligarVeiculo(), "Desligar Veículo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// Imprimir informações do painel do veículo;
				case 4 -> {
					JOptionPane.showMessageDialog(null, veiculo.informacaoPainel(), "Dados do Painel",
							JOptionPane.INFORMATION_MESSAGE);

				}
				// Imprimir informações do veículo;
				case 5 -> {
					JOptionPane.showMessageDialog(null, veiculo.informacaoVeiculo(), "Dados do Veículo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// Acelerar o veículo;
				case 6 -> {
					if (veiculo.isLigado()) {
						veiculo.acelerar(receberValorParaAcelerar());
						JOptionPane
								.showMessageDialog(null,
										String.format("Acelerando o veículo. Nova velocidade: %d Km/h%n",
												veiculo.getVelocidade()),
										"Informação", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Ligue o veículo para continuar", "Informação",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Frear o veículo;
				case 7 -> {
					if (veiculo.isLigado()) {
						veiculo.frear(receberValorParaFrear());
						JOptionPane.showMessageDialog(null,
								String.format("Freando o veículo. Velocidade: %d Km/h%n", veiculo.getVelocidade()),
								"Informação", JOptionPane.INFORMATION_MESSAGE);

					} else if (veiculo.isLigado() && veiculo.getVelocidade() == 0) {
						JOptionPane.showMessageDialog(null, "Para freiar o carro precisa estar em movimento",
								"Informação", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Ligue o veículo para continuar", "Informação",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
				// Abastecer o veículo;
				case 8 -> {
					if (!veiculo.isLigado() && veiculo.getVelocidade() == 0) {
						veiculo.abastecerVeiculo();
						JOptionPane.showMessageDialog(null,
								String.format("Veículo abastecido: %2.0f Litros", veiculo.getCombustivel()),
								"Abastecimento", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Pare e desligue o veículo para abastecer", "Abastecimento",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Imprimir todos os veículos salvos;
				case 9 -> {
					if (veiculosSalvos.size() == 0) {
						JOptionPane.showMessageDialog(null, "Não há veículos para imprimir", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					} else {
						for (Veiculo i : veiculosSalvos) {
							JOptionPane.showMessageDialog(null, i, "Todos os veículos Salvos",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				/*
				 * Caso o valor da opção que o usuário tenha digitado não esteja presente nos
				 * casos do Switch
				 */
				default -> {
					JOptionPane.showMessageDialog(null, "Opção inválida", "Mensagem", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				}
				// Tratamento das Exceções;
			} catch (InputMismatchException ex) {
				JOptionPane.showMessageDialog(null, "Inserção de dados inválido", "Mensagem",
						JOptionPane.ERROR_MESSAGE);

			} catch (Exception ex) {
				String erro = ex.getMessage();

				if (erro.contains("For input string")) {
					JOptionPane.showMessageDialog(null, "Não é possivel continuar sem digitar um valor válido",
							"Mensagem", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				if (erro.contains("Cannot parse null string")) {
					JOptionPane.showMessageDialog(null, "Fechando o programa, aguarde", "Mensagem",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (veiculo == null) {
					JOptionPane.showMessageDialog(null, "Crie um objeto para continuar", "Mensagem",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				JOptionPane.showMessageDialog(null, String.format("Erro: %s%n", ex.getMessage()), "Mensagem",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método para cadastrar novos Objetos do tipo Veículos
	 * 
	 * @return Retorna um novo objeto com as características determindas no
	 *         construtor
	 * 
	 * @throws Exception              Para lidar com exceções que podem ocorrer
	 * @throws InputMismatchException Para lidar com inserções de tipos errados
	 */
	public static Veiculo cadastrarVeiculos() throws Exception, InputMismatchException {
		// Array para armazenar as caracteristicas do carro que sejam do tipo String
		String[] elementos = { "Marca", "Modelo", "Versão", "Cor", "Motor" };
		// Variáveis;
		int anoFabricacao = 0;
		double combustivel = 0;

		// Entrada dos dados;
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = JOptionPane.showInputDialog(null, String.format("Digite o %s do veículo", elementos[i]),
					"Cadastro de Veículos", JOptionPane.INFORMATION_MESSAGE);

			if (i == (elementos.length - 1)) {
				anoFabricacao = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de fabricação deste veículo",
								"Cadastro de Veículos", JOptionPane.INFORMATION_MESSAGE));
				combustivel = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Insira uma quantidade de combustivel para o veículo",
								"Cadastro de Veículos", JOptionPane.INFORMATION_MESSAGE));
			}
		}
		/*
		 * Retornando o objeto, neste caso um objeto anônimo que será ligado
		 * posteriormente;
		 */
		return new Veiculo(elementos[0], elementos[1], elementos[2], elementos[3], anoFabricacao, elementos[4],
				combustivel);
	}

	/**
	 * Método para formatar a impressão de um menu para as opções do veículo
	 * 
	 * @return Retorna um String com formatada coma s opções desse menu
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static String imprimirMenuOpcao() throws Exception {
		String formulario = "1 - Criar um novo veículo\n2 - Ligar Veículo\n3 - Desligar Veículo\n4 - Imprimir dados do painel do veículo"
				+ "\n5 - Imprimir dados do veículo\n6 - Acelerar\n7 - Freiar\n8 - Abastecer\n9 - Imprimir todos os veículos salvos";

		return formulario;
	}

	/**
	 * Método para receber um valor inteiro que represente os segundos para simular
	 * a aceleração de um veículo
	 * 
	 * @return Retorna um valor inteiro que será usado em um método da classe
	 *         Veículo para simular a aceleração de um veículo
	 * @throws Exception              Para lidar com exceções que podem ocorrer
	 * @throws InputMismatchException Para lidar com inserções de tipos errados
	 */
	public static int receberValorParaAcelerar() throws Exception, InputMismatchException {
		int segundos = 0;

		do {
			segundos = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Digite por quantos segundos deseja acelerar o veículo",
							"Formulário", JOptionPane.INFORMATION_MESSAGE));
		} while (segundos < 1 || segundos > 60);

		return segundos;
	}

	/**
	 * Método para receber um valor inteiro que represente os segundos para simular
	 * a freanagem de um veículo
	 * 
	 * @return Retorna um valor inteiro que será usado em um método da classe
	 *         Veículo para simular a frenagem de um veículo
	 * @throws Exception              Para lidar com exceções que podem ocorrer
	 * @throws InputMismatchException Para lidar com inserções de tipos errados
	 */
	public static int receberValorParaFrear() throws Exception, InputMismatchException {
		int segundos = 0;

		do {
			segundos = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Digite por quantos segundos deseja Freiar o veículo",
							"Formulário", JOptionPane.INFORMATION_MESSAGE));
		} while (segundos < 1 || segundos > 60);

		return segundos;
	}
}