
public class QuickSortTime {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[1000000000];
        // Tempo de Execução para um vetor com 100 = 0
        // Tempo de Execução para um vetor com 1.000 = 0
        // Tempo de Execução para um vetor com 10.000 = 2
        // Tempo de Execução para um vetor com 100.000 = 17

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // Variável que registra o tempo de execução no início;
        long inicio = System.currentTimeMillis();

        // Chamando o método para a ordenação
        ordenacaoQuickSort(vetor, 0, vetor.length - 1);

        // Variável para registrar o tempo de execução no final;
        long fim = System.currentTimeMillis();
        // Exibindo o tempo de execução;
        System.out.println("Tempo de execução: " + (fim - inicio));

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
