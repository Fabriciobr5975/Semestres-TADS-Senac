package jogo;

import java.util.Calendar;

public class Desenvolvedora {
	private String nome;
	private String paisDeOrigem;
	private String principaisTitulos;
	private String tipoDesenvolvedora;
	private Calendar dataCriacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPrincipaisTitulos() {
		return principaisTitulos;
	}
	public void setPrincipaisTitulos(String principaisTitulos) {
		this.principaisTitulos = principaisTitulos;
	}
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	
}