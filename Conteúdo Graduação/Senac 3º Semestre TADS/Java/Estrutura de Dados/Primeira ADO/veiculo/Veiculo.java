package veiculo;

/**
 * @author Fabrício de Araújo Santana
 */
public class Veiculo {

    // Atributos dos objetos;
    private String marca;
    private String nome;
    private String versao;
    private String cor;
    private String portas;
    private int anoFabricacao;
    private String motor;
    private double preco;
    // Atributo da classe;
    private static int quantidadeDeVeiculos = 0;

    /**
     * Construtor da classe Veiculo
     *
     * @param marca - Recebe o nome da marca do veículo
     * @param nome - Recebe o nome do veículo
     * @param versao - - Recebe a versão do veículo
     * @param cor - Recebe a cor do veículo
     * @param portas - Recebe a quantidade de portas do veículo
     * @param motor - Recebe a cilindrada do motor. Ex: 1.0, 1.4, 2.0 ...
     * @param preco - Recebe o preço do veículo
     */
    public Veiculo(String marca, String nome, String versao, String cor, String portas, int anoFabricacao, String motor, double preco) {
        this.marca = marca;
        this.nome = nome;
        this.versao = versao;
        this.cor = cor;
        this.portas = portas;
        this.anoFabricacao = anoFabricacao;
        this.motor = motor;
        quantidadeDeVeiculos++;
        this.preco = preco;
    }

    /**
     * Método estático que retorná uma variável que conta todas as intanciações
     * da classe
     *
     * @return Retorna a variável que guarda o total de instanciação
     */
    public static int getQuantidadeDeVeiculos() {
        return quantidadeDeVeiculos;
    }

    /**
     * Método para pegar a marca do veículo
     *
     * @return Retorna a marca salva
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para mudar a marca do veículo
     *
     * @param marca - Recebe a nossa marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para pegar o nome do veículo
     *
     * @return Retorna o nome salvo
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para mudar o nome do veículo
     *
     * @param nome - Recebe o novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para pegar a versão do veículo
     *
     * @return Retorna a versão salva
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Método para mudar a versão do veículo
     *
     * @param versao - Recebe a nova versão
     */
    public void setVersao(String versao) {
        this.versao = versao;
    }

    /**
     * Método para pegar a cor do veículo
     *
     * @return Retorna a cor salva
     */
    public String getCor() {
        return cor;
    }

    /**
     * Método para mudar a cor do veículo
     *
     * @param cor - Recebe a nova cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Método para pegar a quantidade de portas do veículo
     *
     * @return Retorna a quantidade de portas salva
     */
    public String getPortas() {
        return portas;
    }

    /**
     * Método para mudar a quantidade de portas no veículo
     *
     * @param portas - Recebe a nova quantidade de portas
     */
    public void setPortas(String portas) {
        this.portas = portas;
    }

    /**
     * Método para pegar o ano de fabricação do veículo
     *
     * @return Retorna o ano de fabricação salvo
     */
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * Método para mudar o ano de fabricação do veículo
     *
     * @param anoFabricacao - Recebe um novo ano de fabricação
     */
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    /**
     * Método para pegar a cilindrada do motor do veículo
     *
     * @return Retorna a cilindrada do motor salva
     */
    public String getMotor() {
        return motor;
    }

    /**
     * Método para mudar a cilindrada do motor do veículo
     *
     * @param motor - Recebe a nova cilindrada
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * Método para pegar o preço do veículo
     *
     * @return Retorna a o preço salvo
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método para mudar o preço do veículo
     *
     * @param preco - Recebe o novo preço
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método toString para a impressa dos objetos Veiculo
     *
     * @return Retorna um conjunto de caracteres para a impressão dos objetos
     */
    @Override
    public String toString() {
        return "Marca: " + marca + "  " + "Nome: " + nome + "  " + "Versao: " + versao + " " + "Cor: " + cor + "  " + "Quantidade de Portas: " + portas + "  " + "Motor: " + motor + "  " + String.format("Preço: R$%8.3f", preco);
    }
}