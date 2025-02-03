package banco;

public class TesteConstrutores {
	public static void main(String[] args) {
		ContaCorrente conta = new ContaCorrente(0, 1000, "1234", "8888-8", "Itaú",
				new Cliente("Carlos", "222.222.222-99"));
		
		ContaCorrente conta2 = new ContaCorrente();
		ContaCorrente conta3 = new ContaCorrente();
		ContaCorrente conta4 = new ContaCorrente();
		
		System.out.println(ContaCorrente.qtdContas);
		System.out.println(conta2.qtdContas);
		System.out.println(conta3.qtdContas);
	}
}