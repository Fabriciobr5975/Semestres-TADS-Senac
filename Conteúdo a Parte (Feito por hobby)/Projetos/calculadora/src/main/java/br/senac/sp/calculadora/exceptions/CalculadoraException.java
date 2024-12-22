package br.senac.sp.calculadora.exceptions;

@SuppressWarnings("serial")
public class CalculadoraException extends Exception{
	
	public CalculadoraException(String mensagem) {
		super(mensagem);
	}
	
	public static void verificarSeCampoDeVisualizarEstaVazio(String campo) throws CalculadoraException {
		if(campo == null || campo.isEmpty()) {		
			throw new CalculadoraException("O campo não pode ficar vazio, por favor digite uma expressão matemática que deseja calcular");
		}
	}
	
}
