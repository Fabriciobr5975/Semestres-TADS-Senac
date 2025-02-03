import java.util.Scanner;

public class Ex8 {

	/*
	 * 8. Crie um algoritmo que receba como entrada a base e a altura de um
	 * triângulo, calcule e mostre a sua área.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double base, altura, area;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		// Entrada de dados;
		System.out.println("Olá! Digite a base do triângulo:");
		base = leitor.nextDouble(); // ENTRADA DO USUÁRIO (BASE);
		System.out.println("Ótimo, agora digite a altura do triângulo:");
		altura = leitor.nextDouble(); // ENTRADA DO USUÁRIO (ALTURA);
		// Calculo da área (b * h / 2);
		area = base * altura / 2;
        // Exibir o resultado;
		System.out.printf("A área é: %.2f", area);
		// Fechamento do Scanner;
		leitor.close();

	}

}