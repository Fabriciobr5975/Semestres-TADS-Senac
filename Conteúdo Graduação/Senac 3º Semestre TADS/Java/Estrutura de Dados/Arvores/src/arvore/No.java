package arvore;

/**
 * Classe Nó
 */
public class No {

    // Informação tipo inteiro; 
    private int info;
    // Filho à esquerda;
    private No left;
    // Filho à direita;
    private No right;
    
    /**
     * Método construtor para inicializar os atributos da classe
     * 
     * @param info - Recebe a informação
     */
    public No(int info){
        // Inicializa a informação com o parâmetro recebido;
        this.info = info;
        // Inicializa o filho à esquerda como vazio;
        this.left = null;
        // Inicializa o filho à direita como vazio;
        this.right = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getLeft() {
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public No getRight() {
        return right;
    }

    public void setRight(No right) {
        this.right = right;
    }
}
