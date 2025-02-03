/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafo;

/**
 *
 * @author arauj
 */
public class TesteGrafo {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Créber");
        grafo.adicionarVertice("Cráudio");
        
        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Créber");
        grafo.adicionarAresta(3.0, "Créber", "Creuza");
        grafo.adicionarAresta(3.0, "João", "Creuza");
        grafo.adicionarAresta(3.0, "Cráudio", "Lorenzo");
        grafo.adicionarAresta(3.0, "Cráudio", "João");
        
        System.out.println(grafo.buscaEmLargura());
        
    }
}
