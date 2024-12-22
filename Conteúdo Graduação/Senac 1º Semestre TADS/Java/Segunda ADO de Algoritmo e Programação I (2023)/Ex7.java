import javax.swing.JOptionPane;

public class Ex7 {

	/*
	 * 7.Crie um algoritmo que calcule o salário líquido de acordo com as
	 * orientações a seguir: a) Receber o salário base e gratificação via teclado;
	 * b) Salário bruto será a soma do salário base com a gratificação; c) Se o
	 * salário bruto for inferior a R$ 2500,00 incidirá um imposto de 10%, caso
	 * contrário 15%; d) Exibir o salário bruto, a gratificação, o imposto e o
	 * salário líquido.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double salBase, gratificacao, salBruto, desconto, salLiquido;
		int msg;
		// Entrada de dados em Swing;
		salBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Olá, Digite o salário base:", "Salário Base",
				JOptionPane.QUESTION_MESSAGE));
		gratificacao = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora Digite a gratificação:",
				"Salário Base", JOptionPane.QUESTION_MESSAGE));
		// Salário Bruto
		salBruto = salBase + gratificacao;

		// Decisões;
		if (salBase < 0 || gratificacao < 0) {
			JOptionPane.showMessageDialog(null, "Informação inválida", "Erro", JOptionPane.WARNING_MESSAGE);
		} else {

			if (salBruto < 2500) {
				desconto = (salBruto * 10) / 100;
				salLiquido = salBruto - desconto;
				msg = JOptionPane.INFORMATION_MESSAGE;

			} else {
				desconto = (salBruto * 15) / 100;
				salLiquido = salBruto - desconto;
				msg = JOptionPane.INFORMATION_MESSAGE;
			

			JOptionPane.showMessageDialog(null, salBruto, "Salário Bruto", msg);
			JOptionPane.showMessageDialog(null, gratificacao, "Gratificação", msg);
			JOptionPane.showMessageDialog(null, desconto, "Desconto", msg);
			JOptionPane.showMessageDialog(null, salLiquido, "Salário Liquido", msg);
			}
		}

	}
}