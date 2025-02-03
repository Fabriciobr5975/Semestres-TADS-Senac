package biblioteca;

import java.util.Calendar;

public class TestaLivro {
	public static void main(String[] args) {
		// Criando um novo livro;
		Livro livro = new Livro();
		
		// Adicionando os dados ao objeto livro;
		livro.setIsbn("1111111");
		// Criando um objeto do tipo Calendar;
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(Calendar.DAY_OF_MONTH, 1);
		dataLancamento.set(Calendar.MONTH, 0);
		dataLancamento.set(Calendar.YEAR, 2000);
		livro.setDataLancamento(dataLancamento);
		livro.setTitulo("Men Livro");
		livro.setEdicao(1);
		livro.setNumeroPaginas(200);
	
		// Criando um novo autor;
		Autor autor = new Autor();
		autor.setGeneroLiterario("Romance");
		autor.setNome("Machado de Assis");
		livro.setAutor(autor);
		
		// Imprimir os dados;
		System.out.println(livro.getTitulo());
		System.out.println(livro.getAutor().getNome());
		System.out.println(livro.getDataLancFmt());
		livro.getAutor().setNome("Fenando Pessoa");
	}
}