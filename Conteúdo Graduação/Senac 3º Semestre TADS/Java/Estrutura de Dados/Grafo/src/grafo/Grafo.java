package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

/**
 * Classe para a manipulação do grafo, com métodos para juntar as vértices,
 * realizar as buscas e imprimir os dados obtidos
 *
 * @param <TIPO> Recebe um tipo genérico
 */
public class Grafo<TIPO> {

	// Atributos;
	private ArrayList<Vertice<TIPO>> vertices;
	private ArrayList<Aresta<TIPO>> arestas;

	/**
	 * Construtor padrão. Para iniciailizar os ArrayList de vertices e arestas;
	 */
	public Grafo() {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}

	/**
	 * Método para adicionar novas Vertices
	 *
	 * @param dado Recebe o dado que será adicionado;
	 */
	public void adicionaVertice(TIPO dado) {
		// Criando um novo objeto do tipo Vértice;
		Vertice<TIPO> novoVertice = new Vertice<>(dado);

		// Adicionando o dado dentro da vértice;
		vertices.add(novoVertice);
	}

	/**
	 * Método para adicionar as arestas nas vértices;
	 *
	 * @param tamanho    Recebe o peso
	 * @param dadoInicio Recebe o dado inicial
	 * @param dadoFim    Recebe o dado do fim
	 * @param nome       Recebe o nome do vértice, no caso o mesmo nome atribuido a
	 *                   dado inicial é usado no nome
	 */
	public void adicionaAresta(double tamanho, TIPO dadoInicio, TIPO dadoFim, String nome) {
		// Pegando as vértices de inicio e fim;
		Vertice<TIPO> inicio = getVertice(dadoInicio);
		Vertice<TIPO> fim = getVertice(dadoFim);

		// Pegando a aresta, com base nas arestas e no tamanho(peso) passado;
		Aresta<TIPO> aresta = new Aresta<>(tamanho, inicio, fim, nome);

		// Adicionando as arestas nas vértices Vertices;
		inicio.adicionarArestaSaida(aresta);
		fim.adicionarArestaEntrada(aresta);

		// Adicionando a aresta criando ao ArrayList de Aresta
		arestas.add(aresta);
	}

	/**
	 * Método para pegar a vértice passa pelo usuário e verificar se o dado passado
	 * já foi criado
	 *
	 * @param dado Recebe o dado
	 * @return Retorna a vértice caso o valor passado seja igual a uma vertice, caso
	 *         contrário retorna null
	 */
	public Vertice<TIPO> getVertice(TIPO dado) {
		/*
		 * Loop para iterar sobre todas as vertices salvas dentro do ArrayList de
		 * vértices;
		 */
		for (Vertice<TIPO> vertice : vertices) {
			/*
			 * Se o dado da vértice for igual ao dado passado via parâmetro, então retorna a
			 * vértice;
			 */
			if (vertice.getDado().equals(dado)) {
				return vertice;
			}
		}
		// Caso contrário retorna null;
		return null;
	}

