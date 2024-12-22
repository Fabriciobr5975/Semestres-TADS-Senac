package atividades.util;

/**
 * Classe com métodos para a manipulação de documentos, como RG, CPF, CNPJ e IE
 * 
 * @author Fabrício de Araújo Santana
 */
public class ValidacaoDocumento {

	/**
	 * Método para limpar os caracteres especiais do documento, com isso podemos
	 * usar calcular os dígitos validadores dos documentos sem nenhum problema
	 * 
	 * @param documento - Recebe algum documento em formato de String. O documento
	 *                  pode ser o CNPJ, CPF, RG do Estado de São Paulo ou a
	 *                  Inscrição Estadual (IE)
	 * @return Retorna o documento limpo sem caracteres especiais
	 */
	public static String limparDocumento(String documento) {
		// Variável para armazenar o documento limpo, sem caracteres especiais;
		String documentoLimpo = "";

		// Limpando o documento;
		for (int i = 0; i < documento.length(); i++) {
			if (documento.charAt(i) == '.' || documento.charAt(i) == '/' || documento.charAt(i) == '-') {
				continue;
			}
			documentoLimpo += documento.charAt(i);
		}
		return documentoLimpo;
	}

	/**
	 * Método para validar o RG de São Paulo. Através da multiplicação e soma dos
	 * dígitos presentes no RG com alguns valores definidos, conseguimos obter um
	 * dígito validador, onde se ele for igual ao dígito validador do RG passado
	 * pelo usuário a validação é verdadeira, caso contrário ela é falsa
	 * 
	 * @param rg - Recebe o RG passado pelo usuário
	 * @return Retorna verdadeiro caso o RG passe na validação ou falso caso o RG
	 *         não passe na validação
	 * @exception Exception Caso o RG passado esteja com letras no meio do dos
	 *                      números
	 */
	public static boolean validarRgSaoPaulo(String rg) throws Exception {
		// Variáveis para a manipulação do RG;
		String rgLimpo = limparDocumento(rg);
		rg = rgLimpo.substring(0, 8);
		final String NUMERO_VERIFICADOR = "23456789";
		int soma = 0, resto = 0;

		if (rgLimpo.equals("000000000")) {
			return false;
		}

		/*
		 * Fazendo a multiplicação dos dígitos do RG com os valores da constante e
		 * somando o resultado de cada iteração
		 */
		for (int i = 0; i < NUMERO_VERIFICADOR.length(); i++) {
			soma += Integer.parseInt(rgLimpo.charAt(i) + "") * Integer.parseInt(NUMERO_VERIFICADOR.charAt(i) + "");
		}

		// Pegando o resto da divisão para pegar o dígito;
		resto = soma % 11;

		// Pegando o dígito validador;
		if (resto == 0) {
			rg += "0";

		} else if (resto == 1) {
			rg += "X";

		} else {
			rg += (11 - resto);
		}

		// Verificando se os valores são iguais;
		if (rg.equals(rgLimpo)) {
			return true;
		}
		return false;

	}

	/**
	 * Método para validar o CNPJ. Através da multiplicação e soma dos dígitos
	 * presentes no CNPJ com alguns valores definidos, conseguimos obter dois
	 * dígitos validadores, onde se eles forem iguais aos dígitos validadores do
	 * CNPJ passado pelo usuário a validação é verdadeira, caso contrário ela é
	 * falsa
	 * 
	 * @param cnpj - Recebe o CNPJ passado pelo usuário
	 * @return Retorna verdadeiro caso o CNPJ passe na validação ou falso caso o
	 *         CNPJ não passe na validação
	 * @exception Exception Caso o CNPJ passado esteja com letras no meio do dos
	 *                      números
	 */
	public static boolean validarCnpj(String cnpj) throws Exception {
		// Variáveis para a manipulação do CNPJ;
		String cnpjLimpo = limparDocumento(cnpj);
		cnpj = cnpjLimpo.substring(0, 12);
		final String NUMERO_VERIFICADOR_1 = "543298765432";
		final String NUMERO_VERIFICADOR_2 = "6543298765432";
		int soma = 0, digito1 = 0, digito2 = 0;

		if (cnpjLimpo.equals("00000000000000")) {
			return false;
		}

		/*
		 * Fazendo a multiplicação dos dígitos do CNPJ com os valores da constante e
		 * somando o resultado de cada iteração para pegar o primeiro dígito validador
		 */
		for (int i = 0; i < NUMERO_VERIFICADOR_1.length(); i++) {

			soma += Integer.parseInt(cnpjLimpo.charAt(i) + "") * Integer.parseInt(NUMERO_VERIFICADOR_1.charAt(i) + "");
		}

		// Pegando o primeiro dígito validador;
		digito1 = ((soma % 11) < 2) ? 0 : 11 - (soma % 11);
		soma = 0;
		cnpj += digito1;

		/*
		 * Fazendo a multiplicação dos dígitos do CNPJ com os valores da constante e
		 * somando o resultado de cada iteração para pegar o segundo dígito validador
		 */
		for (int i = 0; i < NUMERO_VERIFICADOR_2.length(); i++) {
			soma += Integer.parseInt(cnpjLimpo.charAt(i) + "") * Integer.parseInt(NUMERO_VERIFICADOR_2.charAt(i) + "");
		}

		// Pegando o segundo dígito validador
		digito2 = ((soma % 11) < 2) ? 0 : 11 - (soma % 11);
		cnpj += digito2;

		// Verificando se os valores são iguais;
		if (cnpj.equals(cnpjLimpo)) {
			return true;
		}
		return false;
	}

