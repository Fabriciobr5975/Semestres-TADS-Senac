package bancointerface;

public interface OperacoesBancarias {
	int valor = 10;
	
	void sacar(double valor);
	void depositar(double valor);
	double consultarSaldo();
	
	public void transferir(double valor, OperacoesBancarias destino);
	
	default void metodoDefault() {
		System.out.println("Método Default");
	}
}
