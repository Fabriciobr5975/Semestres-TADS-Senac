
public class InsertionSort {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[10];

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // Exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        // Método de ordenação InsertionSort; 
        int aux, j;
        for (int i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            j = i - 1;
            while (j >= 0 && vetor[j] > aux) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }

        // Imprimindo os elementos;
        System.out.println("Vetor Ordenado");
        for (int i : vetor) {
            System.out.println(i);
        }

    }
}
