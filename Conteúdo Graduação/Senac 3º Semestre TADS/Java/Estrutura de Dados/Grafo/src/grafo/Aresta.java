package grafo;

/**
 * Método para criar as arestas da estrutura Grafo
 * 
 * @param <TIPO> Recebe um tipo genérico,
 */
public class Aresta<TIPO> {

    // Atributos;
    private double tamanho;
    private String nome;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;

    /**
     * Construtor para contruir novos Objetos do Tipo arestas, para a estrutura
     * Grafo;
     *
     * @param tamanho Recebe o tamanho (Peso) da rua
     * @param inicio Recebe a rua inical (Vértice) do percuso
     * @param fim Recebe a rua (Vértice) de destino
     * @param nome Recebe o nome da rua que está realizando a ligação, no caso
     * sempre será a rua inicial
     */
    public Aresta(double tamanho, Vertice<TIPO> inicio, Vertice<TIPO> fim, String nome) {
        this.fim = fim;
        this.inicio = inicio;
        this.tamanho = tamanho;
        this.nome = nome;
    }

    /**
     * Método para pegar o tamanho (Peso) da rua
     *
     * @return Retorna o tamanho da rua
     */
    public double getTamanho() {
        return tamanho;
    }

    /**
     * Método para mudar o tamanho (Peso) da rua
     *
     * @param tamanho Recebe o novo tamanho da rua
     */
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Método para pegar o nome da rua
     *
     * @return Retorna o nome da rua
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para mudar o nome da rua
     *
     * @param nome Recebe o novo nome para a rua
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para para pegar a rua incial (Vértice)
     *
     * Obs: A rua inicial representa o inicio da uma ligação entre um rua
     * denominada de inicio e outro de fim. O nome inicio só representa a idéia
     * de que nesta ligação essa rua é a inicial, mas essa mesma rua que está no
     * inicio pode ser a rua que está no fim de outra ligação.
     *
     * @return Retorna a rua inicial
     */
    public Vertice<TIPO> getInicio() {
        return inicio;
    }

    /**
     * Método para mudar a rua incial (Vértice)
     *
     * @param inicio Recebe a novo rua incial
     */
    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }

    /**
     * Método para pegar a rua que liga com a rua inicial, ou seja a rua que
     * está ligada com a rua inicial.
     *
     * Obs: A rua final representa o fim de uma ligação entre um rua denominada
     * de inicio e outro de fim. O nome fim só representa a idéia de que nesta
     * ligação essa rua é a final, mas essa mesma rua que está no fim pode ser a
     * rua que está no inicio de outra ligação.
     *
     *
     * @return Retorna a rua final
     */
    public Vertice<TIPO> getFim() {
        return fim;
    }

    /**
     * Método para mudar a rua final, ou seja a rua que está ligada com a rua
     * inicial
     *
     * @param fim Recebe a nova rua final
     */
    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }
}
