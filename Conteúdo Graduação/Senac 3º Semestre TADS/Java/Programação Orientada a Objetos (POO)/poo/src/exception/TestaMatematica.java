package exception;

import java.util.Scanner;

public class TestaMatematica {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int valor, gerar;

		do {
			try {
				System.out.println("Digite um valor");
				valor = scanner.nextInt();
				gerar = Matematica.gerarNumero(valor);
				break;
			} catch (NumeroInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Código do erro: " + e.getCodigoErro());
				continue;
			}
		} while (true);
		
		System.out.println("Valor gerado: " + gerar);
		scanner.close();
	}
}
