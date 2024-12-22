package atividades.imc;

/**
 * Fabrício de Araújo Santana
 */
public class Usuario {
	// Atributos dos objetos;
	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private String sexo;
	// Atributos da classe;
	private static final String SEXO_MASCULINO = "Masculino";
	private static final String SEXO_FEMININO = "Feminino";
	private static int quantidadeUsuario = 0;

	/**
	 * Método construtor para criar um objeto do tipo Usuario
	 * 
	 * @param nome   - Recebe um nome
	 * @param idade  - Recebe a idade
	 * @param altura - Recebe a altura
	 * @param peso   - Recebe o peso
	 * @param sexo   - Recebe se a pessoa é homem, mulher ou não definido
	 */
	public Usuario(String nome, int idade, double altura, double peso, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.sexo = verificarSexoUsuario(sexo);
		quantidadeUsuario++;
	}

	/**
	 * Método privado para verificar se a entrada do usuário referente ao sexo é
	 * válida ou não, caso se valida é atribuido ou masculino, no caso da pessoa ser
	 * homem, ou feminino no caso da pesso ser mhuler. Porém se a pessoa colocar
	 * outro dado será atribuido um sexo padrão, no caso "Sexo não definido".
	 * 
	 * @param sexo - Recebe a entrada referente ao sexo no método contrutor
	 * 
	 * @return Retorna o sexo do usuário, caso ele tenha colocado a informação
	 *         certa, caso contrário retorna um sexo padrão
	 */
	private String verificarSexoUsuario(String sexo) {
		if (sexo.equalsIgnoreCase("Homem")) {
			return SEXO_MASCULINO;

		} else if (sexo.equalsIgnoreCase("Mulher")) {
			return SEXO_FEMININO;

		} else {
			return "Sexo não definido";
		}
	}

	/**
	 * Método para pegar o total de instâncias criadas da classe Usuario
	 * 
	 * @return Retorna um valor numérico do tipo inteiro com o total de objetos
	 *         criados da classe Usuario
	 */
	public static int getQuantidadeUsuario() {
		return quantidadeUsuario;
	}

	/**
	 * Método para retornar o nome do usuário
	 * 
	 * @return Retorna o nome salvo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para mudar o nome do usuário
	 * 
	 * @param nome - Recebe um novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para retornar a idade do usuário
	 * 
	 * @return Retorna a idade salva
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Método para mudar a idade do usuário
	 * 
	 * @param idade - Recebe uma nova idade
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * Método para retornar a altura do usuário
	 * 
	 * @return Retorna a altura salva
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Método para mudar a altura do usuário
	 * 
	 * @param altura - Recebe uma nova altura
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * Método para retornar o peso do usuário
	 * 
	 * @return Retorna o peso salvo
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Método para mudar o peso do usuário
	 * 
	 * @param peso - Recebe um novo peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Método para retornar o sexo do usuário
	 * 
	 * @return Retorna o sexo salvo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Método para mudar o sexo do usuário
	 * 
	 * @param sexo - Recebe um novo sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Método para formatar a impressão dos objetos Usuario
	 */
	@Override
	public String toString() {
		return String.format("Nome: %s%nIdade: %d%nAltura: %5.2f%nPeso: %5.2f% KgnSexo: %s%n", this.nome, this.idade,
				this.altura, this.peso, this.sexo);
	}
}