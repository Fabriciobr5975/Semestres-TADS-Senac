package metodosordenacaotest;

public class MetodosOrdenacao {
    public static void main(String[] args) {
        // Criando um vetor de números inteiros de 10 posições;
        int[] vetor = new int[10];

        // Inserindo valores no vetor;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // Exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        quickSort(vetor, 0, vetor.length - 1);
        // Imprimindo os elementos;
        System.out.println("Vetor Ordenado");
        for (int i : vetor) {
            System.out.println(i);
        }

    } 
    public static void bubbleSort(int[] vetor) {
        int aux = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if(vetor[i] > vetor[j]){
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }
    }
    public static void selectionSort(int[] vetor){
        int menorPosicao, aux;
        
        for(int i = 0; i < vetor.length; i++){
            menorPosicao = i;
            for(int j = i + 1; j < vetor.length; j++){
                if(vetor[j] < vetor[menorPosicao]){
                    menorPosicao = j;
                }
            }
            
            aux = vetor[menorPosicao];
            vetor[menorPosicao] = vetor[i];
            vetor[i] = aux;
        }
    } 
    public static void insertionSort(int[] vetor){
        int aux, j;
        
        for(int i = 1; i < vetor.length; i++){
            aux = vetor[i];
            j = i - 1;
            
            while(j >= 0 && vetor[j] > aux){
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }
    
    public static void quickSort(int[] vetor, int esquerda, int direita){
        if(esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p + 1, direita);
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
            if(i >= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
}
