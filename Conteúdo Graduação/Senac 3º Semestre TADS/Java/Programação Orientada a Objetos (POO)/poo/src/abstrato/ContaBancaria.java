package abstrato;

public abstract class ContaBancaria {

	private String agencia;
	private String numero;
	private double saldo;
	
	// getters e setters
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// métodos
	
	public abstract void sacar(double valor);
	
	/* Implementação para tornar o sacar publico e verificar o saldo através de um boolean
	public abstract boolean verificarSaldo(double valor);
	
	public void sacar(double valor) {
		if(verificarSaldo(valor)) {
			this.saldo -= valor;
		}
	}
	*/
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void transferir(ContaBancaria conta, double valor) {
		this.sacar(valor);
		conta.depositar(valor);
	}
	
}
