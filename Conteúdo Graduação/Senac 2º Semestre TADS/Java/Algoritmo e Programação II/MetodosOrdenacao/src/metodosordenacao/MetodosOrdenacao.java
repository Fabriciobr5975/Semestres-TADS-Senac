/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodosordenacao;

/**
 *
 * @author arauj
 */
public class MetodosOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Array para a manipulação dos métodos do tipo int; 
        int[] vetor1 = {21, 5, 40, 1, 10, 33, 17, 3};
        // Array para a manipulação dos métodos do tipo String;
        String[] vetor2 = {"F", "C", "B", "D", "A", "G", "E"};

        /**
         * Elemento a ser encontrado na busca binária;
         *
         * Obs: A busca binária é um método eficiente de busca que divide o
         * vetor ao meio para melhorar a busca, porém, entende-se que os
         * elementos dentro do vetor já estão odenados, caso o vetor não esteja
         * ordenado, o resultado pode ser diferente do esperando. Então caso
         * queria testar a busca binária lembre-se de ordenar os elementos do
         * vetor antes.
         */
        int elemento = 3;
        String elemento2 = "E";

        // Métodos de ordenação e a busca binária (int);
        // bubbleSort(vetor1);
        // selectionSort(vetor1);
        // insertionSort(vetor1);
        // buscabinaria(vetor1, elemento);

        // Métodos de ordenação e a busca binária (String);
        // bubbleSortString(vetor2); 
        // selectionSortString(vetor2);
        // insertionSortString(vetor2);
        // buscabinariaString(vetor2, elemento2);
    }

    /**
     * Método de ordenação do tipo BubbleSort para Inteiros
     *
     * @param vetor - Recebe um vetor de inteiros
     */
    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < (vetor.length - 1); i++) {
            for (int j = 0; j < (vetor.length - 1 - i); j++) {
                System.out.println("Iteração: " + (i + 1));
                if (vetor[j] > vetor[j + 1]) {
                    int aux;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
                printarVetores(vetor);
            }
        }
    }

    /**
     * Método de ordenação do tipo BubbleSort para String
     *
     * @param vetor - Recebe um vetor de String
     */
    public static void bubbleSortString(String[] vetor) {
        for (int i = 0; i < (vetor.length - 1); i++) {
            for (int j = 0; j < (vetor.length - 1 - i); j++) {
                System.out.println("Iteração: " + (i + 1));
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    String aux;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
                printarVetoresString(vetor);
            }
        }
    }

    /**
     * Método de ordenação do tipo Selection Sort para Inteiros
     *
     * @param vetor - Recebe um vetor de inteiros
     */
    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int index = i;
            System.out.println("Iteração: " + (i + 1));
            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[j] < vetor[index]) {
                    index = j;
                }
            }
            int aux = vetor[i];
            vetor[i] = vetor[index];
            vetor[index] = aux;

            printarVetores(vetor);
        }
    }

    /**
     * Método de ordenação do tipo Selection Sort para String
     *
     * @param vetor - Recebe um vetor de String
     */
    public static void selectionSortString(String[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int index = i;
            System.out.println("Iteração: " + (i + 1));
            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[index].compareTo(vetor[j]) > 0) {
                    index = j;
                }
            }
            String aux = vetor[i];
            vetor[i] = vetor[index];
            vetor[index] = aux;

            printarVetoresString(vetor);
        }
    }

    /**
     * Método de ordenação do tipo Insertion Sort para Inteiros
     *
     * @param vetor - Recebe um vetor de inteiros
     */
    public static void insertionSort(int[] vetor) {
        int i, t, j;
        for (i = 1; i < vetor.length; i++) {
            System.out.println("Iteração: " + (i));
            t = vetor[i];
            j = i - 1;
            while ((j >= 0) && (vetor[j] > t)) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = t;
            printarVetores(vetor);
        }
    }

    /**
     * Método de ordenação do tipo Insertion Sort para String
     *
     * @param vetor - Recebe um vetor do tipo String
     */
    public static void insertionSortString(String[] vetor) {
        int i, j;
        String t;
        for (i = 1; i < vetor.length; i++) {
            System.out.println("Iteração: " + (i));
            t = vetor[i];
            j = i - 1;
            while ((j >= 0) && (vetor[j].compareTo(t) > 0)) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = t;
            printarVetoresString(vetor);
        }
    }

    /**
     * Realiza a busca binária de um elemento de um vetor de Inteiros
     *
     * @param vetor - Recebe um vetor de inteiros
     * @param elemento - Recebe um elemento do tipo int para verificar se o
     * mesmo se encontra no vetor
     */
    public static void buscabinaria(int[] vetor, int elemento) {
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio = (fim + inicio) / 2;

        while (true) {
            if (elemento == vetor[meio]) {
                System.out.printf("O elemento %d foi encontrado na posicao %d%n", elemento, meio);
                break;

            } else if (elemento > vetor[meio]) {
                inicio = meio + 1;

            } else {
                fim = meio - 1;
            }
            meio = (fim + inicio) / 2;

            if (inicio >= fim) {
                System.out.printf("O elemento %d não foi encotrado! Verifique se o vetor está ordenado "
                        + "ou se o elemento que deseja buscar está presente no vetor%n", elemento);
                break;
            }
        }
    }

    /**
     * Realiza a busca binária de um elemento de um vetor de String
     *
     * @param vetor - Recebe um vetor de String
     * @param elemento - Recebe um elemento do tipo String para verificar se o
     * mesmo se encontra no vetor
     */
    public static void buscabinariaString(String[] vetor, String elemento) {
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio = (fim + inicio) / 2;

        while (true) {
            if (elemento.compareTo(vetor[meio]) == 0) {
                System.out.printf("O elemento %s foi encontrado na posicao %d%n", elemento, meio);
                break;

            } else if (elemento.compareTo(vetor[meio]) > 0) {
                inicio = meio + 1;

            } else {
                fim = meio - 1;
            }
            meio = (fim + inicio) / 2;

            if (inicio >= fim) {
                System.out.printf("O elemento %s não foi encotrado! Verifique se o vetor está ordenado "
                        + "ou se o elemento que deseja buscar está presente no vetor%n", elemento);
                break;
            }

        }
    }

    /**
     * Método para printar os vétores ordenados pelos métodos de ordenação
     * usando o tipo Inteiro
     *
     * @param vetor - Recebe um vetor de inteiro
     */
    public static void printarVetores(int[] vetor) {
        for (int i : vetor) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * Método para printar os vétores ordenados pelos métodos de ordenação
     * usando o tipo String
     *
     * @param vetor - Recebe um vetor de String
     */
    public static void printarVetoresString(String[] vetor) {
        for (String i : vetor) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
