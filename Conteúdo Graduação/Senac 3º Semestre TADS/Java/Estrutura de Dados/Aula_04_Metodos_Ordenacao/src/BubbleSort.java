
public class BubbleSort {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[10];

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // Exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        // Método de ordenação BubbleSort; 
        int aux;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    aux = vetor[j];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        // Imprimindo os elementos;
        System.out.println("Vetor Ordenado");
        for (int i : vetor) {
            System.out.println(i);
        }

    }

    public static void bubbleSort(int vetor[]) {
        int aux = 0;
        for (int i = 0; i < (vetor.length - 1); i++) {
            System.out.println("Iteração: " + (i + 1));
            for (int j = 0; j < (vetor.length - 1 - i); j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
                System.out.print(vetor[j] + "\t");
            }
            System.out.println("");
        }
    }
}
