package atividades.veiculo;

/**
 * @author Fabrício de Araújo Santana
 */
public class Veiculo {
	// Atributos da Classe;
	private String marca;
	private String modelo;
	private String versao;
	private String cor;
	private int anoFabricacao;
	private String motor;
	private double combustivel;
	private int velocidade;
	private boolean ligado;
	private String marcha;
	private double tanqueCombustivel;

	/**
	 * Construtor padrão
	 */
	public Veiculo() {
		this.velocidade = 0;
		this.ligado = false;
		this.marcha = "Neutro";
	}

	/**
	 * Construtor para inicilizar os atributos que são necessário para a criação de
	 * objetos do tipo Veículo
	 * 
	 * @param marca         - Recebe a marca deste Veículo
	 * @param modelo        - Recebe o modelo deste Veículo
	 * @param versao        - Recebe a versão deste Veículo
	 * @param cor           - Recebe a cor deste Veículo
	 * @param anoFabricacao - Recebe um ano que representa o seu ano de fabricação
	 * @param motor         - Recebe recebe a cilindrada do motor
	 * @param combustivel   - Recebe um valor interio que representa a quantidade de
	 *                      combustivel para este veículo
	 */
	public Veiculo(String marca, String modelo, String versao, String cor, int anoFabricacao, String motor,
			double combustivel) {
		this();
		this.marca = marca;
		this.modelo = modelo;
		this.versao = versao;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.motor = motor;
		this.combustivel = combustivel;
		this.tanqueCombustivel = this.combustivel;
	}

	/**
	 * Método para ligar o veículo, verificando se o mesmo está desligado e com
	 * combustível
	 * 
	 * @return Retorna uma mensagem para alertar o usuário se o veículo foi ligado
	 *         ou não
	 */
	public String ligarVeiculo() {
		if (!isLigado() && this.verificarCombustivel()) {
			this.ligado = true;
			return "Ligando o veículo";

		} else if (this.combustivel <= 0) {
			return "Veículo sem combustível";
		}

		return "Veículo já ligado";
	}

	/**
	 * Método para desligar o veículo, verificando se o mesmo está ligado e sua
	 * velocidade é igual a zero
	 * 
	 * @return Retorna uma mensagem para alertar o usuário se o veículo foi
	 *         desligado ou não
	 */
	public String desligarVeiculo() {
		if (isLigado() && this.velocidade == 0) {
			this.ligado = false;
			return "Desligando o veículo";

		} else if (velocidade > 0) {
			return "Não é possível desligar o carro em movimento!";
		}

		return "Veículo já desligado";
	}

	/**
	 * Método para verificar a quantidade de combustivel, ele é privado, pois ele é
	 * usado apenas nos métodos da classe para fazer verificações de combustivel
	 * 
	 * @return Retornar verdadeiro se o carro tiver combustível, ou falso caso ele
	 *         não tem combustível
	 */
	private boolean verificarCombustivel() {
		if (this.combustivel > 0) {
			return true;
		}
		this.combustivel = 0;
		this.ligado = false;
		return false;
	}
	
	/**
	 * Método simples para completar o combustível do carro;
	 */
	public void abastecerVeiculo() {
		if(!this.isLigado() && this.velocidade == 0) {
			this.combustivel = this.tanqueCombustivel;
		} 
	}
	
	/**
	 * Método para verificar em que marcha o veículo sem encontra de acordo com sua
	 * velocidade. Este método é privado, pois essa verificação é usada para mudar a
	 * marchar quando o veículo acelerar ou frear
	 * 
	 * @return Retorna um valor do tipo String representado a marcha que o veículo
	 *         se encontra
	 */
	private String verificarMarcha() {
		// Estrutura para verificar em que velocidade a marcha correspende;
		if (this.velocidade > 0 && this.velocidade <= 20) {
			this.marcha = "1";

		} else if (this.velocidade <= 40) {
			this.marcha = "2";

		} else if (this.velocidade <= 60) {
			this.marcha = "3";

		} else if (this.velocidade <= 80) {
			this.marcha = "4";

		} else if (this.velocidade <= 120) {
			this.marcha = "5";

		} else {
			this.marcha = "Neutro";
		}
		return this.marcha;
	}

	/**
	 * Método para acelerar o veículo, baseando em segundos em que o motorista
	 * acelera o veículo. Para isso temos um loop for realizando as iterações
	 * baseada em um valor do tipo int, representando os segundos
	 * 
	 * @param segundos - Recebe um valor que representa os segundos que o carro irá
	 *                 acelerar
	 */
	public void acelerar(int segundos) {
		// Estrutura que tenta simular o ganho de velocidade de um veículo;
		if (this.ligado) {
			for (int i = 0; i < segundos; i++) {
				if (!this.verificarCombustivel()) {
					break;
				}

				if (this.velocidade < 30) {
					this.velocidade += 12;
					this.verificarMarcha();
					this.combustivel -= 0.7;

				} else if (this.velocidade < 50) {
					this.velocidade += 10;
					this.verificarMarcha();
					this.combustivel -= 0.5;

				} else if (this.velocidade < 100) {
					this.velocidade += 8;
					this.verificarMarcha();
					this.combustivel -= 0.2;

				} else {
					this.velocidade += 2;
					this.verificarMarcha();
					this.combustivel -= 0.08;
				}

				if (this.velocidade > 120) {
					this.velocidade = 120;
					this.verificarMarcha();
				}
			}
		}
	}

