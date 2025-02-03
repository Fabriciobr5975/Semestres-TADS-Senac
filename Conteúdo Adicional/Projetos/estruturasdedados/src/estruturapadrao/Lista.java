package estruturapadrao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import listaencadeada.duplamenteencadeada.ListaDuplamenteEncadeada;
import listaencadeada.simples.ListaEncadeada;

/**
 * Classe para a criação de listas simples, com métodos para as manipulações de
 * inserção, busca, remoção e impressão dos dados, além de outros métodos
 * adicionais para facilitar a manipulação dos elementos. Esta classe implementa
 * a interface <code>ListaPadrao</code>, onde a mesma já contém os principais
 * métodos presentes dentro desta classe. O objetivo desta classe é apresentar
 * uma versão mais simples da classe <code>ArrayList</code>. Essa classe exporta
 * para outras classes a lista, com por exemplo, a Interface <code>List</code>,
 * <code>ListaEncadeada</code> e <code>ListaDuplamenteEncadeada</code>, onde o
 * objetivo e torna essa classe flexível. 
 * 
 * @author Fabrício de Araújo Santana
 * @param <T> Recebe um tipo génerico que será usado para criar a lista
 */
public class Lista<T extends Comparable<T>> implements ListaPadrao<T> {

    // Atributo para criar uma lista com um valor padrão, no caso, 10 posições
    private static final int CAPACIDADE_PADRAO = 10;
    // Atributo para criar uma lista vazia
    private static final Comparable[] LISTA_VAZIA = {};

    // Atributos para a lista
    private T[] lista;
    private int tamanho;
    private int tamanhoTotal;
    private int posicaoAux;
    private Class<T> classe;

