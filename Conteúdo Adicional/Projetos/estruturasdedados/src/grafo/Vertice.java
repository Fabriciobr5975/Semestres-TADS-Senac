package grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arauj
 */
public class Vertice<T> {
    private T elemento;
    private List<Aresta<T>> arestasEntrada;
    private List<Aresta<T>> arestasSaida;
    private int totalVertices;
    
    public Vertice(T elemento){
        this.elemento = elemento;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
        this.totalVertices = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    public void adicionarArestaEntrada(Aresta<T> aresta) {
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<T> aresta) {
        this.arestasSaida.add(aresta);
    }
    
    public int getTotalVerticel(){
        return this.totalVertices;
    }

    public List<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public List<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}
