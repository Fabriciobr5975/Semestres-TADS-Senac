package atividades;

import javax.swing.JOptionPane;
import java.util.InputMismatchException;

/**
 * Programa feito para a primeira ADO da matéria Projeto Integrador:
 * Desenvolvimento de Sistemas Orientado a Objetos com os seguintes objetivos:
 * 
 * <p>
 * ➢ Permitir que o usuário crie um matriz quadrada para cadastrar valores, no
 * caso deste programa números inteiros
 * </p>
 * <p>
 * ➢ Imprimir informações sobre: Soma de todos os elementos dentro da matriz, o
 * maior e o menor número presente na matriz e a soma da diagonal principal e a
 * diagonal secundária
 * </p>
 * <p>
 * ➢ Deixar o usuário escolher se deseja cadastrar uma nova matriz ou parar o
 * programa
 * </p>
 * 
 * @author Fabrício de Araújo Santana 
 */
public class Ado1ProjetoIntegrador {
	/**
	 * Função para receber via JOptionPane uma tamanho para criar a matriz quadrada
	 * 
	 * @return Retorna um número inteiro maior que 1
	 * @throws Exception              Para lidar com exceções que podem ocorrer
	 * @throws InputMismatchException Para lidar com inserções de tipos errados
	 */
	public static int solicitarTamanhoMatriz() throws Exception, InputMismatchException {
		// Variável para pegar o tamanho da matriz;
		int tamanho;

		// Entrada dos dados;
		tamanho = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Digite o um valor maior que 1 para criar o vetor quadrado:",
						"Entrada de dados", JOptionPane.INFORMATION_MESSAGE));

		// Verificando se o valor é valido para criar o matriz;
		while (tamanho <= 1) {
			tamanho = Integer
					.parseInt(JOptionPane.showInputDialog(null, "O tamanho informado não é válido! Digite novamente:",
							"Entrada de dados", JOptionPane.WARNING_MESSAGE));
		}
		return tamanho;
	}

	/**
	 * Procedimento para preencher a matriz com valores recebidos via JOptionPane
	 * 
	 * @param matriz - Recebe uma matriz que será preenchida
	 * @throws Exception              Para lidar com exceções que podem ocorrer
	 * @throws InputMismatchException Para lidar com inserções de tipos errados
	 */
	public static void preencherMatriz(int[][] matriz) throws Exception, InputMismatchException {
		// Iterações alinhadas para preencher a matriz com os valores;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,
						String.format("Digite os elementos da linha [%d] coluna [%d]:%n", (i + 1), (j + 1)),
						"Entrada de Dados", JOptionPane.INFORMATION_MESSAGE));
			}
		}
	}

	/**
	 * Função para imprimir a matriz formatada
	 * 
	 * @param matriz - Recebe uma matriz preenchida;
	 * @return Retorna um elemento do tipo String contendo a matriz formatada
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static String imprimirMatriz(int[][] matriz) throws Exception {
		// Declarando uma variável para armazenar os elementos da matriz;
		String resultado = "";

		// Imprimindo os valores armazenados na matriz
		for (int[] i : matriz) {
			resultado += "[  ";
			for (int j : i) {
				resultado += j;
				resultado += "  ";
			}
			resultado += "]\n";
		}
		return resultado;
	}

	/**
	 * Função para somar todos os elementos presentes na matriz;
	 * 
	 * @param matriz - Recebe uma matriz com elementos
	 * @return Retorna a soma de todos os elementos na matriz;
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static int somarElementosMatriz(int[][] matriz) throws Exception {
		int soma = 0;

		for (int[] i : matriz) {
			for (int j : i) {
				soma += j;
			}
		}
		return soma;
	}

	/**
	 * Função para encontrar o maior elemento dentro da matriz
	 * 
	 * @param matriz - Recebe uma matriz com elementos
	 * @return Retorna o maior valor encontrado dentro da matriz
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static int encontrarMaiorElemento(int[][] matriz) throws Exception {
		int maior = Integer.MIN_VALUE;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (maior < matriz[i][j]) {
					maior = matriz[i][j];
				}
			}
		}
		return maior;
	}

	/**
	 * Função para encontrar o menor elemento dentro da matriz
	 * 
	 * @param matriz - Recebe uma matriz com elementos
	 * @return Retorna o menor valor encotrado detrod da matriz
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static int encontrarMenorElemento(int[][] matriz) throws Exception {
		int menor = Integer.MAX_VALUE;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (menor > matriz[i][j]) {
					menor = matriz[i][j];
				}
			}
		}
		return menor;
	}

	/**
	 * Função para calcular a diagonal principal da matriz
	 * 
	 * @param matriz - Recebe uma matriz com elemetos
	 * @return Retorna a soma da diagonal principal desta matriz
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static int calcularDiagonalPrincipal(int[][] matriz) throws Exception {
		int diagonalPrincipal = 0;
		// Iteração para passar pelo vetor e realizar a soma das diagonais;
		for (int i = 0; i < matriz.length; i++) {
			diagonalPrincipal += matriz[i][i];
		}
		return diagonalPrincipal;
	}

	/**
	 * Função para calcular a diagonal secundária da matriz
	 * 
	 * @param matriz  - Recebe uma matriz com elementos
	 * @param tamanho - Retorna a soma da diagonal secundária desta matriz
	 * @return Retorna a soma da diagonal principal desta matriz
	 * @throws Exception Para lidar com exceções que podem ocorrer
	 */
	public static int calcularDiagonalSecundaria(int[][] matriz, int tamanho) throws Exception {
		int diagonalSecundaria = 0;
		// Iteração para passar pelo vetor e realizar a soma das diagonais;
		for (int i = 0; i < matriz.length; i++) {
			diagonalSecundaria += matriz[i][--tamanho];
		}
		return diagonalSecundaria;
	}

	public static void main(String[] args) {
		// Variáveis;
		int diagonalPrincipal = 0, diagonalSecundaria = 0;
		int tamanho = 0, opcao = 0;
		int[][] matriz;

		do {
			try {
				// Pegando o tamanho para criar a matriz quadrada;
				tamanho = solicitarTamanhoMatriz();

				// Criando a matriz quadrada;
				matriz = new int[tamanho][tamanho];

				// Preencher a matriz com os valores;
				preencherMatriz(matriz);

				// Imprimindo os elementos do vetor;
				JOptionPane.showMessageDialog(null, imprimirMatriz(matriz), "Matriz", JOptionPane.INFORMATION_MESSAGE);

				// Chamando as funções que calculam as diagonais;
				diagonalPrincipal = calcularDiagonalPrincipal(matriz);
				diagonalSecundaria = calcularDiagonalSecundaria(matriz, tamanho);

				// Resultado da soma das diagonais;
				JOptionPane.showMessageDialog(null, String.format(
						"A soma dos elementos da diagonal principal é: %d.%nA soma dos elementos da diagonal secundária é: %d.%n",
						diagonalPrincipal, diagonalSecundaria), "Resultado das Diagonais",
						JOptionPane.INFORMATION_MESSAGE);

				/*
				 * Resultado da soma dos elementos da matriz, junto com o maior e o menor valor
				 * encontrado na matriz;
				 */
				JOptionPane.showMessageDialog(null, String.format(
						"A soma dos elementos da matriz: %d%nO maior elemento da matriz é: %d%nO menor elemento da matriz é: %d%n",
						somarElementosMatriz(matriz), encontrarMaiorElemento(matriz), encontrarMenorElemento(matriz)),
						"Resultado adicionais", JOptionPane.INFORMATION_MESSAGE);

				// Verifica se a pessoa deseja continuar ou parar o programa;
				opcao = JOptionPane.showConfirmDialog(null,
						"Deseja cadastrar outra matriz? Clique no botão \"Sim\" para continuar ou \"Não | Cancelar \" para finalizar o programa",
						"Continuar", JOptionPane.INFORMATION_MESSAGE);

			} catch (InputMismatchException ex) { // Caso a execeção seja pela inserção de tipos diferentes
				JOptionPane.showConfirmDialog(null, "Você não pode colocar esse tipo de dado!", "Mensagem",
						JOptionPane.WARNING_MESSAGE);

			} catch (Exception ex) {
				String erro = ex.getMessage();

				// Caso a pessoa clique no botão cancelar do JOptionPane
				if (erro.contains("Cannot parse null string")) {
					JOptionPane.showMessageDialog(null, "Ação cancelada", "Mensagem", JOptionPane.WARNING_MESSAGE);
					break;

				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Mensagem",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (opcao < 1);
	}
}