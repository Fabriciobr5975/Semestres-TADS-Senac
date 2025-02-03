package bancointerface;

public class Teste {
	public static void main(String[] args) {
		OperacoesBancarias conta = new ContaBancaria();
		conta.depositar(100);
		conta.sacar(50);
		System.out.println(conta.consultarSaldo());
	
		conta.metodoDefault();
	
	}
}
