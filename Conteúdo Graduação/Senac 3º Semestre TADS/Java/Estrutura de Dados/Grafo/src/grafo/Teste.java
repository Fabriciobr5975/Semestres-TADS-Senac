package grafo;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		// Instanciando um novo objeto do tipo Grafo
		Grafo<String> grafo = new Grafo<String>();

		// Adicionando na vertice (elementos ou nó) as ruas

		grafo.adicionaVertice("A");
		grafo.adicionaVertice("B");
		grafo.adicionaVertice("C");
		grafo.adicionaVertice("D");
		grafo.adicionaVertice("E");
		grafo.adicionaVertice("F");
		grafo.adicionaVertice("G");
		grafo.adicionaVertice("H");
		grafo.adicionaVertice("I");
		grafo.adicionaVertice("J");
		grafo.adicionaVertice("K");
		grafo.adicionaVertice("L");

		/**
		 * Associando as vertices (Rua) as suas arestas, ou seja o elo de ligação.
		 *
		 * Obs: O primeiro parâmetro recebe a distância (Peso) entre as ruas, o segundo
		 * parâmetro recebe a rua inicial, o terceiro parâmetro recebe a rua de destino,
		 * e por último temos a rua que será está sendo ligada
		 */
		grafo.adicionaAresta(30.0, "A", "B", "A");
		grafo.adicionaAresta(15.0, "A", "E", "A");
		grafo.adicionaAresta(35.0, "A", "I", "A");
		grafo.adicionaAresta(40.0, "B", "C", "B");
		grafo.adicionaAresta(30.0, "B", "A", "B");
		grafo.adicionaAresta(40.0, "C", "B", "C");
		grafo.adicionaAresta(20.0, "C", "D", "C");
		grafo.adicionaAresta(15.0, "C", "H", "C");
		grafo.adicionaAresta(05.0, "C", "G", "C");
		grafo.adicionaAresta(20.0, "D", "C", "D");
		grafo.adicionaAresta(25.0, "D", "L", "D");
		grafo.adicionaAresta(15.0, "E", "A", "E");
		grafo.adicionaAresta(20.0, "E", "F", "E");
		grafo.adicionaAresta(20.0, "F", "E", "F");
		grafo.adicionaAresta(05.0, "F", "G", "F");
		grafo.adicionaAresta(20.0, "F", "J", "F");
		grafo.adicionaAresta(20.0, "F", "K", "F");
		grafo.adicionaAresta(05.0, "G", "F", "G");
		grafo.adicionaAresta(05.0, "G", "C", "G");
		grafo.adicionaAresta(15.0, "H", "C", "H");
		grafo.adicionaAresta(15.0, "H", "L", "H");
		grafo.adicionaAresta(35.0, "I", "A", "I");
		grafo.adicionaAresta(15.0, "I", "K", "I");
		grafo.adicionaAresta(15.0, "K", "I", "K");
		grafo.adicionaAresta(20.0, "K", "F", "K");
		grafo.adicionaAresta(15.0, "K", "J", "K");
		grafo.adicionaAresta(15.0, "J", "K", "J");
		grafo.adicionaAresta(20.0, "J", "F", "J");
		grafo.adicionaAresta(35.0, "J", "L", "J");
		grafo.adicionaAresta(35.0, "L", "J", "L");
		grafo.adicionaAresta(15.0, "L", "H", "L");
		grafo.adicionaAresta(25.0, "L", "D", "L");

		do {
			// Entrada dos dados;
			String dadoInicio = JOptionPane.showInputDialog(null, "Digite o ponto de início:", "Origem",
					JOptionPane.INFORMATION_MESSAGE).toUpperCase();
			String dadoFinal = JOptionPane
					.showInputDialog(null, "Digite o ponto final:", "Destino", JOptionPane.INFORMATION_MESSAGE)
					.toUpperCase();

			// Imprimir o caminho mais curto;
			grafo.imprimirCaminhoMaisCurto(dadoInicio, dadoFinal);
		} while ((JOptionPane.showConfirmDialog(null, "Deseja calcular outra trajetória?")) == 0);
	}

}
