package estruturafila;

/**
 * Classe para a criação das senhas para a atendimento de um laboratório de
 * coleta de sangue
 *
 * @author Fabrício de Araújo Santana
 */
public class Senha {

    // Atributos dos objetos;
    private String tipo;
    private int numero;
    // Atributo da classe;
    private static int totalSenhas = 0;

    /**
     * Método construtor para iniciar uma nova senha com o tipo e um número
     * 
     * @param tipo - Recebe o tipo da senha, se ela é prioritária ou normal
     */
    public Senha(String tipo) {
        this.tipo = tipo;
        this.numero = totalSenhas + 1;
        totalSenhas++;
    }

    /**
     * Método para pegar o tipo da senha atual
     *  
     * @return Retorna o tipo da senha
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para pegar o número da senha atual
     * 
     * @return Retorna o número da senha
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para pegar o total de senhas criadas
     * 
     * @return Retorna o total de senhas criadas
     */
    public static int getTotalSenhas() {
        return totalSenhas;
    }

    /**
     * Método para formatar a impressão das Senhas
     *
     * @return Retorna os elementos formatados para ser impresso
     */
    @Override
    public String toString() {
        return String.format("Senha: %s%04d", this.tipo, this.numero);
    }
}
