package listaencadeada.simples;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para a manipulação dos objetos da lista encadeada
 *
 * @author Fabrício de Araújo Santana
 * @param <T>
 */
public class ListaEncadeada<T> {

    // Atributos
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    /**
     * Método Construtor
     */
    public ListaEncadeada() {
        this.tamanho = 0;
    }

    /**
     * Método para pegar o tamanho da lista encadeada
     *
     * @return Retorna o tamanho atual da lista
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Método para verificar se a lista está ou não vazia
     *
     * @return Retorna true se a lista estiver vazia, retorna false se a lista
     * não estiver vazia
     */
    public boolean estaVazia() {
        return (this.tamanho == 0);
    }

    /**
     * Método para verificar a posição passada pelo usuário, essa verificação é
     * usada em outros métodos que recebem uma posição, onde ela é tratada com
     * exceções
     *
     * @param posicao Recebe a posição passada pelo usuário
     *
     * @return Retorna true se a posição passada pelo usuário for válida,
     * retorna false caso a posição não seja válida
     */
    private boolean verificarPosicao(int posicao) {
        return !(posicao < 0 || posicao >= this.tamanho);
    }

    /**
     * Método para adicionar novos elementos na lista encadeada
     *
     * @param elemento Recebe um elemento do tipo genérico que será colocado na
     * lista
     */
    public void adicionar(T elemento) {
        No<T> celula = new No<T>(elemento);

        if (estaVazia()) {
            this.adicionarInicio(elemento);

        } else {
            this.fim.setProximo(celula);
            this.fim = celula;
            this.tamanho++;
        }
    }

    /**
     * Método para adicionar novos elementos na lista encadeada, em uma posição
     * específica que seja válida
     *
     * @param elemento Recebe um elemento do tipo genérico que será colocado na
     * lista
     * @param posicao Recebe a posição que se deseja colocar o elemento
     *
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    public void adicionar(T elemento, int posicao) throws IndexOutOfBoundsException {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        if (posicao == 0) {
            this.adicionarInicio(elemento);

        } else if (posicao == this.tamanho) {
            this.adicionar(elemento);

        } else {
            No<T> noAnterior = this.getElementoPosicao(posicao - 1);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<T>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    /**
     * Método para colocar um novo <code>No</code> diretamente na primeira
     * posição, onde este elemento aponta para o elemento que está no inicio,
     * depois o inicio recebe este novo elemento. Caso a lista esteja vazia será
     * adicionando o elemento sem referências de próximo
     *
     * @param elemento Recebe um elemento do tipo genérico que será colocado na
     * lista
     */
    public void adicionarInicio(T elemento) {
        if (estaVazia()) {
            No<T> celula = new No<T>(elemento);
            this.inicio = celula;
            this.fim = celula;

        } else {
            No<T> celula = new No<T>(elemento, this.inicio);
            this.inicio = celula;
        }

        this.tamanho++;
    }

