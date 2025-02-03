package listaencadeada.simples;

/**
 * Classe para a criação dos Objetos No que serão usadas nas listas simplesmente
 * encadeada
 *
 * @author Fabrício de Araújo Santana
 * @param <T> Tipo genérico
 */
public class No<T> {

    // Atributos
    private T elemento;
    private No<T> proximo;

    /**
     * Método construtor para a criação dos objetos com apenas o elemento que
     * foi passado pelo usuário
     *
     * @param elemento Recebe o elemento que foi passado pelo usuário
     */
    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    /**
     * Método construtor para a criação dos objetos passando o elemento e o
     * próximo No, pois este construtor é usado quando o objetivo é colocar um
     * No entre posições existentes
     *
     * @param elemento Recebe o elemento que foi passado pelo usuário
     * @param proximo Recebe o proximo No que será usado para ligar a lista
     * encadeada
     */
    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    /**
     * Método para pegar o elemento do No
     *
     * @return Retorna o elemento salvo no No
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * Método para mudar o elemento do No
     *
     * @param elemento Recebe o novo elemento do No
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * Método para pegar o próximo No de um determinado No
     *
     * @return Retorna o próximo No
     */
    public No<T> getProximo() {
        return proximo;
    }

    /**
     * Método para mudar o próximo No de um determinado No
     * 
     * @param proximo Recebe o novo No que será colocado como próximo
     */
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", proximo=" + proximo + '}';
    }

}
