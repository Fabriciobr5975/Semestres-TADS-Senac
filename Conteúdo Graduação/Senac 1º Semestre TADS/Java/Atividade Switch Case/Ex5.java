import javax.swing.JOptionPane;

public class Ex5 {

	public static void main(String[] args) {
		// Variáveis;
		int menu, msg;

		menu = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número relativo para a conta deseja realizar:\n1- Área do triângulo "
				+ "\n2- Velocidade Média \n3- Milímetros para polegadas \n4- Converter temperaturas, de graus celsius (C) para kelvin (K)"
				+ "\n5- Área de um círculo \n6- Saír", "Menu de Opções", JOptionPane.INFORMATION_MESSAGE));

		// Switch case;
		switch (menu) {
		case 1 -> { // ÁREA DO TRIÂNGULO;
			double base, altura;
			base = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Digite a base", "Valor da base", JOptionPane.QUESTION_MESSAGE));
			altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a altura", "Valor da altura",
					JOptionPane.QUESTION_MESSAGE));

			if (base <= 0 || altura <= 0) { // SE UM DOS NÚMEROS PARA O CÁLCULO DA AREA DE UM TRIÂNGULO FOR MENOR OU IGUAL A 0, EMITE A MENSAGEM DE ERRO
				msg = JOptionPane.WARNING_MESSAGE;
				JOptionPane.showMessageDialog(null, "Erros nos números", "Erro", msg);
			} else {
				base *= altura / 2;
				JOptionPane.showMessageDialog(null, String.format("A área deste triâgulo é: %.1f ", base));
			}
		
		}
		case 2 -> { // VELOCIDADE MÉDIA;
			double distancia, tempo;
			distancia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a distância em km", "Distância",
					JOptionPane.QUESTION_MESSAGE));
			tempo = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o tempo em horas", "Tempo",
					JOptionPane.QUESTION_MESSAGE));
			distancia /= tempo;
			JOptionPane.showMessageDialog(null, String.format("A velocidade média é: %.1f km/h ", distancia));
		
		}
		case 3 ->{ // CONVERTER MILÍMETROS PARA POLEGADAS;
			double milimetros;
			milimetros = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite um número em milímetros para converter para polegadas",
					 "Milímetros", JOptionPane.QUESTION_MESSAGE));
			milimetros /= 25.4;
			JOptionPane.showMessageDialog(null, String.format("De milímetros para polegadas o resultado é: %.8f Polegadas ", milimetros));	
		
		}
		case 4 ->{ // CONVERTER TEMPERATURAS;
			double graus;
			graus = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite uma temperatura em graus Celsius",
					 "Milímetros", JOptionPane.QUESTION_MESSAGE));
			graus += 273.15;
			JOptionPane.showMessageDialog(null, String.format("De graus Celsius para Kelvin o resultado é: %.2f K ", graus));	
		
		}
		case 5 ->{ // ÁREA DO CÍRCULO;
			double raio;
			raio = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o o valor do raio da circunferência",
					"Valor do raio", JOptionPane.QUESTION_MESSAGE));
			msg = JOptionPane.WARNING_MESSAGE;
			
			if(raio <= 0) { // SE O VALOR DO RAIO FOR MENOR OU IGUAL A 0, EMITE A MENSAGEM DE ERRO
				JOptionPane.showMessageDialog(null, "Número inválido", "Erro",  msg);
				} else {
					raio = Math.PI * Math.pow(raio, 2);
					JOptionPane.showMessageDialog(null, String.format("A área desta circunferência é: %.2f ", raio));	
					
		}
		}
	}

}
}
