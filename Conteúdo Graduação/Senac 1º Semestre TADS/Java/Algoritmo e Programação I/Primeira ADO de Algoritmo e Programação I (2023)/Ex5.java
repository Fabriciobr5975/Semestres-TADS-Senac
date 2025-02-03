import java.util.Scanner;

public class Ex5 {

	/*
	 * 5. Crie um algoritmo que receba o nome e o salário de um funcionário, calcule
	 * seu novo salário sabendo que ele recebeu um aumento de 25% e mostre uma frase
	 * com o nome, o valor do aumento e o novo salário.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double salario, aumento, nSalario;
		String nome;
		// Variável Scanner;
		Scanner leitor = new Scanner(System.in);

		// Entrada de dados;
		System.out.println("Por favor, digite o nome do funcionário:");
		nome = leitor.nextLine();
		System.out.println("Agora digite o salário deste funcionário:");
		salario = leitor.nextDouble();
		// Cálculos;
		aumento = salario * 25 / 100; // AUMENTO DO SALÁRIO;
		nSalario = aumento + salario; // SALÁRIO COM O AUMENTO;
		// Exibir os resultados;
		System.out.printf("%nFuncionário: %s%nValor do aumento: %.02f%nValor do novo salário: %.02f", nome,
				aumento, nSalario);
		// Fechamento do Scanner;
		leitor.close();
	}

}
