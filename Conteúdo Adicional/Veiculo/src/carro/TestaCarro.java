package carro;

public class TestaCarro {
	public static void main(String[] args) {
		Veiculo carro1 = new Veiculo();
		
		carro1.marca = "Peugeot";
		carro1.modelo = "206";
		carro1.cor = "Prata";
		carro1.portas = "5";
		carro1.versao = "Allure";
		carro1.motor = "1.6 16V";
		carro1.tanqueCombustivel = 50;
		
		System.out.println(carro1.ligarVeiculo());
		System.out.println(carro1.ligarFarois());
		System.out.println();
		carro1.acelerar(60);
		System.out.println(carro1.informacaoVeiculo());
		carro1.freiar(24);
		System.out.println(carro1.informacaoVeiculo());
		System.out.println(carro1.desligarVeiculo());

	}
}
