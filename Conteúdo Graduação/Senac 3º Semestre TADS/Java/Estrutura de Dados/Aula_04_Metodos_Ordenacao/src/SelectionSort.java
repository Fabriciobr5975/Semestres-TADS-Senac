
public class SelectionSort {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[10];

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // Exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        // Método de ordenação SelectionSort; 
        int menorPosicao, aux;
        for (int i = 0; i < vetor.length; i++) {
            menorPosicao = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menorPosicao]) {
                    menorPosicao = j;
                }
            }
            aux = vetor[menorPosicao];
            vetor[menorPosicao] = vetor[i];
            vetor[i] = aux;
        }

        // Imprimindo os elementos;
        System.out.println("Vetor Ordenado");
        for (int i : vetor) {
            System.out.println(i);
        }
    }
}
