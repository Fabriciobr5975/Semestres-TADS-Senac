/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criandoobjetos;

/**
 *
 * @author arauj
 */
public class Carros {

    private String marca;
    private String nome;
    private String versao;
    private String cor;
    private String portas;
    private String motor;

    public Carros() {
    }

    public Carros(String marca, String nome, String versao, String cor, String portas, String motor) {
        this.marca = marca;
        this.nome = nome;
        this.versao = versao;
        this.cor = cor;
        this.portas = portas;
        this.motor = motor;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" + "Nome: " + nome + "\n" + "Versao: " + versao + "\n" + "Cor: " + cor + "\n" + "Portas: " + portas + "\n" + "Motor: " + motor;
    }
}
