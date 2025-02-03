package bancointerface;

public class ContaBancaria implements OperacoesBancarias, ValidacaoDeSaldo {
	public double saldo;
	String num = "";
	
	@Override
	public boolean validar(double valor) {
		return valor >= saldo;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		
	}

	@Override
	public void transferir(double valor, OperacoesBancarias destino) {
		this.sacar(valor);
		destino.depositar(valor);
		
	}
	
	@Override
	public double consultarSaldo() {
		return this.saldo;
	}
}
