package exception;

public class Matematica {
	// Este método não poderá receber um número inferior a 100
	public static int gerarNumero(int numero) throws NumeroInvalidoException {
		int retorno;

		if(numero < 100) {
			throw new NumeroInvalidoException("Número Inválido", 5);
		}
		
		retorno = (int) (numero * 3 + Math.pow(numero, 2) + Math.sqrt(numero));
		return retorno;
	}
}
