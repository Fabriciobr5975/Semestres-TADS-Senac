package abstrato;

public enum TipoAnimal {

	PEIXES("Peixes", 1), REPTEIS("Repteis", 2), ANFIBIO("Anfíbios", 3), AVES("Aves", 4), MAMIFEROS("Mamíferos", 5);

	private TipoAnimal(String descricao, int ordem) {
		this.descricao = descricao;
		this.ordem = ordem;
	}

	String descricao;
	int ordem;

	@Override
	public String toString() {
		return descricao;
	}

}