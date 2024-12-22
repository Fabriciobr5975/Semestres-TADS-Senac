
import java.util.Random;
import java.util.Scanner;

/**
 * ATENÇÃO: ESTE CÓDIGO É UM DOS PRIMEIROS QUE EU FIZ QUANDO COMEÇEI A MANIPULAR
 * ARRAYS, ENTÃO ELE TERÁ MUITAS COISAS ESTRANHAS, PORÉM, NÃO QUERO FICAR
 * MEXENDO MUITO NELE, PRINCIPALMENTE POR SER UM DOS PRIMEIROS E PELA NOSTALGIA.
 * APENAS IREI FAZER COMENTÁRIOS E CORRIGIR PEQUENOS ERROS QUE NÁ EPOCA EU NÃO
 * SABIA ARRUMAR
 */
public class Formas {

	// Variáveis globais;
	static Scanner leitor = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String[] args) {
		// Método para imprimir a forma que o usuário escolher usando arrays
		// bi-dimensionais;
		desenho();
	}

	/**
	 * Método para imprimir a forma;
	 */
	public static void desenho() {
		// Variáveis;
		int linha, coluna, opcao, novaPosLin = 0, novaPosCol = 0, lc = 0;
		String caractere, novoCaractere = null;

		do {

			// Pegando a quantidade de linas
			System.out.println("Digite a linha e a coluna:");
			linha = leitor.nextInt();
			coluna = leitor.nextInt();

		} while (linha <= 0 || coluna <= 0);

		// Pegando o caractere;
		System.out.println("Digite o caractere:");
		caractere = leitor.next();

		// Perguntando se o usuário deseja mudar alguma forma;
		System.out.println("Deseja mudar alguma forma, se sim digite 1, se não digite 2:");
		opcao = leitor.nextInt();

		// Verificando se a opção do usuário é valida;
		while (opcao < 1 || opcao > 2) {
			System.out.println("Opção inválida, digite outra:");
			opcao = leitor.nextInt();
		}

		// Opção 1: Digita uma nova forma;
		if (opcao == 1) {
			System.out.println("Digite uma nova forma:");
			novoCaractere = leitor.next();

			// Perguntando como que o usuário quer a nova forma dentro da forma;
			do {
				System.out.println(
						"Digite 1 para mudar a linha e a coluna, ou Digite 2 para mudar apenas a intersecção da linha e da coluna:");
				lc = leitor.nextInt();
			} while (lc != 1 && lc != 2);

			// Escolhendo as linhas e colunas;
			System.out.println("Digite a linha e a coluna que deseja mudar. (OBS: PARA NÃO MUDAR AS DUAS POSIÇÕES,"
					+ " DIGITE 0 ONDE NÃO QUISER MUDAR. DESCONSIDERE ISSO SE FOR MUDAR A LINHA E A COLUNA");
			novaPosLin = leitor.nextInt();
			novaPosCol = leitor.nextInt();

			// Verificando as posições informadas pelo usuário;
			while (novaPosLin > linha || novaPosCol > coluna) {
				System.out.println("Novas posições erradas, digite novamente:");
				novaPosLin = leitor.nextInt();
				novaPosCol = leitor.nextInt();
			}
		} 
		
		// Imprimindo a forma;
		for (int i = 1; i <= linha; i++) {
			System.out.print("[");
			for (int j = 1; j <= coluna; j++) {

				switch (lc) {
				case 1 -> {
					if (i == novaPosLin || j == novaPosCol) {
						System.out.printf(" %s ", novoCaractere);
						continue;
					}
				}
				case 2 -> {
					if (i == novaPosLin && j == novaPosCol) {
						System.out.printf(" %s ", novoCaractere);
						continue;
					}
				}
				}

				System.out.printf(" %s ", caractere);
			}
			System.out.println("]");
		}

	}

}