	/**
	 * Método para frear o veículo, baseando em segundos em que o motorista frar o
	 * veículo. Para isso temos um loop for realizando as iterações baseada em um
	 * valor do tipo int, representando os segundos
	 * 
	 * @param segundos - Recebe um valor que representa os segundos que o carro irá
	 *                 acelerar
	 */
	public void frear(int segundos) {
		// Estrutura que tenta simular o perda de velocidade de um veículo;
		if (this.ligado && this.velocidade > 0) {
			for (int i = 0; i < segundos; i++) {
				if (!this.verificarCombustivel()) {
					break;
				}

				if (this.velocidade >= 80) {
					this.velocidade -= 10;
					this.verificarMarcha();
					this.combustivel -= 0.1;

				} else if (this.velocidade >= 30) {
					this.velocidade -= 8;
					this.verificarMarcha();
					this.combustivel -= 0.07;

				} else {
					this.velocidade -= 6;
					this.verificarMarcha();
					this.combustivel -= 0.05;
				}

				if (this.velocidade <= 0) {
					this.velocidade = 0;
					this.verificarMarcha();
				}
			}
		}
	}

	/**
	 * Método que salva os dados referentes ao veículo para poder ser impresso em
	 * outra classe. Esse dados são as caracteristicas do veículo, como modelo,
	 * marca, cor entre outros
	 * 
	 * @return Retorna os dados do veículo formatado para ser impresso
	 */
	public String informacaoVeiculo() {
		return String.format("Marca: %s%nModelo: %s%nVersão: %s%nCor: %s%nAno de Fabricação: %s%nMotor: %s%n",
				this.marca, this.modelo, this.versao, this.cor, this.anoFabricacao, this.motor);
	}

	/**
	 * Método que salva os dados referentes do painel do veículo para poder ser
	 * impresso em outra classe. Esses dados são as informações que aparecem no
	 * painel dos automóveis, com a velocidade, combustivel entre outros
	 * 
	 * @return Retorna os dados do painel do veículo formatado para ser impresso
	 */
	public String informacaoPainel() {
		String infoStatusVeiculo = isLigado() ? "Ligado" : "Desligado";

		return String.format("Velocidade: %d Km/h%nMarcha: %s%nCombustível: %5.2f%nEstado: %s%n", this.velocidade,
				this.marcha, this.combustivel, infoStatusVeiculo);
	}

	/**
	 * Método para pegar a marca salva do veículo
	 * 
	 * @return Retorna a marca salva
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Método para mudar a marca do veículo
	 * 
	 * @param marca - Recebe uma nova marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Método para pegar o modelo salvo do veículo
	 * 
	 * @return Retorna o modelo salvo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Método para mudar o modelo do veículo
	 * 
	 * @param modelo - Recebe um novo modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Método para pegar a versão salva do veículo
	 * 
	 * @return Retorna a versão salva
	 */
	public String getVersao() {
		return versao;
	}

	/**
	 * Método para mudar a versão do veículo
	 * 
	 * @param versao - Recebe uma nova versão
	 */
	public void setVersao(String versao) {
		this.versao = versao;
	}

	/**
	 * Método para pegar a cor salva do veículo
	 * 
	 * @return Retorna a cor salva
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Método para mudar a cor do veículo
	 * 
	 * @param cor - Recebe uma nova cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Método para pegar o ano de fabricação salva do veículo
	 * 
	 * @return Retorna o ano de fabricação salvo
	 */
	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	/**
	 * Método para mudar o ano de fabricição do veículo
	 * 
	 * @param anoFabricacao - Recebe um novo ano de fabricação
	 */
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	/**
	 * Método para pegar o motor salvo do carro. OBS: O motor do carro neste caso
	 * armazena a cilindrada do motor e a quantidade de válvulas, por exemplo: 1.0 8
	 * Válvulas ou 8v, 1.6 16v entre outros. Mas, caso queria colocar o código do
	 * motor, por exemplo "TU5JP4", fique a vontade
	 * 
	 * @return Retorna o motor salvo
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * Método para mudar o motor do veículo.
	 * 
	 * @param motor - Recebe um novo motor
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * Método para pegar a quantidade de combustível salva do veículo;
	 * 
	 * @return Retorna a quantidade de combustivel salva
	 */
	public double getCombustivel() {
		return combustivel;
	}

	/**
	 * Método para verificar se o carro está ligado
	 * 
	 * @return Retorna verdadeiro caso o carro esteja ligado e falso caso ele esteja
	 *         desligado
	 */
	public boolean isLigado() {
		return ligado;
	}

	/**
	 * Método para pegar a velocidade do veículo
	 * 
	 * @return Retorna a velocidade salvo do veículo
	 */
	public int getVelocidade() {
		return velocidade;
	}

	/**
	 * Método para pegar em qual marcha o veículo está
	 * 
	 * @return Retorna a marcha correspondente a velocidade do veículo
	 */
	public String getMarcha() {
		return marcha;
	}

	/**
	 * Método para imprimir os objetos, usado apenas em teste com vetores(arrays)
	 */
	@Override
	public String toString() {
		return informacaoVeiculo();
	}
}