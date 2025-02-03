package grafo;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author arauj
 * @param <T>
 */
public class Grafo<T> {
    private List<Vertice<T>> vertices; 
    private List<Aresta<T>> arestas;
    private int tamanho;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
        this.tamanho = 0;
    }
    
    public void adicionarVertice(T elemento){
        Vertice<T> novoVertice = new Vertice<T>(elemento);
        this.vertices.add(novoVertice);    
    }
    
    public void adicionarAresta(double peso, T elementoInicio, T elementoFim){
        Vertice<T> inicio = getVertice(elementoInicio);
        Vertice<T> fim = getVertice(elementoFim);
        
        Aresta<T> novaAresta = new Aresta<T>(peso, inicio, fim);
        inicio.adicionarArestaSaida(novaAresta);
        fim.adicionarArestaEntrada(novaAresta);
        this.arestas.add(novaAresta);
        this.tamanho++;
    }
    
    private Vertice<T> getVertice(T elemento) { 
        for(Vertice<T> vertice : this.vertices){
            if(vertice.getElemento().equals(elemento)){
                return vertice;
            }
        }
        return null;   
    }
    
    public String buscaEmLargura(){
        StringBuilder builder = new StringBuilder(); 
        
        List<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        List<Vertice<T>> fila = new ArrayList<Vertice<T>>();
        
        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);
        builder.append(atual.getElemento());
        fila.add(atual);
        
        while(!fila.isEmpty()){
            Vertice<T> visitado = fila.getFirst();
            
            for(int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                
                if(!marcados.contains(proximo)){
                   marcados.add(proximo);
                    builder.append("\n").append(proximo.getElemento());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
        
        return builder.toString();
    }
    
    public String buscaEmProfundidade() {
        return null;
    }
}