	/**
	 * Método para encontrar o melhor mais curto, ou seja o melhor caminho. É
	 * implementado o algoritmo de <Strong>Dijkstra</Strong>, para encontrar o
	 * caminho mais curto entre duas vértices. Utiliza uma fila (implementada como
	 * uma Queue) para explorar as vértices em ordem. Mantém mapas de distâncias e
	 * predecessores para cada vértice. Retorna uma lista de vértices representando
	 * o caminho mais curto entre os vértices de início e fim.
	 *
	 * @param dadoInicio Recebe o dado de inicio de inicio
	 * @param dadoFim    Recebe o dado de fim
	 *
	 * @return Retorna o caminho mais curto, caso contrário retorna null
	 */
	public ArrayList<Vertice<TIPO>> encontrarCaminhoMaisCurto(TIPO dadoInicio, TIPO dadoFim) {
		Vertice<TIPO> inicio = getVertice(dadoInicio);
		Vertice<TIPO> fim = getVertice(dadoFim);

		if (inicio == null || fim == null) {
			return null; // Vértice de início ou fim não encontrado
		}

		Map<Vertice<TIPO>, Double> distancias = new HashMap<>();
		Map<Vertice<TIPO>, Vertice<TIPO>> predecessores = new HashMap<>();
		PriorityQueue<Vertice<TIPO>> fila = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

		for (Vertice<TIPO> vertice : vertices) {
			distancias.put(vertice, Double.MAX_VALUE);
		}
		distancias.put(inicio, 0.0);
		fila.add(inicio);

		while (!fila.isEmpty()) {
			Vertice<TIPO> atual = fila.poll();

			if (atual.equals(fim)) {
				ArrayList<Vertice<TIPO>> caminho = new ArrayList<>();
				for (Vertice<TIPO> v = atual; v != null; v = predecessores.get(v)) {
					caminho.add(v);
				}
				Collections.reverse(caminho);
				return caminho;
			}

			for (Aresta<TIPO> aresta : atual.getArestasSaida()) {
				Vertice<TIPO> proximo = aresta.getFim();
				double novaDistancia = distancias.get(atual) + aresta.getTamanho();

				if (novaDistancia < distancias.get(proximo)) {
					distancias.put(proximo, novaDistancia);
					predecessores.put(proximo, atual);
					fila.add(proximo); // Adiciona o vértice novamente à fila
				}
			}
		}

		return null; // Se não encontrou caminho
	}

	/**
	 * Método imprimir: Chama o método encontrarCaminhoMaisCurto para obter o
	 * caminho mais curto entre os vértices de início e fim. Monta uma mensagem com
	 * os vértices do caminho (ou uma mensagem de erro, caso não haja caminho).
	 * Exibe a mensagem
	 *
	 * @param dadoInicio Recebe o dado de inicio de inicio
	 * @param dadoFim    Recebe o dado de fim
	 */
	public void imprimirCaminhoMaisCurto(TIPO dadoInicio, TIPO dadoFim) {
		ArrayList<Vertice<TIPO>> caminho = encontrarCaminhoMaisCurto(dadoInicio, dadoFim);
		StringBuilder mensagem = new StringBuilder();

		if (caminho == null) {
			mensagem.append("Não foi possível encontrar um caminho entre os vértices.");
		} else {
			mensagem.append("Caminho mais curto de: " + dadoInicio + " para: " + dadoFim + "\n");

			// Iterar na ordem correta
			String anterior = "Vazio";
			double distanciaTotal = 0;
			
			for (int i = 0; i < caminho.size() - 1; i++) {
				Vertice<TIPO> atual = caminho.get(i);
				Vertice<TIPO> proximo = caminho.get(i + 1);

				// Encontrar a aresta entre atual e proximo
				for (int j = 0; j < arestas.size(); j++) {
					Aresta<TIPO> aresta = arestas.get(j);
					if (aresta.getInicio().equals(atual) && aresta.getFim().equals(proximo)) {
						if (anterior.equals("Vazio")) {
							mensagem.append("Siga em " + aresta.getNome() + " por " + aresta.getTamanho() + " km.\n");
							distanciaTotal += aresta.getTamanho();
						} else if (aresta.getNome().equalsIgnoreCase(anterior)) {
							mensagem.append("Depois continue em " + aresta.getNome() + " por " + aresta.getTamanho()
									+ " km.\n");
							distanciaTotal += aresta.getTamanho();
						} else {
							mensagem.append(
									"Depois vire em " + aresta.getNome() + " por " + aresta.getTamanho() + " km.\n");
							distanciaTotal += aresta.getTamanho();
						}
						anterior = aresta.getNome();
						break; 
					}
				}
			}
			mensagem.append("Você chegou ao seu destino: " + dadoFim + " (" + distanciaTotal + " km no total).");
		}
		JOptionPane.showMessageDialog(null, mensagem, "Caminho mais Curto", JOptionPane.INFORMATION_MESSAGE);
	}
}
