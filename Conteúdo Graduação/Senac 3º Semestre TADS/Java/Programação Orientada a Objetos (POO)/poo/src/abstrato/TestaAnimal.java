package abstrato;

import javax.swing.JOptionPane;

public class TestaAnimal {

	public static void main(String[] args) {

		Cachorro rex = new Cachorro();
		Animal [] animais = new Animal[5];
		for(int i = 0; i < animais.length; i++) {
			animais[i] = new Cachorro();
		}
		
		
		System.out.println(rex.getTipoAnimal().descricao);
		
		JOptionPane.showInputDialog(null, "Escolha um tipo:", null, 0, null, TipoAnimal.values(), null);

	}

}
