package biblioteca;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Livro {
	private String isbn;
	private String titulo;
	private Calendar dataLancamento;
	private int edicao;
	private int numeroPaginas;
	private Autor autor;
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public String getDataLancFmt() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MMMM/yyyy");
		String dataForm = formatador.format(dataLancamento.getTime());
		
		return dataForm;
	}
}