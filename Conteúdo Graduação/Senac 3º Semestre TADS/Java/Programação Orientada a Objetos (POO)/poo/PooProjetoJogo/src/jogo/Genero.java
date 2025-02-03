package jogo;

public enum Genero {

	FPS("FPS"),
	BATTLE_ROYALE("Battle Royale"),
	FPA("FPA"),
	RTS("RTS"),
	MOBA("MOBA"),
	RPG("RPG"),
	MMORPG("MMORPG");
	
	private String nome;
	private Genero(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
