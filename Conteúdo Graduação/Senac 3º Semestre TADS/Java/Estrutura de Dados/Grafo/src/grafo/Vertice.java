package grafo;

import java.util.ArrayList;

/**
 * Método para criar as vertices da estrutura Grafo
 *
 * @param <TIPO> Recebe um tipo genérico,
 */
public class Vertice<TIPO> {

    // Atributos;
    private TIPO dado;
    private String rua;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;

    /**
     * Construtor para contruir novos Objetos do Tipo Vertice, para a estrutura
     * Grafo;
     *
     * @param dado Recebe o dado genérico
     */
    public Vertice(TIPO dado) {
        this.dado = dado;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    /**
     * Método para pegar o dado
     * 
     * @return Retorna o dado salvo
     */
    public TIPO getDado() {
        return dado;
    }

    /**
     * Método para mudar o dado salvo
     *
     * @param dado Recebe o novo dado
     */
    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    /**
     * Método para pegar a rua
     * 
     * @return Retorna a rua salva
     */
    public String getRua() {
        return rua;
    }

    /**
     * Método para mudar a rua salva
     * 
     * @param rua Recebe a nova rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Método para pegar as aresta de entrada
     * 
     * @return Retorna as aresta de entrada
     */
    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    /**
     * Método para mudar as arestas de entrada salvas
     *
     * @param arestasEntrada Recebe as novas arestas de entrada
     */
    public void setArestasEntrada(ArrayList<Aresta<TIPO>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    /**
     * Método para pegar as aresta de saida
     * 
     * @return Retorna as aresta de saida
     */
    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    /**
     * Método para mudar as arestas de saidas salvas
     * 
     * @param arestasSaida Recebe as novas arestas de saidas
     */
    public void setArestasSaida(ArrayList<Aresta<TIPO>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }

    /**
     * Método para acionar as arestas de entrada
     * 
     * @param aresta Recebe um aresta
     */
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    /**
     * Método para acionar as arestas de saída
     *
     * @param aresta Recebe um aresta
     */
    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }
  
}
