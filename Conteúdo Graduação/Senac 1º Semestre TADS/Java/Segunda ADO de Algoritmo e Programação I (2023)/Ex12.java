import javax.swing.JOptionPane;

public class Ex12 {

	/*
	 * 12. Crie um algoritmo que receba a hora de início e a hora de término de um
	 * jogo (cada hora é composta por duas variáveis hora e minuto). Calcule e
	 * mostre a duração do jogo (horas e minutos), sabendo-se que o tempo máximo da
	 * duração do jogo é de 24 horas e que ele pode iniciar-se em um dia e terminar
	 * no dia seguinte.
	 */

	public static void main(String[] args) {
		// Variáveis;
		double horaInicio, minutoI, horaTermino, minutoT, hora, minuto;

		// Entrada de dados em Swign;
		horaInicio = Double.parseDouble(JOptionPane.showInputDialog(null, "Olá, digite a hora de início do jogo",
				"Hora de Inicío", JOptionPane.QUESTION_MESSAGE));

		minutoI = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora, digite os minutos", "Hora de Inicío",
				JOptionPane.QUESTION_MESSAGE));

		horaTermino = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a hora de término do jogo",
				"Término do jogo", JOptionPane.QUESTION_MESSAGE));

		minutoT = Double.parseDouble(JOptionPane.showInputDialog(null, "Agora, digite os minutos", "Hora de Inicío",
				JOptionPane.QUESTION_MESSAGE));

		// Decisões;
		if (horaInicio == horaTermino && minutoI == minutoT) {
			hora = 24;
			minuto = 0;

		} else if (horaInicio > horaTermino || (horaInicio == horaTermino && minutoI > minutoT)) {
			hora = 24 - horaInicio + horaTermino;
			minuto = 60 - minutoI + minutoT;

			if (minuto >= 60) {
				hora++;
				minuto -= 60;
			}
		} else {
			hora = horaTermino - horaInicio;
			minuto = minutoT - minutoI;

			if (minuto < 0) {
				hora--;
				minuto += 60;
			}
		}
		JOptionPane.showMessageDialog(null, "O jogo durou " + hora + " horas e " + minuto + " minutos");
	}
}