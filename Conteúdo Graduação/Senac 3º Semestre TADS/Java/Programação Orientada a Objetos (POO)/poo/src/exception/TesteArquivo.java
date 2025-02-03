package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TesteArquivo {
	public static void main(String[] args) {

		try {
			System.out.println(ArquivosUtil.lerArquivo("C:\\teste\\arquivo.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// Aqui trata IOException
			System.out.println("Caiu na IO");

		} catch (Exception e) {
			// Aqui trata Exceptions no geral

		} finally {
			System.out.println("Passou pelo Finally");
		}
	}
}