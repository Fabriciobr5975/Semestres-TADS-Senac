import java.util.Scanner;

public class Ex12 {

	/*
	 * 12. Crie um algoritmo que receba os valores de 𝑎, 𝑏 𝑒 𝑐 e calcule a
	 * equação de segundo grau formada por 𝑎𝑥2 + 𝑏𝑥 + 𝑐 = 0
	 */
	public static void main(String[] args) {
		// Variáveis
		double a, b, c, Delta, primeiroValorX, segundoValorX;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);

		System.out.println("Olá! Digite um número para a, b e c:");
		a = leitor.nextDouble(); // ENTRADO DO USUÁRIO;
		b = leitor.nextDouble(); // ENTRADO DO USUÁRIO;
		c = leitor.nextDouble(); // ENTRADO DO USUÁRIO;
		// Fórmula de bhaskara;
		Delta = Math.pow(b, 2) - 4 * a * c; // CÁLCULO DO DELTA;

		if (Delta >= 0) { // MAIOR OU IGUAL A ZERO CONTINUA A CONTA

			primeiroValorX = (-b + Math.sqrt(Delta)) / (2 * a);
			segundoValorX = (-b - Math.sqrt(Delta)) / (2 * a);
			// Exibição do resultado da equação;
			System.out.printf("Resultado da equação:{%.2f , %.2f}", primeiroValorX, segundoValorX);

		} else { // SE NÃO FOR MAIOR OU IGUAL A ZERO, PARAR A CONTA

			System.out.println("Desculpe, não foi possivel calcular!");
		}
		// Fechamento do Scanner;
		leitor.close();

	}

}
