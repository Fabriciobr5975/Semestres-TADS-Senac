package metodosdebusca;

import java.util.List;

/**
 * Classe contendo métodos estáticos para realizar a busca binária de elementos
 * em arrays e objetos da classe <code>List</code>. As buscas são implementadas
 * de forma recursiva.
 *
 * A busca binária funciona dividindo repetidamente o array ou a lista, de forma
 * que na cada etapa se possa descartar metade dos elementos que não contêm o
 * valor de interesse. Para que a busca binária funcione, a lista ou array deve
 * estar previamente ordenada.
 *
 * @author Fabrício de Araújo Santana
 */
public final class MetodosBuscasUtil {

    /**
     * Construtor privado para que essa classe não seja instanciada
     */
    private MetodosBuscasUtil() {
    }

    /**
     * Método que busca um elemento em um array em um intervalo específico. A
     * busca é implementada de forma recursiva.
     *
     * @param <T> Tipo genérico que deve estender a interface
     * <code>Comparable</code>
     * @param lista Array de elementos onde a busca será realizada
     * @param elemento Elemento a ser buscado
     * @param inicio Índice de início da busca, geralmente 0 para buscar em toda
     * a lista
     * @param fim Índice de término da busca, geralmente o tamanho do array - 1
     * para incluir a última posição
     *
     * @return A posição do elemento no array, ou -1 se não for encontrado
     *
     * @throws IllegalArgumentException Caso o array ou o elemento passado
     * esteja vazio ou seja nulo
     */
    public static <T extends Comparable<T>> int buscaBinaria(T[] lista, T elemento, int inicio, int fim) throws IllegalArgumentException {
        if (elemento == null) {
            throw new IllegalArgumentException("Não é possível buscar se o valor for nulo");

        } else if (lista == null || lista.length == 0) {
            throw new IllegalArgumentException("Não é possível realizar a busca pois a lista está vazia");
        }

        if (inicio > fim) {
            return -1;
        }

        int meio = inicio + (fim - inicio) / 2;

        if (elemento.equals(lista[meio])) {
            return meio;

        } else if (elemento.compareTo(lista[meio]) > 0) {
            return buscaBinaria(lista, elemento, meio + 1, fim);
        }

        return buscaBinaria(lista, elemento, inicio, meio - 1);
    }

    /**
     * Método que busca um elemento em um array. A busca é implementada de forma
     * recursiva.
     *
     * @param <T> Tipo genérico que deve estender a interface
     * <code>Comparable</code>
     * @param lista Array de elementos onde a busca será realizada
     * @param elemento Elemento a ser buscado
     *
     * @return A posição do elemento no array, ou -1 se não for encontrado
     *
     * @throws IllegalArgumentException Caso o array ou o elemento passado
     * esteja vazio ou seja nulo
     */
    public static <T extends Comparable<T>> int buscaBinaria(T[] lista, T elemento) throws IllegalArgumentException {
        return buscaBinaria(lista, elemento, 0, lista.length - 1);
    }

    /**
     * Método que busca um elemento em um <code>List</code> em um intervalo
     * específico. A busca é implementada de forma recursiva.
     *
     * @param <T> Tipo genérico que deve estender a interface
     * <code>Comparable</code>
     * @param lista Objeto do Tipo <code>List</code> que contém os elementos
     * para realizar a busca
     * @param elemento Elemento a ser buscado
     * @param inicio Índice de início da busca, geralmente 0 para buscar em toda
     * a lista
     * @param fim Índice de término da busca, geralmente o tamanho da lista - 1
     * para incluir a última posição
     *
     * @return A posição do elemento na lista, ou -1 se não for encontrado
     *
     * @throws IllegalArgumentException Caso a lista ou o elemento passado
     * esteja vazio ou seja nulo
     */
    public static <T extends Comparable<T>> int buscaBinaria(List<T> lista, T elemento, int inicio, int fim) throws IllegalArgumentException {
        if (elemento == null) {
            throw new IllegalArgumentException("Não é possível buscar se o valor for nulo");

        } else if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("Não é possível realizar a busca pois a lista está vazia");
        }

        if (inicio > fim) {
            return -1;
        }

        int meio = inicio + (fim - inicio) / 2;

        if (elemento.equals(lista.get(meio))) {
            return meio;

        } else if (elemento.compareTo(lista.get(meio)) > 0) {
            return buscaBinaria(lista, elemento, meio + 1, fim);
        }

        return buscaBinaria(lista, elemento, inicio, meio - 1);
    }

    /**
     * Método que busca um elemento em um <code>List</code>. A busca é
     * implementada de forma recursiva.
     *
     * @param <T> Tipo genérico que deve estender a interface
     * <code>Comparable</code>
     * @param lista Objeto do Tipo <code>List</code> que contém os elementos
     * para realizar a busca
     * @param elemento Elemento a ser buscado
     *
     * @return A posição do elemento na lista, ou -1 se não for encontrado
     *
     * @throws IllegalArgumentException Caso a lista ou o elemento passado
     * esteja vazio ou seja nulo
     */
    public static <T extends Comparable<T>> int buscaBinaria(List<T> lista, T elemento) throws IllegalArgumentException {
        return buscaBinaria(lista, elemento, 0, lista.size() - 1);
    }
}
