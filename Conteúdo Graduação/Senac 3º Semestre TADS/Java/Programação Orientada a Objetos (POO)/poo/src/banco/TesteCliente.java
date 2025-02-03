package banco;

public class TesteCliente {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("", "");
		c1.nome = "Chile";
		c1.cpf = "123.456.789-10";
		
		ContaCorrente cont1 = new ContaCorrente();
		cont1.numeroConta = "1234-5";
		cont1.agencia = "444";
		cont1.titular = c1;
		
		ContaCorrente cont2 = new ContaCorrente();
		cont2.numeroConta = "1234-5";
		cont2.agencia = "444";
		cont2.titular = c1;
		
		c1.nome = "Carlos";
		//c1 = null;
		System.out.println(c1.nome);
		System.out.println(cont1.titular.nome);
		System.out.println(cont2.titular.nome);
	}
}
