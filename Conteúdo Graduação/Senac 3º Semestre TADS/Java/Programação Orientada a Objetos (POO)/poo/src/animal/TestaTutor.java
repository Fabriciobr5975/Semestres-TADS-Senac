package animal;

public class TestaTutor {
	public static void main(String[] args) {
		// Criando um objeto "anônimo"
		new Cachorro("Tottó", "Sem raça definida").latir(0);
		
		
		// Criar um tutor
		Tutor tutor = new Tutor();
		tutor.nome = "Chile";
		tutor.telefone = "11 91234-5678";
		tutor.endereco = "Via Transversal Sul";
		
		// Criar cachorros
		Cachorro dog1 = new Cachorro();
		dog1.nome = "Rex";
		dog1.raca = "Labrador";
		dog1.tutor = tutor;
		
		Cachorro dog2 = new Cachorro();
		dog2.nome = "Lulu";
		dog2.raca = "Poodle";
		dog2.tutor = tutor;
		
		dog2.tutor.nome = "Anderson";
		System.out.println(dog1.tutor.nome);
		System.out.println(dog2.tutor.nome);
		System.out.println(tutor.nome);
	
		Cachorro dog3 = new Cachorro("Lili", "Vira Lata", tutor);
	}
}
