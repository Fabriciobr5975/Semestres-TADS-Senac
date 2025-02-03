import java.util.Scanner;

public class Ex9 {

/*	
   Crie um algoritmo que receba o raio de um círculo, calcule e mostre a sua área e o
   seu perímetro
*/	
	
	public static void main(String[] args) {
		// Variáveis;
		double raio, area, perimetro;
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		// Entrada de dados;
		System.out.println("Olá! Por favor, digite o valor do raio:"); // MENSAGEM DO INÍCIO DO PROGRAMA;
		raio = leitor.nextDouble(); // ENTRADA DO USUÁRIO (VALOR DO RAIO;
		area = Math.PI * Math.pow(raio,2); // CÁLCULO DA ÁREA;
		perimetro = 2 * Math.PI * raio; // CÁLCULO DO PERIMETRO;
		// Exibir os resultados;
		System.out.printf("A área é: %.2f%nO perímetro é: %.2f", area, perimetro); // RESULTADO
		// Fechamento do Scanner
		leitor.close();
		
		

	}

}
