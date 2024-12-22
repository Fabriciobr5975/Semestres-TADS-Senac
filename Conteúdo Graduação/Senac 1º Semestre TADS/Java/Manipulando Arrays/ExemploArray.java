import java.util.Random;

public class ExemploArray {

	public static void preencheArray(int[] array) {
		Random rand = new Random();
		// percorrendo o array preenchendo com valores aleatórios
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
	}

	public static void exibeArray(int[] array) {
		// percorrendo o array para exibir os valores
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void exibeArray2(int[] array) {
		// percorrendo o array com for "melhorado"
		for (int num : array) {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		// array de inteiros com 10 posições
		int[] numeros = new int[10];
		// chama o método para preencher o array
		preencheArray(numeros);
		// chama o método para exibir os valores do array
		exibeArray(numeros);
		// chama o método para exibir os valores do array
		exibeArray2(numeros);
	}
}