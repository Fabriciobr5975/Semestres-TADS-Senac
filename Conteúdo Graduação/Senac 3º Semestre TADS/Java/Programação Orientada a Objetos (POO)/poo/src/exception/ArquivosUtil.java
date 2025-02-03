package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArquivosUtil {
	public static String lerArquivo(String caminho) throws IOException {
		String conteudo = "";

		File f = new File(caminho);
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);

		String linha;

		while((linha = reader.readLine()) != null) {
			conteudo += linha + "\n";
		}
		reader.close();
		fr.close();
		return conteudo;
	}
}
