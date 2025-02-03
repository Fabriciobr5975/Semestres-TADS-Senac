/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaencadeada.duplamenteencadeada;

/**
 *
 * @author arauj
 */
public class TesteListaDuplamenteEncadeada {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<String>();
        
        lista.adicionar("A");
        lista.adicionar("C");
        lista.adicionar("B", 1);
        lista.adicionar("D", 3);
        
        System.out.println(lista);
    }
}
