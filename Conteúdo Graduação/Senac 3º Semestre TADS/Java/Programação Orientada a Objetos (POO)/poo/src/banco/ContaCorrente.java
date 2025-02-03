package banco;

public class ContaCorrente {
	// Atributos;
	public double saldo;
	public Cliente titular;
	public double chequeEspecial;
	public String agencia;
	public String numeroConta;
	public String banco;
	public static int qtdContas;

	public ContaCorrente() {
		qtdContas++;
		this.saldo = 0;
	}
	
	public ContaCorrente(double chequeEspecial) {
		this();
		this.chequeEspecial = chequeEspecial;
	}

	public ContaCorrente(boolean chequeEspecial) {
		this();
		if (chequeEspecial) {
			this.chequeEspecial = 1000;
		}
	}

	public ContaCorrente(double saldo, double chequeEspecial, String agencia, String numeroConta, String banco) {
		//this(chequeEspecial);
		this.saldo = saldo;
		this.chequeEspecial = chequeEspecial;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.banco = banco;
	}

	public ContaCorrente(double saldo, double chequeEspecial, String agencia, String numeroConta, String banco, Cliente titular) {
		this(saldo, chequeEspecial, agencia, numeroConta, banco);
		this.titular = titular;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	private boolean verificarSaldo(double valor) {
		return valor <= (this.saldo + this.chequeEspecial);
	}

	public boolean sacar(double valor) {
		if (verificarSaldo(valor)) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean transferir(double valor, ContaCorrente dest) {
		if (verificarSaldo(valor)) {
			this.saldo -= valor;
			dest.saldo += valor;
			return true;
		}
		return false;
	}

	public String exibirSaldo() {
		String saldoFormat;
		saldoFormat = String.format("R$ %7.2f", this.saldo);
		return saldoFormat;
	}
	
	public static void inicializarContas(ContaCorrente[] contas) {
		for(int i = 0; i < contas.length; i++) {
			contas[i] = new ContaCorrente(true);
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [saldo=" + saldo + ", titular=" + titular + ", chequeEspecial=" + chequeEspecial
				+ ", agencia=" + agencia + ", numeroConta=" + numeroConta + ", banco=" + banco + "]";
	}
}