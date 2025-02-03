package animal;

public class Cachorro {
	// Atributos
	public String nome;
	public String raca;
	private boolean fome;
	public Tutor tutor;

	// Contrutores
	public Cachorro() {
		this.fome = true;
	}

	public Cachorro(String nome, String raca) {
		this();
		this.nome = nome;
		this.raca = raca;
	}

	public Cachorro(String nome, String raca, Tutor tutor) {
		this(nome, raca);
		this.tutor = tutor;
	}

	// Métodos (comportamentos)
	public void latir(int latidos) {
		System.out.println(this.nome + " latindo: ");

		for (int i = 0; i < latidos; i++) {
			System.out.println("Au Au");
		}
	}

	public void imprimirInformacoesCachorro() {
		System.out.printf("Nome: %s%nRaça: %s%n", this.nome, this.raca);
		System.out.println(this.fome ? "Estou com fome" : "Não estou com fome");
	}

	public void comer() {
		if (this.fome) {
			this.fome = false;
		}
	}

	public void dormir() {
		System.out.println("zzzzzzzzzzz");
		this.fome = true;
	}

	private void chorar() {
		System.out.println("uim uim uim uim uim");
	}

	public void morder(Cachorro dog) {
		dog.chorar();
		dog.fome = true;
	}
}