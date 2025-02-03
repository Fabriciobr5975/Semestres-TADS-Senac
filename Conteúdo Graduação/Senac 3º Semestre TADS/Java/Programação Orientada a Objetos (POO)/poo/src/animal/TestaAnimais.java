package animal;

public class TestaAnimais {
	public static void main(String[] args) {
		// Criando um cachorro
		Cachorro dog1 = new Cachorro();
		dog1.nome = "Rex";
		dog1.raca = "Labrador";
		dog1.imprimirInformacoesCachorro();
		dog1.latir(3);
		dog1.comer();
		System.out.println();

		Cachorro dog2 = new Cachorro();
		dog2.nome = "Lulu";
		dog2.raca = "Poodle";
		dog2.latir(3);
		dog2.comer();
		dog2.imprimirInformacoesCachorro();
		dog2.dormir();
		dog2.imprimirInformacoesCachorro();

		System.out.println();
		System.out.println("Mordida");
		dog1.imprimirInformacoesCachorro();
		dog2.morder(dog1);
		dog1.imprimirInformacoesCachorro();
	}
}
