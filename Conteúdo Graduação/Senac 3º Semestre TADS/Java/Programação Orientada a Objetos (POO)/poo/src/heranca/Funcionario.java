package heranca;

import java.util.Objects;

public class Funcionario {
	private String matricula;
	private String nome;
	private double salario;
	private String rg;
	
	public Funcionario() {
		System.out.println("Passou pelo Funcionario");
		// Pega a classe que foi instanciada através de Funcionario
		System.out.println(this.getClass().getSimpleName());
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
}