
public class BubbleSortTime {
     public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[100];
        // Tempo de Execução para um vetor com 100 = 0
        // Tempo de Execução para um vetor com 1.000 = 3
        // Tempo de Execução para um vetor com 10.000 = 43
        // Tempo de Execução para um vetor com 100.000 = 4048
        
        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // Variável que registra o tempo de execução no início;
        long inicio = System.currentTimeMillis();

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
        
  
        // Variável para registrar o tempo de execução no final;
        long fim = System.currentTimeMillis();
        
        // Exibindo o tempo de execução;
        System.out.println("Tempo de execução: " + (fim - inicio));   
    }
}