	/**
	 * Método para validar o CPF. Através da multiplicação e soma dos dígitos
	 * presentes no CPF com alguns valores definidos, conseguimos obter dois dígitos
	 * validadores, onde se eles forem iguais aos dígitos validadores do CPF passado
	 * pelo usuário a validação é verdadeira, caso contrário ela é falsa
	 * 
	 * @param cpf - Recebe o CPF passado pelo usuário
	 * @return Retorna verdadeiro caso o CPF passe na validação ou falso caso o CPF
	 *         não passe na validação
	 * @exception Exception Caso o CPF passado esteja com letras no meio do dos
	 *                      números
	 */
	public static boolean validarCpf(String cpf) throws Exception {
		// Variáveis para a manipulação do CPF;
		String cpfLimpo = limparDocumento(cpf);
		cpf = cpfLimpo.substring(0, 9);
		int soma = 0, digito1 = 0, digito2 = 0, multiplicacao = 10;

		if (cpfLimpo.equals("00000000000") || cpfLimpo.equals("11111111111")) {
			return false;
		}

		/*
		 * Fazendo a multiplicação dos dígitos do CPF com os valores da variável
		 * "multiplicacao" e somando o resultado de cada iteração para pegar o primeiro
		 * dígito do CPF
		 */
		for (int i = 0; i < 9; i++) {
			soma += multiplicacao * Integer.parseInt(cpfLimpo.charAt(i) + "");
			multiplicacao--;
		}

		// Pegando o primeiro dígito validador
		digito1 = ((soma % 11) < 2) ? 0 : 11 - (soma % 11);

		cpf += digito1;
		soma = 0;
		multiplicacao = 11;

		/*
		 * Fazendo a multiplicação dos dígitos do CPF com os valores da variável
		 * "multiplicacao" e somando o resultado de cada iteração para pegar o primeiro
		 * dígito do CPF
		 */
		for (int i = 0; i < 10; i++) {
			soma += multiplicacao * Integer.parseInt(cpf.charAt(i) + "");
			multiplicacao--;
		}

		// Pegando o segundo dígito validador
		digito2 = ((soma % 11) < 2) ? 0 : 11 - (soma % 11);
		cpf += digito2;

		// Verificando se os valores são iguais;
		if (cpf.equals(cpfLimpo)) {
			return true;
		}
		return false;
	}

	/**
	 * Método para validar a Inscrição Estadual (IE). Através da multiplicação e
	 * soma dos dígitos presentes no IE com alguns valores definidos, conseguimos
	 * obter um dígito validador, onde se ele for igual ao dígito validador do IE
	 * passado pelo usuário a validação é verdadeira, caso contrário ela é falsa
	 * 
	 * Obs: Algumas IE podem acabar sendo verificadas de forma errada, pelo fato de
	 * cada estado ter a sua validação, então não se assuste caso uma IE válida não
	 * passe na validação
	 * 
	 * @param ie - Recebe a Inscrição Estadual (IE) passado pelo usuário
	 * @return Retorna verdadeiro caso o IE passe na validação ou falso caso o IE
	 *         não passe na validação
	 * @exception Exception Caso o IE passado esteja com letras no meio do dos
	 *                      números
	 */
	public static boolean validarInscricaoEstadual(String ie) throws Exception {
		// Variáveis para a manipulação do IE;
		String ieLimpo = limparDocumento(ie);
		final String NUMERO_VERIFICADOR = "98765432";
		int soma = 0, digito = 0;

		if (ieLimpo.equals("000.000.000.000") || ieLimpo.equals("000000000")) {
			return false;
		}
		/*
		 * Pegando o IE até o penúltimo dígito para depois verificar se o dígito é
		 * gerado pela soma é igual a dígito presente o IE passado pelo usuário
		 */
		if (ieLimpo.length() == 12) {
			ie = ieLimpo.substring(0, 11);
		} else {
			ie = ieLimpo.substring(0, 8);
		}

		/*
		 * Fazendo a multiplicação dos dígitos do IE com os valores da constante e
		 * somando o resultado de cada iteração
		 */
		for (int i = 0; i < NUMERO_VERIFICADOR.length(); i++) {
			soma += Integer.parseInt(ieLimpo.charAt(i) + "") * Integer.parseInt(NUMERO_VERIFICADOR.charAt(i) + "");
		}

		// Pegando o dígito validador;
		digito = ((soma % 11) == 0 || (soma % 11) == 1) ? 0 : 11 - (soma % 11);
		ie += digito;

		// Verificando se os valores são iguais;
		if (ie.equals(ieLimpo)) {
			return true;
		}
		return false;
	}
}