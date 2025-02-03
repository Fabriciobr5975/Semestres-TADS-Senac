package exception;

public class NumeroInvalidoException extends Exception {
	private int codigoErro;
	
	public NumeroInvalidoException(String exception, int codigo) {
		super(exception);
		this.codigoErro = codigo;
	}
	
	public int getCodigoErro() {
		return this.codigoErro;
	}
}
