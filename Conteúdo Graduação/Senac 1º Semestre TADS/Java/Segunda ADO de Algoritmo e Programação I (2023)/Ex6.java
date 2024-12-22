import javax.swing.JOptionPane;

public class Ex6 {

	/*
	 * 6. Crie um algoritmo que receba como entrada o sexo de uma pessoa (M para
	 * Masculino e F para Feminino), sua altura (em centímetros) e calcule o seu
	 * peso ideal, utilizando as seguintes fórmulas: a) Homens ➔ 52 + (0,75 *
	 * (altura - 152,4)) b) Mulheres ➔ 52 + (0,67 * (altura - 152,4))
	 */

	public static void main(String[] args) {
		// Variáveis;
		String sexo;
		double altura, pesoIdeal;

		// Entrada de dados em Swing;
		sexo = (JOptionPane.showInputDialog(null, "Digite o sexo, sendo M para Homem e F para mulher", "Sexo",
				JOptionPane.QUESTION_MESSAGE)); // ENTRADA DO SEXO;
		
		altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora, digite à altura em centímetros", "Altura",
				JOptionPane.QUESTION_MESSAGE)); // ENTRADA DA ALTURA;

		// Estruturas de decisões;
		if (sexo.equals("M")) {
			pesoIdeal = 52 + (0.75 * (altura - 152.4)); 
			JOptionPane.showMessageDialog(null, "O peso " + pesoIdeal + " é o ideal");
		
		} else if (sexo.equals("F")){
			pesoIdeal = 52 + (0.67 * (altura - 152.4)); 
			JOptionPane.showMessageDialog(null, "O peso " + pesoIdeal + " é o ideal");
		
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}
}