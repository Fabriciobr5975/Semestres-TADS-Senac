import javax.swing.JOptionPane;

public class Ex8 {

	/*
	 * Crie um algoritmo que leia o salário de um funcionário, calcule e mostre seu
	 * novo salário acrescido de bonificação e auxílio escola: Salário Bonificação
	 * abaixo de R$ 2000,00 (inclusive) 10%, entre R$ 2000,00 e R$ 3000,00
	 * (inclusive) 8% e acima de R$ 3000,00 5%. Salário Auxílio Escola: abaixo de R$
	 * 2500,00 (inclusive) R$ 350,00 e acima de R$ 2500,00 R$ 300,00
	 */

	public static void main(String[] args) {
		// Variáveis;
		double salario, novoSalario, bonificacao, auxilioEscola;

		// Entrada de dados em Swing;
		salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Olá, informe o seu salário", "Salário",
				JOptionPane.QUESTION_MESSAGE));

		// Decisões
		if (salario < 0) { // SALÁRIO MENOR QUE 0 DARÁ ERRO;
			JOptionPane.showMessageDialog(null, "Informação Inválida", "Erro", JOptionPane.WARNING_MESSAGE);
		} else {

			if (salario <= 2000) { // SALÁRIO ABAIXO OU IGUAL R$ 2000, BONFICAÇÃO DE 10% SOBRE O SALÁRIO + R$ 350 DE AUXÍLIO ESCOLA;
				bonificacao = (salario * 10) / 100;
				auxilioEscola = 350;
				novoSalario = salario + bonificacao + auxilioEscola;
				JOptionPane.showMessageDialog(null, "O seu novo salário com a bonficação e o auxilio escola é de " + novoSalario + " Reais");

			} else if (salario > 2000 && salario <= 2500) { // SALÁRIO MAIOR QUE R$ 2000 E MENOR OU IGUAL A 2500, BONFICAÇÃO DE 8% SOBRE O SALÁRIO 
				bonificacao = (salario * 8) / 100;          //	+ R$ 350 DE AUXÍLIO ESCOLA;
				auxilioEscola = 350;
				novoSalario = salario + bonificacao + auxilioEscola;
				JOptionPane.showMessageDialog(null, "O seu novo salário com a bonficação e o auxilio escola é de " + novoSalario + " Reais");

			} else if (salario > 2500 && salario <= 3000) { // SALÁRIO MAIOR QUE R$ 2500 E MENOR QUE 3000, BONFICAÇÃO DE 8% SOBRE O SALÁRIO
				bonificacao = (salario * 8) / 100;			// + R$ 300 DE AUXÍLIO ESCOLA;
				auxilioEscola = 300;
				novoSalario = salario + bonificacao + auxilioEscola;
				JOptionPane.showMessageDialog(null, "O seu novo salário com a bonficação e o auxilio escola é de " + novoSalario + " Reais");

			} else if (salario > 3000) { // SALÁRIO MAIOR QUE R$ 3000, BONFICAÇÃO DE 5% SOBRE O SALÁRIO + 300 DE AUXÍLIO ESCOLA;
				bonificacao = (salario * 5) / 100;
				auxilioEscola = 300;
				novoSalario = salario + bonificacao + auxilioEscola;
				JOptionPane.showMessageDialog(null, "O seu novo salário com a bonficação e o auxilio escola é de " + novoSalario + " Reais");

			}
		}
	}
}