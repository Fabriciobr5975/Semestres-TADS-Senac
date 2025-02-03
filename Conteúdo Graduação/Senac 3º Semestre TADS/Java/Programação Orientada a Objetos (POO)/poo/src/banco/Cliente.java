package banco;

public class Cliente {
	public String nome;
	public String cpf;

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public static void inicializarClientes(Cliente[] cliente) {
		for(int i = 0; i < cliente.length; i++) {
			String cpf = "";
			while(cpf.length() < 11) {
				cpf += 1;
			}
			cliente[i] = new Cliente();
		}
	}

	@Override
	public String toString() {
		return "[nome=" + nome + "]";
	}
	
	
}
