import java.util.Scanner;

public class Ex16 {

/*
	16. Sabe-se que 1 pé = 12 polegadas, 1 jarda = 3 pés, 1 milha = 1760 jardas. Crie um
			algoritmo que receba uma medida em pés, faça as conversões e mostre os
			resultados em:
			a) Polegadas;
			b) Jardas;
			c) Milhas. 
*/	

	public static void main(String[] args) {
		// Variáveis;
		double pe, polegadas, jardas, milhas;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		
		// Entrada de dados;
		System.out.println("Olá, Digite um medida em pés para a conversão:");
		pe = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		polegadas = pe * 12; // CÁLCULO DE POLEGADAS;
		jardas = pe / 3; // CÁLCULO DE JARDAS;
		milhas = pe / 3 / 1760; // CÁLCULO DE MILHAS;
		// Exibir os resultados
		System.out.printf("Os resultados da conversão de Pés para Polegadas, Jardas e Milhas foram às seguintes:"
				+ "%nPolegadas - %.2f%nJardas - %.2f%nMilhas - %.2f%n", polegadas, jardas, milhas);
		// Fechamento do Scanner
		leitor.close();
				
		
		

	}

}
