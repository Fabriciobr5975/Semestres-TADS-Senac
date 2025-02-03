package abstrato;

public class Cachorro extends Animal {

	public Cachorro() {
		this.setTipoAnimal(TipoAnimal.MAMIFEROS);
	}
	
	@Override
	public void falar() {
		System.out.println("Au Au");
	}

	
}
