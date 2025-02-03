import javax.swing.JOptionPane;

public class Ex9 {

	/*
	 * Você foi solicitado a criar um programa para acompanhamento de peso, no qual
	 * através do peso e da altura calcula-se o IMC. Após o cálculo, deverá ser
	 * informada a classificação, conforme tabela abaixo. (IMC = Peso / Altura²)
	 * 
	 * Menor ou igual a 16 Magreza Severa. Entre 16 e 17 Magreza Moderada. Entre 17
	 * e 18.5 Magreza Leve. Entre 18.5 e 25 Normal. Entre 25 e 30 Obesidade Leve
	 * Entre 30 e 40 Obesidade Severa. Acima de 40 Obesidade Mórbida
	 */

	public static void main(String[] args) {
		// Variáveis;
		double peso, altura, imc;
		String classif;
		int msg;
		
		// Entrada de dados em Swing;
		peso = Double.parseDouble(
				JOptionPane.showInputDialog(null, "Olá, digite o seu peso", "Peso", JOptionPane.QUESTION_MESSAGE));
		altura = Double.parseDouble(JOptionPane.showInputDialog(null,
				"Agora, digite sua altura (com ponto em invez da vírgula)", "Altura", JOptionPane.QUESTION_MESSAGE));

		// Calculo do IMC;
		imc = peso / (altura * altura);

		// Decisões;
		if (peso < 0 || altura < 0) {
			JOptionPane.showMessageDialog(null, "Informações Inválidas", "Erro", JOptionPane.WARNING_MESSAGE);
		
		} else {

			if (imc > 40) {
				classif = "Obesidade Mórbida";
				msg = JOptionPane.WARNING_MESSAGE;
			
			} else if (imc > 30 && imc < 40) {
				classif = "Obesidade Severa";
				msg = JOptionPane.WARNING_MESSAGE;
			
			} else if (imc > 25 && imc < 30) {
				classif = "Obesidade Leve";
				msg = JOptionPane.WARNING_MESSAGE;
			
			} else if (imc > 18.5 && imc < 25) {
				classif = "Normal";
				msg = JOptionPane.INFORMATION_MESSAGE;
			
			} else if (imc > 17 && imc < 18.5) {
				classif = "Magreza Leve";
				msg = JOptionPane.WARNING_MESSAGE;
			
			} else if (imc > 16 && imc < 17) {
				classif = "Magreza Moderada";
				msg = JOptionPane.WARNING_MESSAGE;
			
			} else {
				classif = "Magreza Severa";
				msg = JOptionPane.WARNING_MESSAGE;
			}
			JOptionPane.showMessageDialog(null, "Seu IMC: " + imc);
			JOptionPane.showMessageDialog(null, classif, "Classificação", + msg);
		}
	}
}