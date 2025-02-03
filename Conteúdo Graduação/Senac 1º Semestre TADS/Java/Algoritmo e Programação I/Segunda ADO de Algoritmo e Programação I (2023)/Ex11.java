import javax.swing.JOptionPane;

public class Ex11 {

	/*
	 * 11. Crie um algoritmo que mostre o menu de opções a seguir, receba a opção do
	 * usuário e os dados necessários para executar cada operação. Menu de Opções:
	 * 1. Somar dois números 2. Raiz quadrada de um número 3. Elevar um número a uma
	 * potência. Digite a opção desejada.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double n1, n2, soma, raiz, potencia, expoente;
		String menu;

		// Entrada de dados em Swing;
		menu = JOptionPane.showInputDialog(null, "Olá, digite (S) para somar dois números, (R) para a Raiz quadrada de um número "
				+ "e (P) para Elevar um número a uma potência","Menu de opções", JOptionPane.QUESTION_MESSAGE);

		// Decisões;
		if (menu.equals("S")) { // CÁLCULO DA SOMA, SE O USUÁRIO ESCOLHER (S);
			n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o primeiro número para a soma", // PRIMEIRO NÚMERO;
					"Primeiro número", JOptionPane.QUESTION_MESSAGE));

			n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o segundo número para a soma", // SEGUNDO NÚMERO; 
					"Segundo número", JOptionPane.QUESTION_MESSAGE));

			soma = n1 + n2; // RESULTADO;
			JOptionPane.showMessageDialog(null, "O resultado foi " + soma); // EXIBIÇÃO DO RESULTADO;

		} else if (menu.equals("R")) { // CÁLCULO DA RAIZ QUADRADA, SE O USUÁRIO ESCOLHER (R);
			n1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite um número para o calculo da raiz quadrada"
					, "Raiz Quadrada", JOptionPane.QUESTION_MESSAGE));

			raiz = Math.sqrt(n1); // CÁLCULO DA RAIZ QUADRADA;
			JOptionPane.showMessageDialog(null, "O resultado foi " + raiz); // EXIBIÇÃO DO RESULTADO;

		} else if (menu.equals("P")) { // CÁLCULO DA POTÊNCIA, SE O USUÁRIO ESCOLHER (P);
			n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o primeiro número para o calculo da potênciação",
							"Potênciação", JOptionPane.QUESTION_MESSAGE));
			
			expoente = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o expoente",
					"Potênciação", JOptionPane.QUESTION_MESSAGE)); 
			
			potencia = Math.pow(n1, expoente); // CÁLCULO DA POTÊNCIA ;
			JOptionPane.showMessageDialog(null, "O resultado foi " + potencia); // EXIBIÇÃO DO RESULTADO;

		} else { 
			JOptionPane.showMessageDialog(null, "Erro");
		}

	}

}
