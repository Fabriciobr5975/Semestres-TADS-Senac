
public class InsertionSortTime {

    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[100];
        // Tempo de Execução para um vetor com 100 = 0  
        // Tempo de Execução para um vetor com 1.000 = 3 
        // Tempo de Execução para um vetor com 10.000 = 14
        // Tempo de Execução para um vetor com 100.000 = 946

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
           
        }

        // Variável que registra o tempo de execução no início;
        long inicio = System.currentTimeMillis();

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

        // Variável para registrar o tempo de execução no final;
        long fim = System.currentTimeMillis();

        // Exibindo o tempo de execução;
        System.out.println("Tempo de execução: " + (fim - inicio));

    }
}
