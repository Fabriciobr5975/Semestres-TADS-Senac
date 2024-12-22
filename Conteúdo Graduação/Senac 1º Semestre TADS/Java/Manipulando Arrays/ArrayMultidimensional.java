import java.util.Random;

public class ArrayMultidimensional {
	static Random rand = new Random();

	public static void main(String[] args) {
		arrayBi();
		// arrayTri();

	}

	public static boolean procurar(int[][] array, int num) {
		boolean achou = false;
		// percorrer o array verificando se tem o número
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++){
			if (array[i][j] == num) {
				achou = true;
				continue;
			}
		}
			
		}	
		return achou;
	}

	public static void arrayBi() {
		// array bidimensional de 4 x 10
		int[][] matriz = new int[4][10];
		// preenchendo o array bidimensional
		for (int lin = 0; lin < matriz.length; lin++) {
			for (int col = 0; col < matriz[lin].length; col++) {
				// evita números repetidos na linha
				int num;
				do {
					num = rand.nextInt(45);
				} while (procurar(matriz, num));
				matriz[lin][col] = num;
			}
		}
		// exibindo os elementos do array
		for (int lin = 0; lin < matriz.length; lin++) {
			System.out.print("[ ");
			for (int col = 0; col < matriz[lin].length; col++) {
				System.out.printf("%03d ", matriz[lin][col]);
			}
			System.out.println("]");
		}
		System.out.println();
		// exibindos os elementos com "for each"
		for (int[] a1 : matriz) {
			System.out.print("[ ");
			for (int n : a1) {
				System.out.printf("%03d ", n);
			}
			System.out.println("]");
		}
	}

	public static void arrayTri() {
		// array tridimensional de 5 x 6 x 10
		int[][][] arrayTri = new int[5][6][10];
		// preenchendo o array tridimensional
		for (int i = 0; i < arrayTri.length; i++) {
			for (int j = 0; j < arrayTri[i].length; j++) {
				for (int k = 0; k < arrayTri[i][j].length; k++) {
					arrayTri[i][j][k] = rand.nextInt(101);
				}
			}
		}
		// exibindo os elementos do array
		for (int i = 0; i < arrayTri.length; i++) {
			for (int lin = 0; lin < arrayTri[i].length; lin++) {
				System.out.print("[ ");
				for (int col = 0; col < arrayTri[i][lin].length; col++) {
					System.out.printf("%03d ", arrayTri[i][lin][col]);
				}
				System.out.println("]");
			}
			System.out.println();
		}
		// exibindo os elementos do array com "for each"
		for (int[][] a1 : arrayTri) {
			for (int[] a2 : a1) {
				System.out.print("[ ");
				for (int valor : a2) {
					System.out.printf("%03d ", valor);
				}
				System.out.println("]");
			}
			System.out.println();
		}
	}
}