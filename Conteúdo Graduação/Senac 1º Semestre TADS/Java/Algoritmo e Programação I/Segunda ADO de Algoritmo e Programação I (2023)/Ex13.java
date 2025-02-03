import javax.swing.JOptionPane;

public class Ex13 {

	/*
	 * 13. Crie um algoritmo que receba um ano e informe se este ano é bissexto ou
	 * não. Caso não seja um ano bissexto, o algoritmo deverá informar qual o
	 * próximo ano bissexto depois do ano informado.
	 */

	public static void main(String[] args) {
		// Variáveis;
		int ano, proxAno1, proxAno2, proxAno3, proxAno4, proxAno5, proxAno6, proxAno7;

		// Entrada de dados em Swing;
		ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Olá, digite um ano" + ", por favor", "Ano",
				JOptionPane.QUESTION_MESSAGE));

		// Decisões;
		if (ano % 400 == 0 || ano % 4 == 0 && ano % 100 != 0) {
			JOptionPane.showMessageDialog(null, ano + " é um ano bissexto");

		} else {
			JOptionPane.showMessageDialog(null, ano + " não é um ano bissexto");

			// Calculo para saber em que ano será bissexto;
			proxAno1 = ano + 3; // EX: 2013 + 3 = 2016 (ANO BISSEXTO);
			proxAno2 = ano + 2; // EX: 2014 + 2 = 2016 (ANO BISSEXTO);
			proxAno3 = ano + 1; // EX: 2015 + 1 = 2016 (ANO BISSEXTO);

			/*
			 * Exceções: De 4 em 4 anos temos um ano bissexto, porém, seguindo a regra para
			 * um ano ser bissexto, teremos um intervalo de 8 anos em alguns finais de
			 * 
			 * século. Por isso criei essas 4 contas adicionais;
			 */

			proxAno4 = ano + 7; // PRIMEIRA EXCEÇÃO EX: 1897 + 7 = 1904 (ANO BISSEXTO); //
			proxAno5 = ano + 6; // SEGUNDA EXCEÇÃO EX: 1898 + 6 = 1904 (ANO BISSEXTO);
			proxAno6 = ano + 5; // TERCEIRA EXCEÇÃO EX: 1899 + 5 = 1904 (ANO BISSEXTO);
			proxAno7 = ano + 4; // ÚLTIMA EXCEÇÃO EX: 1900 + 4 = 1904 (ANO BISSEXTO);

			if (proxAno1 % 400 == 0 || proxAno1 % 4 == 0 && proxAno1 % 100 != 0) { // ANO + 3;
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno1);

			} else if (proxAno2 % 400 == 0 || proxAno2 % 4 == 0 && proxAno2 % 100 != 0) { // ANO + 2;
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno2);

			} else if (proxAno3 % 400 == 0 || proxAno3 % 4 == 0 && proxAno3 % 100 != 0) { // ANO + 1;
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno3);

			} else if (proxAno4 % 400 == 0 || proxAno4 % 4 == 0 && proxAno4 % 100 != 0) { // PRIMERIA EXCEÇÃO:(ANO + 7);
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno4);

			} else if (proxAno5 % 400 == 0 || proxAno5 % 4 == 0 && proxAno5 % 100 != 0) { // SEGUNDA EXCEÇÃO:(ANO + 6);
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno5);

			} else if (proxAno6 % 400 == 0 || proxAno6 % 4 == 0 && proxAno6 % 100 != 0) { // TERCEIRA EXCEÇÃO:(ANO + 5);
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno6);

			} else if (proxAno7 % 400 == 0 || proxAno7 % 4 == 0 && proxAno7 % 100 != 0) { // ÚLTIMA EXCEÇÃO:(ANO + 4);
				JOptionPane.showMessageDialog(null, "O próximo ano bissexto é " + proxAno7);

			}

		}
	}

}