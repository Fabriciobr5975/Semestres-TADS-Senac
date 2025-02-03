import java.util.Scanner;

public class Ex4 {

	/*
	 * Crie um algoritmo que receba três notas e seus respectivos pesos, calcule e
	 * mostre a média ponderada entre elas.
	 */

	public static void main(String[] args) {
		// Varíaveis;
		double nota1, nota2, nota3, pesoN1, pesoN2, pesoN3, m;
		// Variável Scanner;
		Scanner leitor = new Scanner(System.in);

		// Entrada de dados;
		System.out.println("Digite a primeira nota e o seu respectivo peso:"); 
		nota1 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		pesoN1 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		System.out.println("Digite a segunda nota e o seu respectivo peso:");
		nota2 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		pesoN2 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		System.out.println("Digite a terceira nota e o seu respectivo peso:");
		nota3 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		pesoN3 = leitor.nextDouble(); // ENTRADA DO USUÁRIO;

		// Cálculo da média ponderada;
		m = (pesoN1 * nota1 + pesoN2 * nota2 + pesoN3 * nota3) / (pesoN1 + pesoN2 + pesoN3);
		// Exibir a média ponderada;
		System.out.printf("A média ponderada foi: %.2f", m);
        // Fechamento do Scanner;
		leitor.close();

	}

}