    /**
     * Método construtor para criar uma lista, passando um tamanho válido. O
     * valor passado, caso seja válido, será usado para criar a lista.
     *
     * @param tamanho Recebe uma tamanho válido
     *
     * @throws NegativeArraySizeException Caso o valor passado pelo usuário para
     * a contrução da lista seja uma valor nulo, que impossibilita a criação da
     * lista
     */
    public Lista(int tamanho) throws NegativeArraySizeException {
        if (tamanho < 0) {
            throw new NegativeArraySizeException("Não é possivel criar uma lista com um tamanho negativo");

        } else if (tamanho == 0) {
            this.lista = (T[]) LISTA_VAZIA;

        } else {
            this.lista = (T[]) new Comparable[tamanho];
        }

        this.tamanho = 0;
        this.tamanhoTotal = this.lista.length;
        this.posicaoAux = 0;

        Type superClasse = getClass().getGenericSuperclass();

        if (superClasse instanceof ParameterizedType parameterizedType) {
            this.classe = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
    }

    /**
     * Método construtor padrão, caso o usuário não queria passar um tamanho ou
     * não queria passar outra lista. Neste construtor a lista é inicializada
     * com 10 posições por padrão.
     */
    public Lista() {
        this(CAPACIDADE_PADRAO);
    }

    /**
     * Método construtor para criar um lista a partir de outra lista, que foi
     * passado via parâmetro.
     *
     * @param lista Recebe uma lista com ou sem elementos, que será passada para
     * a lista da instancia desta classe
     */
    public Lista(Object[] lista) {
        this.lista = (T[]) new Comparable[lista.length];
        this.tamanho = this.lista.length;
        this.tamanhoTotal = this.tamanho;
        this.posicaoAux = this.tamanho;

        Type superClasse = getClass().getGenericSuperclass();

        if (superClasse instanceof ParameterizedType parameterizedType) {
            this.classe = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }

        System.arraycopy(lista, 0, this.lista, 0, lista.length);
    }

    /**
     * Método construtor para criar um lista a partir de outra lista, que foi
     * passado via parâmetro.
     *
     * @param lista Recebe uma lista com ou sem elementos, que será passada para
     * a lista da instancia desta classe
     */
    public Lista(Lista<T> lista) {
        this.lista = (T[]) lista.getLista();
        this.tamanho = lista.getTamanho();
        this.tamanhoTotal = lista.getTamanhoTotal();
        this.posicaoAux = lista.getPosicaoAux();
        this.classe = lista.getClasse();
    }

    /**
     * Método para aumentar a capacidade da lista, quando a mesma estiver com a
     * capacidade máxima. Quando um método de inserção for chamado e a lista
     * estiver cheio a lista terá seu tamanho dobrado para suportar os novos
     * elementos
     */
    private void aumentarCapacidade() {
        this.aumentarCapacidade(false);
    }

    /**
     * Método para aumentar a capacidade da lista, quando for necessário. Por
     * exemplo: Caso seja necessário redimencionar os elementos e alguns destes
     * elementos precisar passar dos limites da lista, ou seja, ser
     * redimensionado para um posição maior do que a suportada, então este
     * método aumenta a capacidade para que a lista não gere uma exceção do tipo
     * <code>ArrayIndexOutOfBoundsException</code>
     *
     * @param aumentar Recebe um valor booleano para dizer se a lista deve ser
     * aumentada, e para diferenciar este método do método acima
     */
    private void aumentarCapacidade(boolean aumentar) {
        if (aumentar || this.tamanho == (this.tamanhoTotal)) {
            T[] novaLista;

            if (this.tamanhoTotal == 0) {
                novaLista = (T[]) new Comparable[1];

            } else {
                int porcentagemAumento = this.tamanhoTotal < 100 ? this.tamanhoTotal
                        + CAPACIDADE_PADRAO : this.tamanhoTotal + (this.tamanhoTotal / 5);
                novaLista = (T[]) new Comparable[porcentagemAumento];
                System.arraycopy(this.lista, 0, novaLista, 0, this.tamanho);

            }
            this.lista = novaLista;
            this.tamanhoTotal = lista.length;
        }
    }

    /**
     * Método para pegar o tamanho atual da lista. Este tamanho é o tamanho de
     * acordo com a quantidade de elementos da lista
     *
     * @return Retorna o tamanho atual da lista
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Método para pegar o tamanho total da lista. Este tamanho é o tamanho
     * total da lista, pegando todas as posição que é possível inserir elementos
     * na lista
     *
     * @return Retorna o tamanho total da lista
     */
    public int getTamanhoTotal() {
        return tamanhoTotal;
    }

    /**
     * Método para pegar a posição auxiliar, que é usada para colocar os
     * elementos da lista
     *
     * @return Retorna o valor da posição auxilar
     */
    private int getPosicaoAux() {
        return this.posicaoAux;
    }

    /**
     * Método para pegar a lista (Array) que foi instanciada na criação do
     * objeto
     *
     * @return Retorna a lista do objeto
     */
    private T[] getLista() {
        return this.lista;
    }

    /**
     * Método que verifica se a posição passada pelo usuário é válida
     *
     * @param posicao Recebe a posição que o usuário passou
     *
     * @return Retorna true se a posição passada for válida, caso contrária
     * retorna false
     */
    private boolean verificarPosicao(int posicao) {
        return (posicao >= 0 && posicao <= this.tamanhoTotal - 1);
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public boolean containsElemento(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        return this.buscar(elemento) != -1;
    }

    /**
     * Método que verifica se uma posição tem um elemento válido, ou seja, um
     * elemento diferente de null
     *
     * @param posicao Recebe uma posição válida para a verificação da posição
     *
     * @return Retorna true, caso a posição não tenha elementos, caso contrário
     * retorna false
     *
     * @throws ArrayIndexOutOfBoundsException Caso a posição passada pelo
     * usuário não corresponda a uma posição válida dentro da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public boolean posicaoTemElemento(int posicao) throws RuntimeException, ArrayIndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        if (!(verificarPosicao(posicao))) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " não é válida");
        }

        return (this.lista[posicao] != null);
    }

    /**
     * Método para transformar o objeto lista do projeto em um array
     * convencional
     *
     * @return Retorna um array da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public T[] toArray() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        T[] array = (T[]) java.lang.reflect.Array.newInstance(this.classe, this.buscarPosicaoUltimoElemento() + 1);
        System.arraycopy(this.lista, 0, array, 0, array.length);

        return array;
    }

    @Override
    public void adicionar(T elemento) {
        aumentarCapacidade();

        if (this.lista[this.posicaoAux] == null) {
            this.lista[posicaoAux] = elemento;

        } else {
            if (this.tamanho == (this.tamanhoTotal - 1)) {
                aumentarCapacidade(true);
            }

            this.lista[this.posicaoAux + 1] = elemento;
        }

        this.tamanho++;
        this.posicaoAux++;
    }

    @Override
    public void adicionarInicio(T elemento) {
        aumentarCapacidade();

        if (estaVazia()) {
            this.adicionar(elemento);

        } else {
            for (int i = this.tamanho - 1; i >= 0; i--) {
                if (this.tamanho == (this.tamanhoTotal - 1)) {
                    aumentarCapacidade(true);
                }

                if (this.lista[i + 1] != null) {
                    this.lista[i + 2] = this.lista[i + 1];
                }

                this.lista[i + 1] = this.lista[i];
            }
            this.lista[0] = elemento;
        }

        this.tamanho++;
        this.posicaoAux++;
    }

    @Override
    public void adicionar(T elemento, int posicao) throws ArrayIndexOutOfBoundsException {
        if (!(verificarPosicao(posicao))) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " não é válida");
        }
        aumentarCapacidade();

        if (posicao == 0) {
            this.adicionarInicio(elemento);

        } else {
            if (this.tamanho > 0) {
                for (int i = this.buscarPosicaoUltimoElemento(); i >= posicao; i--) {
                    if (this.lista[posicao] == null) {
                        break;

                    } else if (posicao == (this.tamanhoTotal - 1)) {
                        aumentarCapacidade(true);
                        this.lista[posicao + 1] = this.lista[posicao];
                        this.lista[posicao] = elemento;
                        break;

                    } else {
                        this.lista[i + 1] = this.lista[i];
                    }
                }
            }
            this.lista[posicao] = elemento;
        }

        this.tamanho++;
    }

    @Override
    public T removerDoInicio() throws NullPointerException, RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        T primeiroElemento = this.lista[0];

        if (primeiroElemento == null) {
            throw new NullPointerException("Esta posição não tem elemento");

        } else {
            this.lista[0] = null;
            this.tamanho--;

            for (int i = 0; i < this.tamanhoTotal - 1; i++) {
                this.lista[i] = lista[i + 1];
            }
        }

        return primeiroElemento;
    }

    /**
     * Método para pegar a classe que foi instancia pelo Generics, onde ele é
     * usada para criar um array no método <code>toArray</code>, onde é criado
     * uma array do mesmo tipo genérico da classe.
     *
     * @return Retorna a classe que foi instanciada pelo generics
     */
    private Class<T> getClasse() {
        return classe;
    }

    @Override
    public T removerDoFim() throws NullPointerException, RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        T ultimoElemento = null;

        for (int i = this.tamanhoTotal - 1; i >= 0; i--) {
            if (lista[i] == null) {
                continue;
            }
            ultimoElemento = lista[i];

            if (ultimoElemento == null) {
                throw new NullPointerException("Esta posição não tem elemento");

            } else {
                lista[i] = null;
                this.tamanho--;
                break;
            }
        }
        return ultimoElemento;
    }

    @Override
    public T remover(int posicao) throws ArrayIndexOutOfBoundsException, NullPointerException, RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        if (!(verificarPosicao(posicao))) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " não é válida");
        }

        if (posicao == 0) {
            return this.removerDoInicio();
        }

        T elementoBusca = this.lista[posicao];

        if (elementoBusca == null) {
            throw new NullPointerException("Esta posição não tem elemento");

        } else {
            for (int i = posicao; i < this.tamanhoTotal - 1; i++) {
                this.lista[i] = lista[i + 1];
            }
            this.tamanho--;
        }

        return elementoBusca;
    }

    @Override
    public T remover(T elemento) throws RuntimeException, NullPointerException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        int posicao = this.buscar(elemento);
        T elementoBusca = null;

        if (posicao != -1) {
            elementoBusca = this.lista[posicao];
            this.remover(elementoBusca);

        } else {
            throw new NullPointerException("O elemento não foi encontrado");
        }

        return elementoBusca;
    }

    /**
     * Método para a ordenação do tipo QuickSort, um algoritmo de ordenação
     * muito eficiente para grandes volumes de dados, onde ele trabaha com a
     * ideia de divisão e conquista de forma recursiva. Nele a lista é dividida
     * ao meio, com um elemento central que deverá ter na sua esquerda os
     * elementos menores e a sua direita os elementos maiores.
     *
     * @param esquerda Recebe a posição a esquerda
     * @param direita Recebe a posição a direita
     */
    private void quickSort(int esquerda, int direita) {
        if (esquerda < direita) {
            int particao = this.particaoQuickSort(esquerda, direita, 0);
            quickSort(esquerda, particao);
            quickSort(particao + 1, direita);
        }
    }

    /**
     * Método para a ordenação do tipo QuickSort, um algoritmo de ordenação
     * muito eficiente para grandes volumes de dados, onde ele trabaha com a
     * ideia de divisão e conquista de forma recursiva. Nele a lista é dividida
     * ao meio, com um elemento central que deverá ter na sua esquerda os
     * elementos menores e a sua direita os elementos maiores.
     *
     * @param esquerda Recebe a posição a esquerda
     * @param direita Recebe a posição a direita
     * @param tipoOrdenacao Recebe o tipo da ordenação, se é a ordenação padrão
     * (do menor para o maior), ou se é a ordenação inversa (do maior para o
     * menor)
     */
    private void quickSort(int esquerda, int direita, int tipoOrdenacao) {
        if (esquerda < direita) {
            int particao = this.particaoQuickSort(esquerda, direita, tipoOrdenacao);
            quickSort(esquerda, particao, tipoOrdenacao);
            quickSort(particao + 1, direita, tipoOrdenacao);
        }
    }

    @Override
    public void ordenarLista() throws RuntimeException {
        int posicaoValida = this.tamanhoTotal - 1;

        this.colocarValoresNullNoFim();
        this.quickSort(0, posicaoValida);
    }

    /**
     * Método para dividir a lista ao meio para a ordenação QuickSortF
     *
     * @param esquerda Recebe a posição da esquerda
     * @param direita Recebe a posição da direita
     * @param tipoOrdenacao Recebe o tipo da ordenação, se é a ordenação padrão
     * (do menor para o maior), ou se é a ordenação inversa (do maior para o
     * menor)
     *
     * @return Retorna a posição do elemento que é menor ou maior do que o
     * elemento centra da lista
     */
    private int particaoQuickSort(int esquerda, int direita, int tipoOrdenacao) {
        int meio = (esquerda + direita) / 2;
        T pivo = this.lista[meio];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            if (tipoOrdenacao == 0) {
                do {
                    i++;

                } while (this.lista[i].compareTo(pivo) < 0);

                do {
                    j--;

                } while (this.lista[j].compareTo(pivo) > 0);

                if (i >= j) {
                    return j;
                }

            } else {
                do {
                    i++;

                } while (this.lista[i].compareTo(pivo) > 0);

                do {
                    j--;

                } while (this.lista[j].compareTo(pivo) < 0);

                if (i >= j) {
                    return j;
                }
            }

            T aux = this.lista[i];
            this.lista[i] = this.lista[j];
            this.lista[j] = aux;
        }
    }

    /**
     * Método para ordenar a lista, seja a ordenação do menor elemento para o
     * maior (padrão), ou do maior para o menor (lógica inversa). O método pode
     * recebe pelo parâmetro 2 valores, que representam o tipo de ordenação. 0
     * para a ordenação do menor para o maior (padrão), e 1 para a ordenação do
     * maior para o menor. Neste método é usado o algoritmo QuickSort, um
     * algoritmo de ordenação muito eficiente para grandes volumes de dados,
     * onde ele trabaha com a ideia de divisão e conquista de forma recursiva.
     * Nele a lista é dividida ao meio, com um elemento central que deverá ter
     * na sua esquerda os elementos menores e a sua direita os elementos
     * maiores.
     *
     * @param direcaoOrdenacao Recebe o tipo de ordenação 0 para o padrão (do
     * menor para o maior) e 1 para a ordenação do maior para o menor
     */
    public void ordenarLista(int direcaoOrdenacao) throws IllegalArgumentException {
        if (direcaoOrdenacao < 0 || direcaoOrdenacao > 1) {
            throw new IllegalArgumentException("O valor " + direcaoOrdenacao + " não é valido, digite "
                    + "0 para ordenar na ordem natural, ou 1 para ordenar do maior para o menor");
        }

        int posicaoValida = this.tamanhoTotal - 1;
        this.colocarValoresNullNoFim();
        this.quickSort(0, posicaoValida, direcaoOrdenacao);
    }

    @Override
    public T buscarNoInicio() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        return this.lista[0];
    }

    @Override
    public T buscarUltimoElemento() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        int posicaoUltimoElemento = -1;

        for (int i = this.tamanhoTotal - 1; i >= 0; i--) {
            if (this.lista[i] != null) {
                posicaoUltimoElemento = i;
                break;
            }
        }
        return this.lista[posicaoUltimoElemento];
    }

    /**
     * Método que pega a posição do último elemento inserido na lista
     *
     * @return Retorna a posição do último elemento
     *
     * @throws RuntimeException Caso a lista esteja vazia, ou seja, o vetor
     * tenha as posição, mas não tenha elementos
     */
    public int buscarPosicaoUltimoElemento() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        int posicaoUltimoElemento = -1;

        for (int i = this.tamanhoTotal - 1; i >= 0; i--) {
            if (this.lista[i] != null) {
                return i;
            }
        }

        return posicaoUltimoElemento;
    }

    @Override
    public T buscarPorPosicao(int posicao) throws RuntimeException, IllegalArgumentException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        if (!(verificarPosicao(posicao))) {
            throw new IllegalArgumentException("A posição " + posicao + " não é válida");
        }

        return this.lista[posicao];
    }

    @Override
    public int buscar(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        T[] listaOrdenada = Arrays.copyOf(lista, tamanho);
        this.ordenarLista();

        return this.buscaBinaria(listaOrdenada, elemento);
    }

    @Override
    public int buscaBinaria(T[] lista, T elemento, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        while (true) {
            if (inicio > fim) {
                return -1;
            }

            if (lista[meio].equals(elemento)) {
                for (int i = 0; i < this.tamanhoTotal; i++) {
                    if (this.lista[i].equals(lista[meio])) {
                        return i;
                    }
                }

            } else if (lista[meio].compareTo(elemento) < 0) {
                inicio = meio + 1;

            } else {
                fim = meio - 1;
            }

            meio = (inicio + fim) / 2;
        }
    }

    @Override
    public void mudarElemento(int posicao, T elemento) throws RuntimeException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);

        } else if (!(verificarPosicao(posicao))) {
            throw new ArrayIndexOutOfBoundsException("A posição " + posicao + " não é válida");

        } else if (this.lista[posicao] == null) {
            throw new IllegalArgumentException("A posição " + posicao + " não pode ser modificada, pois está vazia");
        }

        this.lista[posicao] = elemento;
    }

    @Override
    public void limparLista() {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        this.lista = (T[]) LISTA_VAZIA;
        this.tamanho = 0;
        this.tamanhoTotal = this.lista.length;
        this.posicaoAux = 0;
    }

    /**
     * Método para colocar valores nulos no final da lista, deixando os valores
     * válidos na frente. Este método altera a estrutura da lista, movendo
     * elementos válidos para a frente e elementos nulos para o fim da lista.
     * Então, utilize esté método sabendo que a lista terá a sua estrutura
     * alterada.
     */
    public void colocarValoresNullNoFim() {
        int posicaoValida = this.tamanhoTotal - 1;

        for (int i = 0; i <= posicaoValida; i++) {
            if (this.lista[i] == null) {
                while (this.lista[posicaoValida] == null && posicaoValida > i) {
                    posicaoValida--;
                }

                T elemento = this.lista[i];
                this.lista[i] = this.lista[posicaoValida];
                this.lista[posicaoValida] = elemento;
                posicaoValida--;
            }
        }
    }

    /**
     * Método para colocar valores nulos no final da lista. Este método é
     * utilizado no método equals, sobrescrito nesta classe. Ele altera a
     * estrutura da lista, movendo elementos válidos para a frente e elementos
     * nulos para o fim da lista.
     *
     * @param lista Recebe a lista que terá a estrutura modificada.
     */
    private void colocarValoresNullNoFim(T[] lista) {
        int posicaoValida = this.tamanhoTotal - 1;

        for (int i = 0; i <= posicaoValida; i++) {
            if (lista[i] == null) {
                while (lista[posicaoValida] == null && posicaoValida > i) {
                    posicaoValida--;
                }

                T elemento = lista[i];
                lista[i] = lista[posicaoValida];
                lista[posicaoValida] = elemento;
                posicaoValida--;
            }
        }
    }

    /**
     * Método para juntas duas listas que sejam do mesmo tipo. Este método
     * recebe uma outra lista (Array) para realizar a junção
     *
     * @param lista Recebe a lista que será juntada a lista da classe
     *
     * @throws IllegalArgumentException Caso o tamanho da lista passada por
     * parâmetro tenha tamanho igual a zero, ou seja, esteja vazia
     */
    public void juntarListas(Object[] lista) throws IllegalArgumentException {
        if (lista.length == 0) {
            throw new IllegalArgumentException("A lista passada não tem elementos");
        }

        if ((this.tamanho + lista.length) >= this.tamanhoTotal) {
            aumentarCapacidade(true);
        }

        System.arraycopy(lista, 0, this.lista, this.tamanho, lista.length);
        this.tamanho += lista.length;
        this.posicaoAux += lista.length;
    }

    /**
     * Método para juntas duas listas que sejam do mesmo tipo. Este método
     * recebe outro objeto do tipo Lista, e a partir dela, pega a sua lista e
     * junta com a lista do objeto atual
     *
     * @param lista Recebe o Objeto do tipo Lista
     *
     * @throws IllegalArgumentException Caso a lista (Array) que foi
     * instanciando no objeto que veio no parâmetro esteja vazio
     */
    public void juntarListas(Lista<T> lista) throws IllegalArgumentException {
        if (lista.estaVazia()) {
            throw new IllegalArgumentException("A lista passada não tem elementos");
        }

        if ((this.tamanho + lista.getTamanho()) >= this.tamanhoTotal) {
            aumentarCapacidade(true);
        }

        System.arraycopy(lista.getLista(), 0, this.lista, this.tamanho, lista.getTamanhoTotal());
        this.tamanho += lista.getTamanho();
        this.posicaoAux += lista.getTamanho();
    }

    /**
     * Método para inverter os elementos da lista
     */
    public void inverterLista() {
        T[] listaAux = (T[]) new Comparable[this.tamanhoTotal];
        int posicao = 0;

        for (int i = this.tamanhoTotal - 1; i >= 0; i--) {
            if (this.lista[i] != null) {
                listaAux[posicao] = this.lista[i];
                posicao++;
            }
        }

        this.lista = listaAux;
    }

    /**
     * Método para transforma a lista do sistema, em uma lista duplamente
     * encadeada.
     *
     * @return
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public ListaEncadeada<T> tranformarEmListaEncadeada() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        ListaEncadeada<T> listaEncadeada = new ListaEncadeada<T>();

        for (T elementos : this.lista) {
            if (elementos != null) {
                listaEncadeada.adicionar(elementos);
            }
        }

        return listaEncadeada;
    }

    /**
     * Método para transforma a lista do sistema, em uma lista duplamente
     * encadeada.
     *
     * @return Retorna uma lista duplamente encadeada;
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public ListaDuplamenteEncadeada tranformarEmListaDuplamenteEncadeada() throws IllegalStateException {
        if (estaVazia()) {
            throw new IllegalStateException(MENSAGEM_LISTA_VAZIA);
        }

        ListaDuplamenteEncadeada<T> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<T>();

        for (T elementos : this.lista) {
            if (elementos != null) {
                listaDuplamenteEncadeada.adicionar(elementos);
            }
        }

        return listaDuplamenteEncadeada;
    }

    /**
     * Método para transformar a lista desta classe (um array) em um objeto do
     * tipo lista (<code>List</code>). Neste método o Objeto <code>List</code> é
     * instanciado pelo <code>ArrayList</code>, uma classe que implementa a
     * classe List
     *
     * @return Retorna um objeto do tipo <code>List</code> com os dados
     * presentes na list a desta classe
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public List<T> transformarEmList() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException(MENSAGEM_LISTA_VAZIA);
        }

        return new ArrayList<T>(Arrays.asList(this.lista).subList(0, this.buscarPosicaoUltimoElemento() + 1));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        if (this.tamanho == 0) {
            return "[]";
        }

        int contador = this.buscarPosicaoUltimoElemento();

        for (int i = 0; i < contador; i++) {
            if (this.lista[i] == null) {
                continue;
            }
            builder.append(this.lista[i]).append(", ");
        }

        builder.append(this.lista[contador]).append("]");

        return builder.toString();
    }

    @Override
    public String imprimirListaCompleta() {
        if (this.estaVazia()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < this.tamanhoTotal - 1; i++) {
            builder.append(this.lista[i]).append(", ");
        }

        builder.append(this.lista[this.tamanhoTotal - 1]).append("]");

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;

        for (Object object : this.lista) {
            if (object != null) {
                hash = 31 * hash + Arrays.deepHashCode(this.lista);
            }
        }
        hash = 31 * hash + this.tamanho;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Lista<?> other = (Lista<?>) obj;
        if (this.tamanho != other.tamanho) {
            return false;
        }

        if (this.estaVazia() && other.estaVazia()) {
            return true;

        } else if (this.estaVazia() || other.estaVazia()) {
            return this.estaVazia() && other.estaVazia();
        }

        T[] listaAux = Arrays.copyOf(this.lista, this.tamanhoTotal);
        T[] lista2 = Arrays.copyOf((T[]) other.lista, other.tamanhoTotal);

        colocarValoresNullNoFim(listaAux);
        colocarValoresNullNoFim(lista2);

        for (int i = 0; i < this.lista.length; i++) {
            if (listaAux[i] != null ? !listaAux[i].equals(lista2[i]) : lista2[i] != null) {
                return false;
            }
        }
        return Arrays.deepEquals(listaAux, lista2);
    }
}
