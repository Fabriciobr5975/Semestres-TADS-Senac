package banco;

public class TestaConta {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente();
		ContaCorrente c2 = new ContaCorrente();
		
		c1.banco = "Itaú";
		c1.agencia = "0755";
		c1.numeroConta = "1234-5";
		c1.titular = new Cliente("Teste", "01");
;		c1.titular.nome = "Teste";
		c1.depositar(200);
		System.out.println(c1.exibirSaldo());

		if (c1.sacar(1200)) {
			System.out.println("Saque realizado com sucesso");
		} else {
			System.err.println("NÃO FOI POSSÍVEL REALIZAR O SAQUE");
		}
		System.out.println(c1.exibirSaldo());

		c1.depositar(1000);
		System.out.println(c1.exibirSaldo());
		
		System.out.println(c1.transferir(800, c2) ? "Transferência realizada com sucesso" : "Saldo insuficiente");
		System.out.println(c1.exibirSaldo());
		
		System.out.println(c2.exibirSaldo());
	}
}