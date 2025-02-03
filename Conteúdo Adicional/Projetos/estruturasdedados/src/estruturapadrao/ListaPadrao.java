package estruturapadrao;

import metodosdebusca.BuscaBinaria;

/**
 * Interface com métodos para a criação de uma lista com as seguintes
 * manipulações: inserção, busca, remoção, limpar a lista, e alguns métodos
 * adicionais, como a verificação se a lista está vazia
 *
 * @author Fabrício de Araújo Santana
 * @param <T> Tipo Genérico para a criação da lista
 */
public interface ListaPadrao<T extends Comparable<T>> extends BuscaBinaria<T> {

    // Atributo para a mensagem de exceções quando a lista estiver vazia
    final String MENSAGEM_LISTA_VAZIA = "A Lista está vazia";

    /**
     * Método para adicionar um elemento dentro da lista
     *
     * @param elemento Recebe um elemento genérico do mesmo tipo da lista
     */
    public void adicionar(T elemento);

    /**
     * Método para adicionar um elemento no início da lista.
     *
     * @param elemento Recebe um elemento genérico do mesmo tipo da lista
     */
    public void adicionarInicio(T elemento);

    /**
     * Método para adicionar um elemento em um posição específica, passada pelo
     * usuário
     *
     * @param elemento Recebe um elemento genérico do mesmo tipo da lista
     * @param posicao Recebe a posição que o elemento entrará
     *
     * @throws ArrayIndexOutOfBoundsException Caso a posição passada pelo
     * usuário não corresponda a uma posição válida dentro da lista.
     */
    public void adicionar(T elemento, int posicao) throws ArrayIndexOutOfBoundsException;

    /**
     * Método para remover o elemento que se encontra no início da lista
     *
     * @return Retorna o elemento que foi removido da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T removerDoInicio() throws NullPointerException, RuntimeException;

    /**
     * Método para remover o último elemento da lista
     *
     * @return Retorna o elemento que foi removido da lista
     *
     * @throws NullPointerException Caso o elemento seja null, ou seja, um
     * elemento que não é válido
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T removerDoFim() throws NullPointerException, RuntimeException;

    /**
     * Método para remover um elemento passado sua posição dentro da lista
     *
     * @param posicao Recebe uma posição válida para realizar a remoção do
     * elemento
     *
     * @return Retorna o elemento que foi removido da lista
     *
     * @throws NullPointerException Caso o elemento seja null, ou seja, um
     * elemento que não é válido
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T remover(int posicao) throws ArrayIndexOutOfBoundsException, NullPointerException, RuntimeException;

    /**
     * Método para remover elemento passando um elemento que está dentro da
     * lista
     *
     * @param elemento Recebe um elemento genérico do mesmo tipo da lista
     *
     * @return Retorna o elemento que foi removido da lista
     *
     * @throws ArrayIndexOutOfBoundsException Caso a posição passada pelo
     * usuário não corresponda a uma posição válida dentro da lista.
     * 
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     *
     * @throws NullPointerException Caso o elemento não seja encontrado para a
     * remoção
     */
    public T remover(T elemento) throws RuntimeException, NullPointerException;

    /**
     * Método para buscar um elemento passando a uma posição posição válida
     *
     * @param posicao Recebe a posição válida do elemento que se deseja buscar
     *
     * @return Retorna o elemento que encotrado da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     *
     * @throws ArrayIndexOutOfBoundsException Caso a posição passada pelo
     * usuário não corresponda a uma posição válida dentro da lista.
     */
    public T buscarPorPosicao(int posicao) throws RuntimeException, ArrayIndexOutOfBoundsException;

    /**
     * Método para buscar a posição de um elemento dentro da lista, passando um
     * elemento genérico válido do mesmo tipo da lista
     *
     * @param elemento Recebe um elemento genérico do mesmo tipo da lista
     *
     * @return Retorna a posição do elemento que foi passado pelo usuário,
     * retorna -1 caso o elemento não seja encontrado
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     * 
     * @throws ArrayIndexOutOfBoundsException
     */
    public int buscar(T elemento) throws RuntimeException;

    /**
     * Método para buscar o primeiro elemento salvo na lista
     *
     * @return Retorna o primeiro elemento que está dentro da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T buscarNoInicio() throws RuntimeException;

    /**
     * Método para buscar o último elemento salva no lista
     *
     * @return Retorna o último elemento que está dentro da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T buscarUltimoElemento() throws RuntimeException;

    /**
     * Método que limpar a lista, ou seja, ele remove todos os elementos de uma
     * vez
     */
    public void limparLista();

    /**
     * Método que verifica se a lista está ou não vazia
     *
     * @return Retorna true se a lista está vazia, retorna false se a lista não
     * está vazia
     */
    public boolean estaVazia();

    /**
     * Método para imprimir a lista completa. Esté método por ser útil, caso o
     * usuário queira ver todos os elementos na lista, até mesmo as posições
     * nulas
     *
     * @return Retorna a lista completa, ou seja, com todos os elementos, mais
     * as posições nulas
     */
    public String imprimirListaCompleta();

    /**
     * Método para ordenar a lista. Esta ordenação é feita pode ser feita com
     * qualque método de ordenação, mas conforme o tamanho da lista aumente,
     * talvez seja melhor uma ordenação como o QuickSort, um algoritmo de
     * ordenação muito eficiente para grandes volumes de dados, onde ele trabaha
     * com a ideia de divisão e conquista de forma recursiva. Nele a lista
     * dividada ao meio, com um elemento central deverá ter na sua esquerda os
     * elementos menores e a sua direita os elementos maiores.
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public void ordenarLista() throws RuntimeException;

    /**
     * Método que verifica se um elemento existe dentro da lista. Esse elemento
     * será passado pelo usuário, e o método irá retornar uma valores booleano,
     * caso o elemento exista ou não
     *
     * @param elemento Recebe o elemento que será buscado, para verificar se ele
     * existe ou não na lista
     *
     * @return Retorna true, caso o elemento seja encontrado na lista, caso
     * contrário, retorna false
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public boolean containsElemento(T elemento) throws RuntimeException;

    /**
     * Método para mudar um elemento existe, para outro elemento. Neste método é
     * verificado o elemento, se ele for tiver uma posição válida e for
     * diferente de nulo, o elemento na posição passada e trocado pelo elemento,
     * que também foi passado pelo usuário.
     *
     * @param posicao Recebe uma posição válida, na qual o usuário deseja trocar
     * o elemento
     * @param elemento Recebe o elemento que será colocado no lugar do antigo
     * elemento, presente a posição passada
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     *
     * @throws ArrayIndexOutOfBoundsException Caso a posição passada pelo
     * usuário não corresponda a uma posição válida dentro da lista.
     *
     * @throws IllegalArgumentException Caso a posição seja válida, porém o
     * elemento da posição seja um valor null, ou seja, sem valor
     */
    public void mudarElemento(int posicao, T elemento) throws RuntimeException, ArrayIndexOutOfBoundsException, IllegalArgumentException;
}
