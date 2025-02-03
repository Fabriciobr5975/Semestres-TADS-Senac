import java.util.Scanner;

public class Ex3 {

	/*
	 * 3. Crie um algoritmo que receba o código correspondente ao cargo de um
	 * funcionário e seu salário atual e mostre o cargo, o valor do aumento e seu
	 * novo salário. Os cargos estão na tabela abaixo.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double salario, aumento, novoSalario;
		String cargo, codigo;

		// Scanner;
		Scanner leitor = new Scanner(System.in);

		// Entrada de dados;
		System.out.println(
				"Olá, digite o código do seu cargo:\n1.Escriturário - n2.Secretário - n3.Caixa \n4.Gerente - 5.Diretor");
		codigo = leitor.nextLine();
		System.out.println("Digite o seu salário atual");
		salario = leitor.nextDouble();

		// Switch Case;
		switch (codigo) {
		case "1" -> {
			cargo = "Escriturário";
			aumento = (salario * 50) / 100;
			novoSalario = salario + aumento;
			System.out.printf("\nO seu cargor é %s%nO valor do aumento é %.2f%ne o seu novo salário é %.2f", cargo, aumento ,novoSalario);
		}
		case "2" -> {
			cargo = "Secretário";
			aumento = (salario * 35) / 100;
			novoSalario = salario + aumento;
			System.out.printf("\nO seu cargor é %s%nO valor do aumento é %.2f%ne o seu novo salário é %.2f", cargo, aumento ,novoSalario);
		}
		case "3"-> {
			cargo = "Caixa";
			aumento = (salario * 20) / 100;
			novoSalario = salario + aumento;
			System.out.printf("\nO seu cargor é %s%nO valor do aumento é %.2f%ne o seu novo salário é %.2f", cargo, aumento ,novoSalario);
		}
		case "4" -> {
			cargo = "Gerente";
			aumento = (salario * 10) / 100;
			novoSalario = salario + aumento;
			System.out.printf("\nO seu cargor é %s%nO valor do aumento é %.2f%ne o seu novo salário é %.2f", cargo, aumento ,novoSalario);
		}
		case "5" -> {
			cargo = "Diretor";
			System.out.printf("\nO seu cargor é %s%nvocê não teve aumento no salário!%nSeu salário é %.2f", cargo, salario);
		}
		default -> System.out.println("Informação Inválida");
		}
		leitor.close();
	}
}

