package metodosdebusca;

/**
 * Interface para o tratamento do algoritmo de busca binária. Contém dois
 * métodos: um método abstrato sem implementação, permitindo ao usuário definir
 * a lógica, e um método default que retorna o resultado do método abstrato,
 * implementando uma busca recursiva padrão. Esta interface estende a interface
 * <code>Comparable</code>, assegurando que os objetos comparados possam ser
 * ordenados segundo a ordem natural.
 *
 * @author Fabrício de Araújo Santana
 * @param <T> A interface é genérica, permitindo seu uso com qualquer tipo de
 * objeto que implemente <code>Comparable</code>.
 */
public interface BuscaBinaria<T extends Comparable<T>> {

    /**
     * Método para realizar a busca binária, seja recursiva ou iterativa. Este
     * método pode ser utilizado pelo método default desta interface para criar
     * uma solução recursiva, ou pode ser implementado separadamente para
     * fornecer uma solução personalizada.
     *
     * @param vetor Array genérico contendo os elementos a serem buscados.
     * @param elemento Elemento a ser procurado no array.
     * @param inicio Índice inicial da busca no array.
     * @param fim Índice final da busca no array.
     * 
     * @return A posição do elemento no array, ou -1 se o elemento não for
     * encontrado.
     */
    int buscaBinaria(T[] vetor, T elemento, int inicio, int fim);

    /**
     * Método default que implementa uma busca binária recursiva em todo o
     * array. Este método chama o método abstrato <code>buscaBinaria</code> com
     * os índices iniciais e finais correspondentes ao tamanho total do array.
     *
     * @param vetor Array genérico contendo os elementos a serem buscados.
     * @param elemento Elemento a ser procurado no array.
     * 
     * @return A posição do elemento no array, ou -1 se o elemento não for
     * encontrado.
     */
    default int buscaBinaria(T[] vetor, T elemento) {
        return buscaBinaria(vetor, elemento, 0, vetor.length - 1);
    }
}
