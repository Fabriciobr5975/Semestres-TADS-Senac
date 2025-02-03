/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaencadeada.simples;

/**
 *
 * @author arauj
 */
public class TesteListaEncadeada {
    public static void main(String[] args) {
        testeAdicionar();
        //testeBusca();
        
    }
    
    public static void testeAdicionar(){
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        
        listaEncadeada.adicionar(1);
        listaEncadeada.adicionar(3);
        listaEncadeada.adicionar(4);
        listaEncadeada.adicionar(2, 1);
        
        //System.out.println(listaEncadeada);
        
        Integer[] integer = listaEncadeada.transformarEmArray();
        
        for(Integer i : integer) {
            System.out.println(i + " ");
        }
        
    }
    
    public static void testeBusca() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        
        listaEncadeada.adicionar(10);
        listaEncadeada.adicionar(9);
        listaEncadeada.adicionar(8);
        listaEncadeada.adicionar(7);
        listaEncadeada.adicionar(6);
        listaEncadeada.adicionar(0);
        
        System.out.println("Busca por Posição: " + listaEncadeada.buscar(0));
        System.out.println("Busca por Elemento: " + listaEncadeada.buscarPosicaoElemento(4));
        
    }
    
    public static void testeRemover() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        
    }
}
