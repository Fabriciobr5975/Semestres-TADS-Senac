package atividades.imc;

/**
 * Fabrício de Araújo Santana
 */
public final class Imc {
	/**
	 * Método estático para calcular o IMC (Índice de Massa Corporal) de um usuário
	 * com base em seu peso e altura.
	 * 
	 * @param usuario - Recebe um um objeto do tipo Usuario para a realização do
	 *                calculo
	 * @return Retorna o valor do IMC do usuário.
	 * @throws Exception Se o sexo do usuário não for "Masculino" ou "Feminino".
	 */
	public static double calcularImcUsuario(Usuario usuario) throws Exception {
		double imcUsuario = 0;
		double alturaUsuario = usuario.getAltura() / 100;

		if (usuario.getSexo().equals("Masculino") || usuario.getSexo().equals("Feminino")) {
			imcUsuario = usuario.getPeso() / (Math.pow(alturaUsuario, 2));

		} else {
			throw new Exception("Não é possível calcular o seu IMC sem um sexo definido");
		}
		return imcUsuario;
	}

	/**
	 * Método estático para calcular qual seria o peso ideal do usuário, através da
	 * fórmula: 52 + (0.75 * (altura - 152.4));
	 * 
	 * @param usuario - Recebe um um objeto do tipo Usuario para a realização do
	 *                calculo
	 * @return Retorna o valor do peso ideal do Usuário
	 * @throws Exception Se o sexo do usuário não for "Masculino" ou "Feminino".
	 */
	public static double calcularPesoIdeal(Usuario usuario) throws Exception {
		double pesoIdeal = 0;

		if (usuario.getSexo().equals("Masculino")) {
			pesoIdeal = 52 + (0.75 * (usuario.getAltura() - 152.4));

		} else if (usuario.getSexo().equals("Feminino")) {
			pesoIdeal = 52 + (0.67 * (usuario.getAltura() - 152.4));

		} else {
			throw new Exception("Não é possível calcular o seu IMC sem um sexo definido");
		}
		return pesoIdeal;
	}

	/**
	 * Método estático para verificar o IMC (Índice de Massa Corporal) de um usuário
	 * e retorna uma avaliação com base no resultado obtido.
	 * 
	 * @param usuario - Recebe um um objeto do tipo Usuario para a realização do
	 *                calculo
	 * @return Retorna uma String com a avaliação do IMC do usuário, como "Abaixo do
	 *         peso", "Normal", "Obesidade Leve", etc.
	 * @throws Exception Se o sexo do usuário não for "Masculino" ou "Feminino".
	 */
	private static String verificarImcUsuario(Usuario usuario) throws Exception {
		String informacaoImc = "";
		double resultadoImcUsuario = calcularImcUsuario(usuario);

		switch (usuario.getSexo()) {
		case "Masculino" -> {
			if (resultadoImcUsuario < 20) {
				informacaoImc = "Abaixo do peso";

			} else if (resultadoImcUsuario <= 24.9) {
				informacaoImc = "Normal";

			} else if (resultadoImcUsuario <= 29.9) {
				informacaoImc = "Obesidade Leve";

			} else if (resultadoImcUsuario <= 39.9) {
				informacaoImc = "Obsidade Moderada";

			} else {
				informacaoImc = "Obesidade Mórbida";
			}
		}
		case "Feminino" -> {
			if (resultadoImcUsuario < 19) {
				informacaoImc = "Abaixo do peso";

			} else if (resultadoImcUsuario <= 23.9) {
				informacaoImc = "Normal";

			} else if (resultadoImcUsuario <= 28.9) {
				informacaoImc = "Obesidade Leve";

			} else if (resultadoImcUsuario <= 38.9) {
				informacaoImc = "Obsidade Moderada";

			} else {
				informacaoImc = "Obesidade Mórbida";
			}
		}
		default -> {
			throw new Exception("Não é possível verificar o seu IMC");
		}
		}
		return informacaoImc;
	}

	/**
	 * Método estático para gerar um relatório formatado com os principais dados do
	 * usuário e os resultados dos cálculos de IMC (Índice de Massa Corporal), peso
	 * ideal e a avaliação do IMC.
	 * 
	 * @param usuario - Recebe um um objeto do tipo Usuario para a realização do
	 *                calculo
	 * @return Retorna uma String formatada contendo o nome, idade, sexo do usuário,
	 *         além do IMC calculado, peso ideal e a avaliação do IMC.
	 * @throws Exception Se o sexo do usuário não for "Masculino" ou "Feminino".
	 */
	public static String imprimirInformacoesImc(Usuario usuario) throws Exception {
		return String.format(
				"Dados gerais do Usuário%nUsuario: %s%nIdade: %d%nSexo: %s%nPeso: %4.1f Kg%nAltura: %4.2f "
						+ "m%n%nDados do IMC e Peso Ideal%nIMC: %4.1f kg/m2%nPeso Ideal: %4.1f Kg%nStatus: %s%n",
				usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getPeso(),
				(usuario.getAltura() / 100), calcularImcUsuario(usuario), calcularPesoIdeal(usuario),
				verificarImcUsuario(usuario));
	}
}