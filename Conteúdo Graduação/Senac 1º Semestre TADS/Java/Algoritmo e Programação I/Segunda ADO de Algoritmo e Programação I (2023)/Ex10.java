import javax.swing.JOptionPane;

public class Ex10 {

	/*
	 * 10. Crie um algoritmo que dados três valores X, Y e Z, verifique se eles
	 * podem ser os comprimentos dos lados de um triângulo e, se forem, verifique se
	 * é um triângulo equilátero, isósceles ou escaleno. Considere que: • O
	 * comprimento de cada lado de um triângulo é menor do que a soma dos outros
	 * dois lados; • Chama-se equilátero o triângulo que tem três lados iguais; •
	 * Chama-se isósceles o triângulo que tem o comprimento de dois lados iguais; •
	 * Recebe o nome de escaleno o triângulo que tem os três lados diferentes.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double x, y, z;
		String classif;

		// Entrada de dados em Swing;
		x = Double.parseDouble(JOptionPane.showInputDialog(null,"Olá, digite o valor do primeiro número"
				+ ", se for um número decimal, escreva com o ponto !","Primeiro Número", JOptionPane.QUESTION_MESSAGE));

		y = Double.parseDouble(JOptionPane.showInputDialog(null,"Agora, digite o valor do segundo número "
				+ ", se for um número decimal, escreva com o ponto !", "Segundo Número", JOptionPane.QUESTION_MESSAGE));

		z = Double.parseDouble(JOptionPane.showInputDialog(null,"E por último, digite o valor do terceiro número"
				+ ", se for um número decimal, escreva com o ponto !","Primeiro Número", JOptionPane.QUESTION_MESSAGE));

		if (x == y + z || y == x + z || z == x + y) {
			JOptionPane.showMessageDialog(null, "Erro");
		} else if (x <= 0 || y <= 0 || z <= 0) {
			JOptionPane.showMessageDialog(null, "Erro");
		} else {

			if (x == y && x == z) {
				classif = "Triângulo Equilátero";
				JOptionPane.showMessageDialog(null, classif);
			
			} else if (x == y && x != z || y == z && y != x) {
				classif = "Triângulo Isósceles";
				JOptionPane.showMessageDialog(null, classif);
			
			} else if (x != y && x != z && y != z) {
				classif = "Triângulo escaleno";
				JOptionPane.showMessageDialog(null, classif);
			
			} else {
				JOptionPane.showMessageDialog(null,"Não foi possível verificar os números" + JOptionPane.WARNING_MESSAGE);
			}

		}

	}

}
