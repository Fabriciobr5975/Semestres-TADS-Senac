package br.senac.sp.calculadora.service;

/**
 * Classe que tem métodos que define regras e a estrutura que os números e
 * símbolos deveram ter.
 * 
 * @author Fabrício de Araújo Santana
 */
public class CalculadoraService {
	// Atributos
	private int contadorParentesesAbertura;
	private int contadorParentesesFechamento;
	private final char[] CARACTERES = { '+', '-', '*', '/', '%', '(', ')' };

	/**
	 * Método Contrutor
	 */
	public CalculadoraService() {
		this.contadorParentesesAbertura = 0;
		this.contadorParentesesAbertura = 0;
	}

	/**
	 * Método para adicionar o valor do botão pressionado pelo usuário
	 * 
	 * @param expressaoNumerica - Recebe a expressão matemática que o usuário está
	 *                          formulando na calculadora
	 * @param valor             - Recebe o valor numérico do botão que foi clicado
	 * 
	 * @return Retorna a expressao numerica passada pelo usuário com o valor do
	 *         botão clicado
	 */
	public String adicionarValorNumericoAoCampo(String expressaoNumerica, char valor) {
		expressaoNumerica = (expressaoNumerica == null ? expressaoNumerica = "" + valor
				: expressaoNumerica.concat("" + valor));

		return expressaoNumerica;
	}

	/**
	 * Método para adicionar o valor do botão pressionado pelo usuário
	 * 
	 * @param expressaoNumerica - Recebe a expressão matemática que o usuário está
	 *                          formulando na calculadora
	 * @param valor             - Recebe o símbolo matemático do botão que foi
	 *                          clicado
	 * 
	 * @return Retorna a expressao numerica passada pelo usuário com o valor do
	 *         botão clicado
	 */
	public String adicionarCaracteresEspeciaisAoCampo(String expressaoNumerica, char valor) {
		if (expressaoNumerica == null) {
			expressaoNumerica = "" + valor;

		} else {
			if (verificarPosicaoCaracteres(expressaoNumerica)) {
				expressaoNumerica += "" + valor;
			}
		}

		return expressaoNumerica;
	}

	/**
	 * Método que verifica a posição do último elemento, visando bloquear que os
	 * símbolos matemáticos, tirando os parenteses, fiquem juntos, pois os símbolos
	 * devem ficar entre os números. Exemplo: 5 + 5, está correto, porém 5 ++ 5,
	 * está errado e a calculadora não podera calcular
	 * 
	 * @param expressaoNumerica - Recebe o símbolo matemático do botão que foi
	 *                          clicado
	 * 
	 * @return Retorna verdadeiro se o último elemento da expressão passada pelo
	 *         usuário não for um símbolo matemático, caso contrário retorna falso;
	 */
	private boolean verificarPosicaoCaracteres(String expressaoNumerica) {
		boolean verificacao = true;
		char caractereEspecial = expressaoNumerica.charAt(expressaoNumerica.length() - 1);

		for (char i : CARACTERES) {
			if (caractereEspecial == i) {
				verificacao = false;
				break;
			}
		}

		return verificacao;
	}

	/**
	 * Método que verifica o último digito antes da calculadora resolver a
	 * expressão, evitando que os símbolos matemáticos não fiquem na última posição
	 * antes do calculo. Se algum símbolo ficasse na última posição o programa não
	 * consegueria calcular a expressão, pois uma exceção seria lançada.
	 * 
	 * @param digito - Recebe o digito referente a última posição
	 * 
	 * @return Retorna verdadeiro se o dígito for um número, caso contrário retorna
	 *         uma <code>IllegalArgumentException</code>
	 * 
	 * @throws IllegalArgumentException Caso o dígito não for um número, então a
	 *                                  expressão tem um elemento na posição
	 *                                  inválida
	 * @throws Exception                Caso alguma outra exceção aconteça
	 */
	public boolean verificarUltimoDigito(char digito) throws IllegalArgumentException, Exception {
		for (int i = 0; i < CARACTERES.length - 1; i++) {
			if (digito == CARACTERES[i]) {
				throw new IllegalArgumentException("Erro: O caracterer " + digito
						+ " não pode estar nessa posição, por favor o remova para continuar a operação");
			}
		}
		return true;
	}

	/**
	 * Método que define a regra de como os parenteses devem ser colocados na
	 * expressão. O usuário pode abrir x parenteses, quando um número é colocado
	 * então os parenteses são fechados. Outra regra se refere aos símbolos, caso já
	 * tenha um número e o usuário coloque um parenteses, será verificado se há
	 * algum símbolo matemático, caso não haja, automaticamente o programa colocara
	 * o símbolo "*".
	 * 
	 * @param expressaoNumerica - Recebe a expressão que o usuário estea manipulando
	 * 
	 * @return Retorna o parenteses de acordo com a ordem, seja de abertura "(" ou
	 *         de fechamento ")"
	 */
	public String adicionarParentesesExpressaoNumerica(String expressaoNumerica) {
		if (expressaoNumerica == null) {
			expressaoNumerica = "(";
			return expressaoNumerica;
		} else {
			char digito = expressaoNumerica.charAt(expressaoNumerica.length() - 1);

			do {
				this.contadorParentesesAbertura = contarParentesesDeAbertura(expressaoNumerica);

				if (digito == '(') {
					expressaoNumerica += "(";

				} else if (Character.isDigit(digito) && contadorParentesesAbertura == 0) {
					expressaoNumerica += "*(";

				} else if ((digito == '+' || digito == '-' || digito == '*' || digito == '/' || digito == '%')
						&& contadorParentesesAbertura == 0) {
					expressaoNumerica += "(";

				} else if ((this.contadorParentesesAbertura > 0)
						&& this.contadorParentesesAbertura == this.contadorParentesesFechamento) {
					if (!(Character.isDigit(digito))) {
						expressaoNumerica += "*(";
					} else {
						expressaoNumerica += "(";
					}

				} else if (Character.isDigit(digito) || digito == ')') {
					if (this.contadorParentesesFechamento < this.contadorParentesesAbertura) {
						expressaoNumerica += ")";
						++this.contadorParentesesFechamento;
					}
				}

				break;
			} while (true);
		}
		return expressaoNumerica;
	}

	/**
	 * Método para contar o total de parenteses de abertura para controlar a ordem
	 * dos parenteses
	 * 
	 * @param expressaoNumerica - Recebe a expressão que o usuário está manipulando
	 * 
	 * @return Retorna a quantidade de parenteses de abertura que foi encontrado
	 */
	private int contarParentesesDeAbertura(String expressaoNumerica) {
		int contadorParenteses = 0;

		for (int i = 0; i < expressaoNumerica.length(); i++) {
			if (expressaoNumerica.charAt(i) == '(') {
				contadorParenteses++;
			}
		}

		return contadorParenteses;
	}
}