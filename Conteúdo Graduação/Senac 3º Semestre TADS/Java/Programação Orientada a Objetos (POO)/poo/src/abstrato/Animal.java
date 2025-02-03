package abstrato;

public abstract class Animal {

	private TipoAnimal tipoAnimal;

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	public abstract void falar();
	
	@Override
	public String toString() {
		return this.getTipoAnimal()+"";
	}
}
