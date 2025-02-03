
public class QuickSort {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[10];

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // Exibindo os valores do vetor
            System.out.println(vetor[i]);
        }
        
        // Chamando o método para a ordenação
        ordenacaoQuickSort(vetor, 0, vetor.length - 1);
        
        // Exibindo o método para a ordenação
        System.out.println("Nosso vetor Ordenado");
        for(int i : vetor){
            System.out.println(i);
        }
    }

    public static void ordenacaoQuickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            ordenacaoQuickSort(vetor, esquerda, p);
            ordenacaoQuickSort(vetor, p + 1, direita);
        }
    }

    public static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            do {
                i++;
            } while (vetor[i] < pivo);

            do {
                j--;
            } while (vetor[j] > pivo);

            if (i >= j) {
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
}
