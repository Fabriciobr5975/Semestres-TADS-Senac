import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Media {

	// Declarando os objetos da classe Scanner e Random de forma global;
	public static Scanner leitor = new Scanner(System.in);
	public static Random rand = new Random();

	public static void main(String[] args) {
		// Variáveis;
		int quantAlunos;

		// Loop para receber a quantidade de alunos para criar os arrays;
		while (true) {
			try {
				System.out.println("Digite a quantidade de alunos:");
				quantAlunos = leitor.nextInt();

				if (quantAlunos <= 0) {
					System.out.println("Quantidade inválida, digite novamente:");
					quantAlunos = leitor.nextInt();
				} else {
					break;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Você digitou um valor inválido, digite um valor inteiro maior ou igual a 1:");
				/*
				 * Limpa os dados do buffer do scanner
				 * 
				 * Obs: O buffer armazena temporariamente os dados de entrada que o programa
				 * recebe via console, para o código não entrar em um loop eterno, limpo ele
				 * para receber os próximos dados no bloco try
				 */
				leitor.nextLine();
			}
		}
		// Declarando os arrays para armazenar os alunos e suas respectivas notas;
		String[] alunos = new String[quantAlunos];
		double[][] notas = new double[quantAlunos][5];

		// Chamando o método que obtem a notas dos alunos;
		notasDosAlunos(alunos, notas);

		// Cabeçalho de uma tabelinha com os alunos, notas e a média final deles;
		System.out.printf("%-10s|%6s|%6s|%6s|%6s|%6s%n", "Nome", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Média");

		// Imprindo os dados dos arrays;
		for (int i = 0; i < alunos.length; i++) {
			System.out.printf("%-10s", alunos[i]);

			for (int j = 0; j < 5; j++) {
				System.out.printf("|%6.2f", notas[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Método para adicionar aluno/s com suas respectivas notas
	 * 
	 * @param nomes - Recebe um array que ira guardar os nomes dos alunos.
	 * @param notas - Recebe um array que ira guardar o array com os nomes dos
	 *              alunos e as suas respectivas notas e no último espaço guarda a
	 *              média dos alunos.
	 */

	public static void notasDosAlunos(String[] nomes, double[][] notas) {
		// Variáveis;
		double media = 0;
		double soma = 0;

		// Loop para pegar o nome do Aluno;
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Digite o nome do aluno " + (i + 1));
			nomes[i] = leitor.next();

			// Loop para pegar as notas referente a cada aluno;
			for (int j = 0; j < 5; j++) {
				notas[i][j] = rand.nextDouble(0, 11);

				while (notas[i][j] > 10) {
					notas[i][j] = rand.nextDouble(0, 11);
					continue;
				}
				soma += notas[i][j];
			}
			// Pegando a média dos alunos;
			media = soma / 4;

			/*
			 * Colocando as notas dos alunos;
			 * 
			 * Obs: Como o vetor tem 5 posições, deixei entre os valores os valores das
			 * notas deste aluno. Enquanto isso, a última posição deixa armazenado a média
			 * deste aluno
			 */
			notas[i][4] = media;

			// Para resetar os valores das variáveis;
			media = 0;
			soma = 4;
		}
	}
}