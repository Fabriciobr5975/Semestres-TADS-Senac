import javax.swing.JOptionPane;

public class Ex14 {

	/*
	 * 14. Crie um algoritmo que receba 3 notas de um aluno e calcule a média. Caso
	 * a média calculada seja maior ou igual a 6, o algoritmo deverá exibir a
	 * mensagem de aluno aprovado. Caso a média seja abaixo de 5, o algoritmo deverá
	 * exibir a mensagem de aluno reprovado. Caso a média esteja entre 5 e 6, o
	 * algoritmo deverá exibir que o aluno está de recuperação e solicitar a nota da
	 * atividade de recuperação, calcular uma nova média entre a média inicial e a
	 * nota de recuperação e caso esta nova média seja abaixo de 6 informar que o
	 * aluno está reprovado, caso contrário, informar que o aluno está aprovado por
	 * recuperação.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double n1, n2, n3, m, recuperacao;
		String msg;

		// Entrada de dados em Swing;
		n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Olá, digite a primeira nota", "Primeira Nota",
				JOptionPane.QUESTION_MESSAGE));

		n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora, digite a segunda nota", "Segunda Nota",
				JOptionPane.QUESTION_MESSAGE));

		n3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Por último, digite a terceira nota", "Terceira Nota",
				JOptionPane.QUESTION_MESSAGE));

		// Decisões;
		if (n1 < 0 || n1 > 10 && n2 < 0 || n2 > 10 && n3 < 0 || n3 > 10) { // NÚMEROS MENORES QUE 0 OU MAIORES QUE 10 SÃO BARRADOS;
			JOptionPane.showMessageDialog(null, "Números inválidos", "Erro", JOptionPane.WARNING_MESSAGE);
		} else {
			m = (n1 + n2 + n3) / 3; // CÁLCULO DA MÉDIA;

			if (m >= 6) { // APROVADO;
				msg = "Aprovado";
				JOptionPane.showMessageDialog(null, "Sua média foi " + m + " você está " + msg);

			} else if (m < 5) { // REPROVADO;
				msg = "Reprovado";
				JOptionPane.showMessageDialog(null, "Sua média foi " + m + " você está " + msg, "",
						JOptionPane.WARNING_MESSAGE);

			} else { // EM RECUPERAÇÃO;
				msg = "Em Recuperação";
				JOptionPane.showMessageDialog(null, "Sua média foi " + m + " você está " + msg, "",
						JOptionPane.WARNING_MESSAGE);

				// Entrada para a nota da recuperação;
				recuperacao = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Por favor, digite sua nota da atividade de recuperação",
								"Atividade de Recuperação", JOptionPane.QUESTION_MESSAGE));

				// Segunda Média;
				m = (m + recuperacao) / 2;

				if (m < 6) { // SE A NOTA FOR MENOR QUE 6, REPROVADO
					msg = "Reprovado";
					JOptionPane.showMessageDialog(null, "Sua média final foi " + m + " você está " + msg, "",
							JOptionPane.WARNING_MESSAGE);

				} else { // SE A NOTA FOR IGUAL OU MAIOR QUE 6, APROVADO;
					msg = "Aprovado";
					JOptionPane.showMessageDialog(null, "Sua média foi " + m + " você está " + msg);
				}

			}
		}
	}
}