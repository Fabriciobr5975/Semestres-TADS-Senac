package listaencadeada.duplamenteencadeada;

/**
 * Classe para a criação dos Objetos No que serão usadas nas listas duplamente
 * encadeada
 *
 * @author Fabrício de Araújo Santana
 * @param <T> Tipo genérico
 */
public class No<T> {

    // Atributos
    private T elemento;
    private No<T> anterior;
    private No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }

    public No(No<T> anterior, T elemento) {
        this(elemento);
        this.anterior = anterior;
        this.proximo = null;
    }

    public No(T elemento, No<T> proximo) {
        this(elemento);
        this.anterior = null;
        this.proximo = proximo;
    }

    public No(No<T> anterior, T elemento, No<T> proximo) {
        this(elemento);
        this.anterior = anterior;
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
     * Método para pegar No anterior de um determinado No
     *
     * @return Retorna o No anterior
     */
    public No<T> getAnterior() {
        return anterior;
    }

    /**
     * Método para mudar o No anterior de um determinado No
     *
     * @param anterior Recebe o novo No que será colocado como anterior
     */
    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
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
        return "No{" + "elemento=" + elemento + '}';
    }
}
