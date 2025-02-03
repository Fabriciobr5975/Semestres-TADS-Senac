/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturafila;

/**
 *
 * @author arauj
 */
public class FilaTeste<T> {

    private T fila[];
    private int tamanhoFila;

    public FilaTeste(int capacidade) {
        fila = (T[]) new Object[capacidade];
        this.tamanhoFila = 0;
    }

    public FilaTeste() {
        this(10);
    }

    public int getTamanhoFila() {
        return this.tamanhoFila;
    }

    public boolean estaVazia() {
        return this.tamanhoFila == 0;
    }

    private void aumentarCapacidade() throws Exception {
        if (this.tamanhoFila == this.fila.length - 1) {
            T[] elementosNovos = (T[]) new Object[this.fila.length * 2];

            for (int i = 0; i < this.tamanhoFila; i++) {
                elementosNovos[i] = this.fila[i];
            }
            this.fila = elementosNovos;
        }
    }

    public void enfileirar(T elemento) throws Exception {
        aumentarCapacidade();
        fila[this.tamanhoFila] = elemento;
        tamanhoFila++;
    }

    public Object espiar() throws Exception {
        if (this.estaVazia()) {
            throw new Exception("A Fila está vazia");
        }
        return this.fila[0];
    }

    public T desenfileirar() throws Exception {
        if(this.estaVazia()){
            throw new Exception("A Fila está vazia");
        
        }
        T elemento = fila[0];

        for (int i = 0; i < this.tamanhoFila - 1; i++) {
            this.fila[i] = this.fila[i + 1];
        }
        this.tamanhoFila--;

        return elemento;
    }
    
    private void limparPosicoesFila(){
        for(int i = this.tamanhoFila; i < this.fila.length; i++){
            this.fila[i] = null;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");
        for (int i = 0; i < this.tamanhoFila - 1; i++) {
            s.append(this.fila[i]);
            s.append(", ");
        }

        if (this.tamanhoFila > 0) {
            s.append(this.fila[this.tamanhoFila - 1]);
        }
        s.append("]");
        return s.toString();
    }
}
