/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosdeordenacao;

import java.util.List;

/**
 *
 * @author arauj
 */
public final class MetodosDeOrdenacao {

    public static <T extends Comparable<T>> void bubbleSort(T[] vetor) {
        for (int i = 0; i < (vetor.length - 1); i++) {
            for (int j = 0; j < (vetor.length - 1 - i); j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    T aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> lista) {
        for (int i = 0; i < (lista.size() - 1); i++) {
            for (int j = 0; j < (lista.size() - 1 - i); j++) {
                if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {
                    T aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int index = i;
            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[j].compareTo(vetor[index]) < 0) {
                    index = j;
                }
            }

            T aux = vetor[i];
            vetor[i] = vetor[index];
            vetor[index] = aux;

        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int index = i;
            for (int j = (i + 1); j < lista.size(); j++) {
                if (lista.get(j).compareTo(lista.get(index)) < 0) {
                    index = j;
                }
            }

            T aux = lista.get(i);
            lista.set(i, lista.get(index));
            lista.set(index, aux);

        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            T aux = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].compareTo(aux) > 0) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> lista) {
        for (int i = 1; i < lista.size(); i++) {
            T aux = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).compareTo(aux) > 0) {
                lista.set((j + 1), lista.get(j));
                j--;
            }
            lista.set((j + 1), aux);
        }
    }

    private static <T extends Comparable<T>> void quickSort(T[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int particao = particacaoQuickSort(vetor, esquerda, direita);
            quickSort(vetor, esquerda, particao);
            quickSort(vetor, (particao + 1), direita);
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static <T extends Comparable<T>> int particacaoQuickSort(T[] lista, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        T pivo = lista[meio];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            do {
                i++;
            } while (lista[i].compareTo(pivo) < 0);

            do {
                j--;
            } while (lista[j].compareTo(pivo) > 0);

            if (i >= j) {
                return j;
            }

            T aux = lista[i];
            lista[i] = lista[j];
            lista[j] = aux;
        }
    }
    
    private static <T extends Comparable<T>> void quickSort(List<T> lista, int esquerda, int direita) {
        if (esquerda < direita) {
            int particao = particacaoQuickSort(lista, esquerda, direita);
            quickSort(lista, esquerda, particao);
            quickSort(lista, (particao + 1), direita);
        }
    }

    public static <T extends Comparable<T>> void quickSort(List<T> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private static <T extends Comparable<T>> int particacaoQuickSort(List<T> lista, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        T pivo = lista.get(meio);
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            do {
                i++;
            } while (lista.get(i).compareTo(pivo) < 0);

            do {
                j--;
            } while (lista.get(j).compareTo(pivo) > 0);

            if (i >= j) {
                return j;
            }

            T aux = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, aux);
        }
    }

    public static void shellSort(int[] vetor) {
        int h = 1;
        int tamanhoVetor = vetor.length;

        while (h < tamanhoVetor) {
            h = h * 3 + 1;
        }
        h = (int) Math.floor(h / 3);

        int elemento, j;

        while (h > 0) {
            for (int i = h; i < tamanhoVetor; i++) {
                elemento = vetor[i];
                j = i;

                while (j >= h && vetor[j - h] > elemento) {
                    vetor[j] = vetor[j - h];
                    j = j - h;
                }
                vetor[i] = elemento;
            }
            h = h / 2;
        }
    }
}