    /**
     * Método que pega um elemento a partir de uma posição válida passada pelo
     * usuário. É passado um valor número referente a posição, caso esse valor
     * seja valido, o programa retorna o <code>No</code>, onde é possível pegar
     * com o método <code>getElemento</code> o elemento desta posição.
     *
     * @param posicao Recebe a posição que se deseja buscar
     * @return Retorna um objeto No, também conhecido como celula, onde está
     * armazenado o elemento e o próximo elemento deste nó/celula
     *
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    private No<T> getElementoPosicao(int posicao) throws RuntimeException, IndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (!verificarPosicao(posicao)) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        if (posicao == 0) {
            return this.inicio;
        }

        if (posicao == (this.tamanho - 1)) {
            return this.fim;
        }

        No<T> atual = this.inicio;

        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            System.out.println(atual);
        }
        return atual;
    }

    /**
     * Método que busca um elemento genérico dentro da lista. O Método recebe um
     * No, que contém o elemento, depois o método só pega o elemento que está
     * dentro deste No
     *
     * @param posicao Recebe a posição que se deseja buscar
     *
     * @return Retorna o elemento que está dentro do No
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T buscar(int posicao) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        return this.getElementoPosicao(posicao).getElemento();
    }

    /**
     * Método que busca a posição de um elemento passando o um elemento que
     * esteja dentro da lista. Caso o elemento não seja encontrado ele retorna
     * -1 que indica que o elemento não existe/não foi encontrado
     *
     * @param elemento Recebe o elemento genérico que está presente dentro da
     * lista
     *
     * @return Retorna a posição referente ao elemento que foi encontrado
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public int buscarPosicaoElemento(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {
            if (atual.getElemento().equals(elemento)) {
                return i;
            }
            atual = atual.getProximo();
        }

        return -1;
    }

    /**
     * Método que busca o primeiro elemento da lista
     *
     * @return Retorna o primeiro elemento da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T buscarPrimeiroElemento() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        return this.inicio.getElemento();
    }

    /**
     * Método que busca o último elemento da lista
     *
     * @return Retorna o último elemento da lista
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T buscarUltimoElemento() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        return this.fim.getElemento();
    }

    /**
     * Método para remover o primeiro elemento da lista
     *
     * @return Retorna o elemento que foi excluído
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T removerInicio() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        T elementoRemovido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.fim = null;
        }

        return elementoRemovido;
    }

    /**
     * Método para remover o último elemento da lista
     *
     * @return Retorna o elemento que foi excluído
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T removerDoFim() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (this.tamanho == 1) {
            return this.removerInicio();
        }

        No<T> penultimoNo = this.getElementoPosicao((this.tamanho - 2));
        T elementoRemovido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.fim = penultimoNo;
        this.tamanho--;

        return elementoRemovido;
    }

    /**
     * Método para remover um elemento em uma posição válida passada pelo
     * usuário.
     *
     * @param posicao Recebe a posição que se deseja remover
     *
     * @return Retorna o elemento que foi excluído
     *
     * @throws RuntimeException Caso a lista esteja vazia
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    public T remover(int posicao) throws RuntimeException, IndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (!verificarPosicao(posicao)) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        if (posicao == 0) {
            return this.removerInicio();

        } else if (posicao == (this.tamanho - 1)) {
            return this.removerDoFim();
        }

        No<T> noAnterior = this.getElementoPosicao(posicao - 1);
        No<T> atual = noAnterior.getProximo();
        No<T> proximo = atual.getProximo();
        noAnterior.setProximo(proximo);
        atual.setProximo(null);
        this.tamanho--;

        return atual.getElemento();

    }

    /**
     * Método para remover um elemento em uma posição válida passada pelo
     * usuário
     *
     * @param elemento Recebe um elemento genérico que será removido da lista
     *
     * @return Retorna o elemento que foi excluído
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T remover(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (this.tamanho == 0) {
            throw new RuntimeException("A lista está vazia");
        }

        int posicaoNo = this.buscarPosicaoElemento(elemento);
        return this.remover(posicaoNo);
    }

    /**
     * Método para imprimir algumas informações sobre um elemento em específico,
     * como sua sua posição na lista e o seu sucessor. Caso ele não tenha um
     * sucessor uma outra mensagem é retornada
     *
     * @param posicao Recebe a posição do elemento que se deseja verificar as
     * informações
     *
     * @return Retorna um String formatada com algumas informações do elemento
     * passado via parâmetro
     *
     * @throws RuntimeException Caso a lista esteja vazia
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    public String imprimirInformacoesElemento(int posicao) throws RuntimeException, IndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (!verificarPosicao(posicao)) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        StringBuilder builder = new StringBuilder();
        No<T> elementoAtual = this.getElementoPosicao(posicao);

        if (posicao == (this.tamanho - 1)) {
            builder.append("O elemento: ").append(elementoAtual.getElemento());
            builder.append(" está na posição: ").append(posicao).append("\n");
            builder.append("Não tem Sucessor, pois é o último da lista");

        } else {
            builder.append("O elemento: ").append(elementoAtual.getElemento());
            builder.append(" está na posição: ").append(posicao).append("\n");
            builder.append("Seu Sucessor: ").append(elementoAtual.getProximo().getElemento());
        }

        return builder.toString();
    }

    /**
     * Método para imprimir algumas informações sobre um elemento em específico,
     * como sua sua posição na lista e o seu sucessor. Caso ele não tenha um
     * sucessor uma outra mensagem é retornada
     *
     * @param elemento Recebe um elemento genérico que se deseja verificar as
     * informações
     *
     * @return Retorna um String formatada com algumas informações do elemento
     * passado via parâmetro
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public String imprimirInformacoesElemento(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        int posicao = this.buscarPosicaoElemento(elemento);

        if (posicao == -1) {
            return "O elemento " + elemento + " não foi encontrado";
        }

        return imprimirInformacoesElemento(posicao);
    }

    /**
     * Método para limpar a lista. Neste método é feito uma iteração que deixa
     * todos os elemento e os proximos(Elo de Ligação) como null, no fim o
     * tamanho volta para 0.
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public void limparLista() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    /**
     * Método que recebe a posição ou o elemento genérico, e partir dele busca o
     * próximo elemento
     *
     * @param posicao Recebe a posição do elemento se deseja buscar o próximo
     * elemento
     *
     * @return Retorna o próximo elemento do elemento que o usuário passou,
     * retorna null caso o próximo elemento seja null, ou seja, se não tiver o
     * próximo
     *
     * @throws RuntimeException Caso a lista esteja vazia
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    public T getProximoElemento(int posicao) throws RuntimeException, IndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (!verificarPosicao(posicao)) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        No<T> proximoNo = this.getElementoPosicao(posicao).getProximo();
        return (proximoNo != null ? proximoNo.getElemento() : null);
    }

    /**
     * Método que recebe a posição ou o elemento genérico, e partir dele busca o
     * próximo elemento
     *
     * @param elemento Recebe um elemento genérico para realizar a busca do
     * próximo elemento
     *
     * @return Retorna o próximo elemento do elemento que o usuário passou,
     * retorna null caso o próximo elemento seja null, ou seja, se não tiver o
     * próximo
     *
     * @throws RuntimeException Caso a lista esteja vazia
     */
    public T getProximoElemento(T elemento) throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        int posicao = this.buscarPosicaoElemento(elemento);

