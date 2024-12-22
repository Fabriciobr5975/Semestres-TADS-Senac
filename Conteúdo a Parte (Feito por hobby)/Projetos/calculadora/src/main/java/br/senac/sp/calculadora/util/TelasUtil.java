package br.senac.sp.calculadora.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Classe com métodos utilitários para a telas. Esses métodos contém elementos
 * que os frames podem receber e que no geral serão aplicados a todos. Um
 * exemplo é o ícone do frame, onde basicamente todos os frames receberam o
 * mesmo ícone, mas isso não tira a possibilidade de algum frame receber outro
 * ícone.
 * 
 * @author Fabrício de Araújo Santana
 */
@SuppressWarnings("serial")
public class TelasUtil extends JFrame {

	/**
	 * Método que recebe o nome do arquivo da imagem, e o tipo da imagem, ou seja
	 * sua extensão. Como a imagem sempre vendo do mesmo diretório, apenas é
	 * necessário o nome do arquivo e a sua extensão. Depois, ele fará uma
	 * verificação se a extensão passada existe, caso essa imagem exista e o método
	 * consiga pegá-la, ele retorna imagem em um objeto do tipo
	 * <code>ImageIcon</code>.
	 * 
	 * @param arquivo     - Recebe o nome do arquivo da imagem sem extensão
	 * 
	 * @param tipoArquivo - Recebe o tipo de extensão do arquivo, exemplo: <i>"jpg",
	 *                    "jpeg", "pgn"</i>
	 * 
	 * @return Retorna um <code>ImageIcon</code> caso o método consiga encontrar a
	 *         image e retorná-la para os Frames que chamam esse método
	 * 
	 * @throws FileNotFoundException    - Caso a imagem passe pela validação das
	 *                                  extensões, mas ainda sim a imagem não seja
	 *                                  encontrada
	 * @throws IllegalArgumentException - Caso a extensão passada não exista, ou
	 *                                  esteja escrita de forma errada
	 * 
	 * @throws Exception                - Caso alguma outra exceção aconteça no meio
	 *                                  do caminho
	 */
	public static ImageIcon receberImageIconDoJFrame(String arquivo, String tipoArquivo)
			throws FileNotFoundException, IllegalArgumentException, Exception {
		// Variável para guardar a validação do tipo do arquivo (extensão)
		boolean isExtensaoValida = true;

		// Verificando se o nome passado da extensão existe
		for (String extensao : ImageIO.getReaderFileSuffixes()) {
			if (extensao.equals(tipoArquivo)) {
				isExtensaoValida = true;
				break;
			}
		}

		// Se a extensão for false, ou seja, não existir
		if (!isExtensaoValida) {
			throw new IllegalArgumentException(
					"A extensão " + tipoArquivo + " não é válida. Utilize uma extensão válida.");
		}

		// Diretório do imagem (URL)
		String url = String.format("/imagens/%s.%s", arquivo, tipoArquivo);
		// Pegando o arquivo da imagem
		URL imageURL = TelasUtil.class.getResource(url);

		// Se a imagem não for nula, então retorna um novo ImageIcon com a imageURL
		if (imageURL != null) {
			return new ImageIcon(imageURL);
		} else {
			throw new FileNotFoundException("Não foi possível carregar o imagem do ícone");
		}
	}

	/**
	 * Método que internamente recebe uma URL completa, com a pasta, o arquivo e sua
	 * extensão. Esse método é usada para colocar a imagem principal, já que ele
	 * deverá ser fixa. Este método também retorna uma <code>ImageIcon</code> que
	 * será usada no icon do Frame.
	 * 
	 * @return Retorna um <code>ImageIcon</code> caso o método consiga encontrar a
	 *         imagem e retorná-la para os Frames que chamam esse método
	 * 
	 * @throws FileNotFoundException    - Caso a imagem não seja encontrada
	 * 
	 * @throws IllegalArgumentException - Caso a URL passada não tenha a pasta que
	 *                                  deverá conter todos as imagens do sistema
	 * 
	 * @throws Exception                - Caso alguma outra exceção aconteça no meio
	 *                                  do caminho
	 */
	public static ImageIcon receberImageIconDoJFrame()
			throws FileNotFoundException, IllegalArgumentException, Exception {
		// Diretório do imagem (URL)
		String url = "/imagens/icone_calculadora.jpg";

		if (!url.contains("/imagens/")) {
			throw new IllegalArgumentException(
					"A URL da imagem não tem a pasta /imagens/, por favor coloque a pasta e o arquivo com a extensão");
		}

		// Pegando o arquivo da imagem
		URL imageURL = TelasUtil.class.getResource(url);

		// Se a imagem não for nula, então retorna um novo ImageIcon com a imageURL
		if (imageURL != null) {
			return new ImageIcon(imageURL);
		} else {
			throw new FileNotFoundException("Não foi possível carregar o imagem do ícone");
		}
	}

	/**
	 * Método para centralizar o frame na tela do dispositivo, pegando o tamanho e
	 * resolução da tela e realizando o ajuste
	 * 
	 * @param frame - Recebe o frame que está sendo usado para deixá-lo no centro da
	 *              tela
	 */
	public static void centralizarJFrame(JFrame frame) {
		// Pegando o tamanho da tela do dispositivo
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// Pegando o tamanho do frame
		Dimension janela = frame.getSize();

		// Ajustando a largura do frame para se ajustar na tela
		if (janela.width > screen.width) {
			janela.setSize(janela.width, screen.width);
		}

		// Ajustando a altura do frame para se ajustar na tela
		if (janela.height > screen.height) {
			janela.setSize(janela.height, screen.height);
		}

		/*
		 * Colocando a posição para que o frame fique centralizado no centro da tela do
		 * dispositivo
		 */
		frame.setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
	}
}
