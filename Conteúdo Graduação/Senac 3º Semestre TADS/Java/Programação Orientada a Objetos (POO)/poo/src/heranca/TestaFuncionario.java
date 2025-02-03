package heranca;

import java.util.ArrayList;
import java.util.List;

public class TestaFuncionario {
	public static void main(String[] args) {
		Contador contador = new Contador();
		Engenheiro engenheiro = new Engenheiro();
		
		Funcionario f1 = new Funcionario();
		Funcionario f3 = new Funcionario();
		f1.setMatricula("1234");
		f3.setMatricula("1234");
		// System.out.println(f1.equals(f3));
		
		List<Funcionario> funcs = new ArrayList<Funcionario>();
		Contador c1 = new Contador();
		c1.setMatricula("5678");
		Contador c2 = new Contador();
		c2.setMatricula("8910");
		Contador c3 = new Contador();
		c3.setMatricula("1123");
		funcs.add(c1);
		funcs.add(c2);
		funcs.add(c3);
		Contador c4 = new Contador();
		c4.setMatricula("444");
		c4.setNumCrc("5678");
		Funcionario f = c4;
		System.out.println(funcs.contains(c4));
		System.out.println(funcs.contains(f));
	}
}