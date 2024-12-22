import javax.swing.JOptionPane;

public class Ex4 {

	public static void main(String[] args) {
		// Variáveis;
		int codProduto, codPais;
		double peso, preco, imposto, precoT, valorImposto, valorT;

		// Entrada de dados;
		codProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Olá, digite o codigo do produto", // CÓDIGO DO PRODUTO
				"Código do produto", JOptionPane.INFORMATION_MESSAGE));

		peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora digite o peso em kg:", "Peso do produto", // PESO DO PRODUTO EM KG
				JOptionPane.INFORMATION_MESSAGE));

		codPais = Integer.parseInt(JOptionPane.showInputDialog(null, "Por último, digite o código do país", // CÓDIGO DO PAÍS
				"Código do país", JOptionPane.INFORMATION_MESSAGE));

		// Switch 1 (Código do produto);
		switch(codProduto){
		case 1,2,3,4 ->{
			preco = 10;
		}
		case 5,6,7 ->{
			preco = 25;
		}
		case 8,9,10 ->{
			preco = 35;
		}
		default -> preco = 0;
		}
		
		// Switch 2 (Código do país);
		switch(codPais){
		case 1 ->{
			imposto = 0;
		}
		case 2 ->{
			imposto = 0.15;
		}
		case 3 ->{
			imposto = 0.25;
		}
		default -> imposto = 0;
		}
		
		// Resultados;
		peso *= 1000; // PASSANDO O PESO EM KG PARA GRAMAS
		valorT = peso * preco;
		valorImposto = valorT * imposto;
		precoT = valorT + valorImposto;
		
		// Saída dos resultados;
		JOptionPane.showMessageDialog(null, String.format("Peso em gramas: %.2f %nvalor Total do produto: %.2f "
				+ "%nvalor do imposto: %.2f %nPreço total: %.2f", peso, valorT, valorImposto, precoT ));
	
	
	}
}