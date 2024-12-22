import java.util.Scanner;

public class Ex2 {

	/*
	 * Um vendedor precisa de um algoritmo que calcule o preço total devido por um
	 * cliente. O algoritmo deve receber o código de um produto, a quantidade
	 * comprada e calcular o preço total de acordo com a tabela abaixo. Mostre uma
	 * mensagem no caso de código inválidopublic
	 */

	public static void main(String[] args) {

		
		// Variáveis;
		int qtdProduto;
		String codigo;
		// Scanner;
		Scanner leitor = new Scanner(System.in);
		
		// Entrada de dados;
		System.out.println("Digite o código do produto: A001 , A002 , A003 ou A004");
		codigo = leitor.nextLine();
		System.out.println("Digite a qtd que foi comprada:");
		qtdProduto = leitor.nextInt();
		
		switch (codigo.toUpperCase()) {
		case "A001" ->{
			double valorCod;
			valorCod = 7.50;
			valorCod *= qtdProduto;
			System.out.printf("O preço total foi: %.2f", valorCod);
		} 
		case "A002" -> {
			double valorCod;
			valorCod = 9.90;
			valorCod *= qtdProduto;
			System.out.printf("O preço total foi: %.2f", valorCod);
		} 
		case "A003" -> {
			double valorCod;
			valorCod = 14.00;
			valorCod *= qtdProduto;
			System.out.printf("O preço total foi: %.2f", valorCod);
		}
		case "A004" -> {
			double valorCod;
			valorCod = 19.99;
			valorCod *= qtdProduto;
			System.out.printf("O preço total foi: %.2f", valorCod);
		}
		default -> System.out.println("Opção Inválida");
		}
		leitor.close();
	}
}