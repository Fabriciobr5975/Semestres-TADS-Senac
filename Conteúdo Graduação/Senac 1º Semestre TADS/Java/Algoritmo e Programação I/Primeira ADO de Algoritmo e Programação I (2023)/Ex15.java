import java.util.Scanner;

public class Ex15 {

	/*
	 * 15. Pedro comprou um saco de ração com peso em Kg. Ele possui dois gatos,
	 * para os quais fornece a quantidade de ração em gramas. A quantidade diária de
	 * ração fornecida para cada gato é sempre a mesma. Crie um algoritmo que receba
	 * o peso do saco de ração e a quantidade de ração fornecida para cada gato,
	 * calcule e mostre quanto restará de ração no saco após cinco dias.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double saco, g, qtdracao, cincoDias, gParakg;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		
		// Entrada de dados;
		System.out.println("Digite o peso do saco de ração em KG:");
		saco = leitor.nextDouble(); // ENTRADA DO USUÁRIO
		g = saco * 1000; // DE KILO PARA GRAMAS
		// Entrada de dados;
		System.out.println("Agora, digite quanto em gramas que cada gato consome por dia:");
		qtdracao = leitor.nextDouble(); // ENTRADA DO USUÁRIO;
		// Cálculos;
		cincoDias = g - qtdracao * 2 * 5; // CÁLCULO DO RESTANTE DE RAÇÃO APÓS CINCO DIAS;
		gParakg = cincoDias / 1000; // PASSANDO GRAMAS PARA KG
		// Exibir o resultado;
		System.out.printf("%nApós cinco dias, restará: %.2f gramas ou %.2f kg ", cincoDias, gParakg);
		// Fechamento do Scanner;
		leitor.close();
									
	}

}
