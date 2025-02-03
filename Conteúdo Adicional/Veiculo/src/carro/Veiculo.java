package carro;

public class Veiculo {
	// Atributos;
	public String marca;
	public String modelo;
	public String versao;
	public String cor;
	public String portas;
	public String motor;
	public double tanqueCombustivel;
	private int velocidade = 0;
	private boolean ligado = false;
	private boolean farois = false;

	private boolean verificarSeEstaLigado() {
		if (this.ligado) {
			return true;
		}
		return false;
	}

	public String ligarVeiculo() {
		if (!this.verificarSeEstaLigado() && this.verificarCombustivel()) {
			this.ligado = true;
			return "Ligando o veículo";

		} else if (this.tanqueCombustivel <= 0) {
			return "Veículo sem combustível";
		}

		return "Veículo já ligado";
	}

	public String desligarVeiculo() {
		if (this.verificarSeEstaLigado() && this.velocidade == 0) {
			this.ligado = false;
			this.farois = false;
			return "Desligando o veículo";

		} else if (velocidade > 0) {
			return "Não é possível desligar o carro em movimento!";
		}

		return "Veículo já desligado";
	}

	private boolean verificarCombustivel() {
		if (this.tanqueCombustivel > 0) {
			return true;
		}
		this.ligado = false;
		return false;
	}

	public void acelerar(int segundos) {
		if (this.ligado) {
			for (int i = 0; i < segundos; i++) {
				if (this.velocidade < 100) {
					this.velocidade += 7;
					this.tanqueCombustivel -= 0.2;

				} else {
					this.velocidade += 2;
					this.tanqueCombustivel -= 0.07;
				}

				if (this.velocidade >= 180) {
					this.velocidade = 180;
				}
			}
		}
	}

	public void freiar(int segundos) {
		if (this.ligado && this.velocidade > 0) {
			for (int i = 0; i < segundos; i++) {
				velocidade -= 8;
				this.tanqueCombustivel -= 0.02;

				if (velocidade <= 0) {
					velocidade = 0;
				}
			}
		}
	}

	public String ligarFarois() {
		if (this.verificarSeEstaLigado()) {
			this.farois = true;
			return "Fárois ligados";
		}
		return "Fárois desligados";
	}

	public String desligarFarois() {
		if (this.farois) {
			this.farois = false;
			return "Fárois desligados";
		}
		return "Fárois já desligado";
	}

	public String informacaoVeiculo() {
		return String.format(
				"Marca: %s%nModelo: %nVersão: %s%nCor: %s%nPortas: %s%nMotor: %s%n%s%nVelocidade: %d Km/h%nCombustível: %5.2f%n",
				this.marca, this.modelo, this.versao, this.cor, this.portas, this.motor, this.velocidade,
				this.tanqueCombustivel);
	}
}
