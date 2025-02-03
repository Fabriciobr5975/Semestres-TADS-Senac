package abstrato;

public class Testa {

	public static void main(String[] args) {
		
		ContaBancaria c1 = new ContaCorrente();
		ContaBancaria c2 = new ContaPoupanca();
		
		((ContaCorrente)c1).setLimite(1000);
		c1.depositar(1000);
		c2.depositar(1000);
		c1.transferir(c2, 500);

	}

}
