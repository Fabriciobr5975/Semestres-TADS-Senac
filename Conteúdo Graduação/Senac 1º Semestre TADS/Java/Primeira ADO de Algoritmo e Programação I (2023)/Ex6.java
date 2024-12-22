import java.util.Scanner;

public class Ex6 {

	/*
	 * 6. Crie um algoritmo que receba o salário bruto de um funcionário e exiba o
	 * seu salário líquido, sabendo que ele tem 10% de gratificação sobre o salário
	 * bruto e tem 15% de descontos sobre o salário após a gratificação.
	 */

	public static void main(String[] args) {

		// Variáveis;
		double salBruto, salario, gratificacao, desconto, tSBruto;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);

		// Entrada de Dados;
		System.out.println("Seja bem vindo! Digite o seu salário bruto:"); // ENTRADA DO SALÁRIO BRUTO
		salBruto = leitor.nextDouble(); // ENTRADA DO USUÁRIO

		// Cálculos;
		gratificacao = salBruto * 10 / 100; // CÁLCULO DA GRATIFICAÇÃO;
		tSBruto = salBruto + gratificacao; // CÁLCULO DO TOTAL DO SALÁRIO BRUTO;
		desconto = tSBruto * 15 / 100; // CÁLCULO DO DESCONTO;
		salario = tSBruto - desconto; // CÁLCULO DO SALÁRIO;

		// Exibir os resultados;
		System.out.printf("%nSalário Bruto com a Gratificação: R$%5.2f%nDescontos: "
				+ "R$%5.2f%nSalário Líquido: R$%5.2f ", tSBruto, desconto, salario);
		// Fechamento do Scanner;
		leitor.close();

	}

}