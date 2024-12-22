import java.util.Scanner;

public class Ex17 {

	/*
	 * 17. Crie um algoritmo que receba os valores dos catetos de um triângulo,
	 * calcule e mostre o valor da hipotenusa.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double hipotenusa, cateto1, cateto2;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		// Entrada de dados;
		System.out.println("Olá, digite o valor do primeiro cateto:");
		cateto1 = leitor.nextDouble(); // ENTRADA DO USUÁRIO (PRIMEIRO CATETO);
		System.out.println("Ótimo, agora digite o valor do segundo cateto:");
		cateto2 = leitor.nextDouble(); // ENTRADA DO USUÁRIO (SEGUNDO CATETO);
		// Cálculo da Hipotenusa;
		hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)); // RESULTADO;
		System.out.printf("o resultado do Hipotenusa é: %.2f", hipotenusa);
		// Fechamento do Scanner;
		leitor.close();
	}

}
