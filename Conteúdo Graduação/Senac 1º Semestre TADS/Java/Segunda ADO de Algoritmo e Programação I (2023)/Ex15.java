import javax.swing.JOptionPane;

public class Ex15 {

	/*
	 * 5. Em uma escola, os alunos ganham premiações de acordo com o seu desempenho
	 * ao longo do ano letivo. Baseado na tabela, crie umalgoritmo que receba 4
	 * notas de um aluno entre 0 e 100, quantidade de aulas dadas, quantidade de
	 * presenças e informe qual o prêmio a ser recebido pelo aluno. Caso o aluno não
	 * esteja em nenhuma das condições da tabela, o algoritmo deve informar que não
	 * há prêmios.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double n1, n2, n3, n4, qtdAulas, qtdPresenca, m;
		String premio;

		// Entrada de dados em Swing,(ENTRADA DAS NOTAS);
		n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Olá, digite a primeira nota, (de 0 a 100)",
				"Primeira Nota", JOptionPane.QUESTION_MESSAGE));

		n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora, digite a segunda nota, (de 0 a 100)",
				"Segunda Nota", JOptionPane.QUESTION_MESSAGE));

		n3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a terceira nota, (de 0 a 100)",
				"Terceira Nota", JOptionPane.QUESTION_MESSAGE));

		n4 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a última nota, (de 0 a 100)", "Quarta Nota",
				JOptionPane.QUESTION_MESSAGE));

		qtdAulas = Double.parseDouble(JOptionPane.showInputDialog(null, "Por favor, digite a quantidade de aulas dadas",
				"Quantidade de Aulas", JOptionPane.QUESTION_MESSAGE));

		qtdPresenca = Double.parseDouble(JOptionPane.showInputDialog(null,
				"Por último, digite a sua quantidade de presenças", "Presenças", JOptionPane.QUESTION_MESSAGE));

		// Decisões;
		if (n1 < 0 || n1 > 100 || n2 < 0 || n2 > 100 || n3 < 0 || n3 > 100 || n4 < 0 || n4 > 100) {
			JOptionPane.showMessageDialog(null, "Números inválidos", "Erro", JOptionPane.WARNING_MESSAGE);

		} else if (qtdAulas < 0 || qtdPresenca < 0) {
			JOptionPane.showMessageDialog(null, "Números inválidos", "Erro", JOptionPane.WARNING_MESSAGE);
		
		} else {
			m = (n1 + n2 + n3 + n4) / 4;
			qtdPresenca = (qtdPresenca * 100) / qtdAulas;
			JOptionPane.showMessageDialog(null,
					"Sua média foi " + m + " e a quantidade de presença foi " + qtdPresenca);

			if (m > 80 && qtdPresenca == 100) {
				premio = "Excursão";
				JOptionPane.showMessageDialog(null, "Seu prêmio foi " + premio);

			} else if (m > 80 || qtdPresenca == 100) {
				premio = "Camiseta";
				JOptionPane.showMessageDialog(null, "Seu prêmio foi " + premio);
				
			} else if (m >= 70 && m <= 80 && qtdPresenca == 90) {
				premio = "Squeeze";
				JOptionPane.showMessageDialog(null, "Seu prêmio foi " + premio);
			
			} else if (m >= 70 && m <= 80 || qtdPresenca == 90) {
				premio = "Caneta Personalizada";
				JOptionPane.showMessageDialog(null, "Seu prêmio foi " + premio);
			
			} else {
				JOptionPane.showMessageDialog(null, "Não teve prêmios");
			}

		}
		
	}
}