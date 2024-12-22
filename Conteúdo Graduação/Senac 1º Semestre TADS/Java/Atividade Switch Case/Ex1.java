import java.util.Scanner;

public class Ex1 {

	/*
	 * 1. Crie um algoritmo em que o usuário digite seu plano de saúde, e seja
	 * exibido o valor da sua respectiva mensalidade, de acordo com a tabela abaixo.
	 * Caso seja informado um plano inválido, avise o usuário
	 */

	public static void main(String[] args) {

		// Variáveis;
		int plano, valor;

		// Scanner
		Scanner leitor = new Scanner(System.in);

		// Entrada de dados;
		System.out.println("Olá, digite qual é o seu plano:");
		System.out.println("1. Básico");
		System.out.println("2. Bronze");
		System.out.println("3. Prata");
		System.out.println("4. Ouro");

		plano = leitor.nextInt();

		switch (plano) {
		case 1 -> {
			valor = 150;
			System.out.println("O Valor do seu plano é: R$" + valor);
		}
		case 2 -> {
			valor = 220;
			System.out.println("O Valor do seu plano é: R$" + valor);
		}
		case 3 -> {
			valor = 310;
			System.out.println("O Valor do seu plano é: R$" + valor);
		}
		case 4 -> {
			valor = 450;
			System.out.println("O Valor do seu plano é: R$" + valor);

		}
		default -> System.out.println("Opção inválida !");
		}

		leitor.close();
	}

}
