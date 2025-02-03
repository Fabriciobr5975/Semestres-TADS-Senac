import java.util.Scanner;

public class Ex11 {

/*	
   11. Crie um algoritmo que resolva a seguinte equação 𝑥^2 − 5𝑥 + 6 = 0.
*/		
	public static void main(String[] args) {
		// Variáveis
		double a = 1, b = - 5, c =6, Delta, primeiroValorX, segundoValorX; 
		// Variável do Scanner;
		Scanner leitor = new Scanner(System.in);
		
		// Fórmula de bhaskara 
		Delta = Math.pow(b,2) - 4 * a * c; // RESULTADO ESPERADO : 1
		primeiroValorX = (- b + Math.sqrt(Delta)) / 2 * a; // RESULTADO ESPERADO: 3
		segundoValorX = (- b - Math.sqrt(Delta)) / 2 * a; // RESULTADO ESPERADO : 2
		
		// Exibição do resultado da equação;
		System.out.printf("o resultado da equação é:{%.0f,%.0f}",primeiroValorX, segundoValorX);
		// Fechamento do Scanner;
		leitor.close();
		
		
	}

}