        if (posicao == -1) {
            return (T) String.format("O elemento %s não foi encontrado", elemento);
        }

        return this.getProximoElemento(posicao);
    }

    /**
     * Método que verifica se um elemento tem sucessor. Se o elemento não tenha
     * um próximo o método retorna null, caso o elemento tenha um próximo ele
     * retorna este elemento.
     *
     * @param posicao Recebe a posição do elemento se deseja buscar o próximo
     * elemento
     *
     * @return Retorna true caso o elemento tenha sucessor, caso contrário
     * retorna false
     *
     * @throws RuntimeException Caso a lista esteja vazia
     * @throws IndexOutOfBoundsException Caso a posição que foi passada não seja
     * valida, ou seja ela seja menor que zero ou se ela for igual ou maior que
     * o tamanho da lista
     */
    public boolean elementoTemSucessor(int posicao) throws RuntimeException, IndexOutOfBoundsException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        if (!verificarPosicao(posicao)) {
            throw new IndexOutOfBoundsException("A posição " + posicao + " é inválida");
        }

        return (this.getElementoPosicao(posicao).getProximo() != null);
    }

    /**
     * Método que verifica se um elemento tem sucessor. Se o elemento não tenha
     * um próximo o método retorna null, caso o elemento tenha um próximo ele
     * retorna este elemento.
     *
     * @param elemento Recebe um elemento genérico para realizar a verificação
     * do próximo elemento
     *
     * @return Retorna true caso o elemento tenha sucessor, caso contrário
     * retorna false
     *
     * @throws IllegalArgumentException Caso o elemento não seja encontrado
     */
    public boolean elementoTemSucessor(T elemento) throws IllegalArgumentException {
        int posicao = this.buscarPosicaoElemento(elemento);

        if (posicao == -1) {
            throw new IllegalArgumentException("O elemento " + elemento + " não foi encontrado");
        }

        return this.elementoTemSucessor(posicao);
    }

    /**
     * Método para tranformar a lista encadeada em array.
     *
     * @return Retorna um array com os dados da lista encadeada
     */
    public T[] transformarEmArray() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        T[] lista = (T[]) java.lang.reflect.Array.newInstance(this.inicio.getElemento().getClass(), this.tamanho);
        No<T> elemento = this.inicio;
        int posicao = 0;

        while (elemento != null) {
            No<T> proximo = elemento.getProximo();
            lista[posicao] = elemento.getElemento();
            posicao++;
            elemento = proximo;
        }

        return lista;
    }

    /**
     * Método para tranformar a lista encadeada em um objeto do tipo
     * <code>List</code>.
     *
     * @return Retorna um <code>List</code> com os dados da lista encadeada
     */
    public List<T> transformarEmList() throws RuntimeException {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia");
        }

        List<T> lista = new ArrayList<T>(10);
        No<T> elemento = this.inicio;
        int posicao = 0;

        while (elemento != null) {
            No<T> proximo = elemento.getProximo();
            lista.add(elemento.getElemento());
            posicao++;
            elemento = proximo;
        }

        return lista;
    }

    /**
     * Método para imprimir os objetos da <code>ListaEncadeada</code>
     *
     * @return Retorna o Objetos de <code>ListaEncadeada</code> formatados, para
     * a impressão, seja no console, ou em telas, como JOptionPane, JFrame entre
     * outros
     */
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;

        while (atual != null) {
            builder.append(atual.getElemento());
            atual = atual.getProximo();

            if (atual != null) {
                builder.append(",");
            }
        }

        builder.append("]");

        return builder.toString();
    }
}
