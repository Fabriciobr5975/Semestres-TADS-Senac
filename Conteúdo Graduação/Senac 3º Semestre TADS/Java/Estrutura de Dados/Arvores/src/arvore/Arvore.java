
package arvore;

/**
 * Classe para a árvore
 */
public class Arvore {

    // Nó pai, ou raíz;
    private No root = null;

    /**
     * Algortimo para inserir uma nova posição
     *
     * @param info - Recebe a informação
     * @param place - Recebe a posição
     */
    public void insert(int info, No place) {
        // Se o local está vazio, então a árvore está vazia;
        if (place == null) {
            // O root recebe o novo nó;
            root = new No(info);
            // Imprimi a informação inserida;
            System.out.print(" * " + info);

            // Senão, se a informação é menor do que a do local;
        } else if (info < place.getInfo()) {
            // Se o filho da esquerda está vazio;
            if (place.getLeft() == null) {
                // Então insere à esquerda o novo nó;
                place.setLeft(new No(info));
                // Imprime a informação inserida;
                System.out.print(" - " + info);

                // Senão, se não for vazio;
            } else {
                // Pula para o filho à esquerda usando a recursividade;
                insert(info, place.getLeft());
            }

            // Senão, se a informação é maior que a do local;
        } else if (info > place.getInfo()) {
            // Se o filho à direita está vazio;
            if (place.getRight() == null) {
                // Insere a informação em um novo nó à direita;
                place.setRight(new No(info));
                // Imprime a informação;
                System.out.print(" + " + info);

                // Senão, se o nó à direita não está vazio;
            } else {
                // Pula para o filho à direita usando a recursividade;
                insert(info, place.getRight());
            }
        }
    }

    /**
     * Algoritmo de navegação em pré ordem
     * 
     * @param place - Recebe a posição
     */
    public void preOrder(No place) {
        // Primeiro imprime a informação do nó;
        System.out.print(" " + place.getInfo());

        //  Se o filho à esquerda não está vazio;
        if (place.getLeft() != null) {
            // Pula para o filho à esquerda pela recursividade;
            preOrder(place.getLeft());
        }

        // Se o filho à direita não está vazio;
        if (place.getRight() != null) {
            // Pula para o filho à direita pela recursividade;
            preOrder(place.getRight());
        }
    }

    /**
     * Algoritmo de navegação em ordem
     * 
     * @param place - Recebe a posição 
     */
    public void inOrder(No place) {
        // Se o filho não está vazio
        if (place.getLeft() != null) {
            // Pula para o filho à esquerda pela recursividade;
            preOrder(place.getLeft());
        }

        // Depois imprime a informação do nó
        System.out.print(" " + place.getInfo());
        
        // Se o filho à direita não está vazio;
        if (place.getRight() != null) {
            // Pula para o próximo à direita pela recursividade;
            preOrder(place.getRight());
        }
    }

    /**
     * Algortimo de navegação em pós ordem
     * 
     * @param place - Recebe a posição 
     */
    public void postOrder(No place) {
        // Se o filho à esquerda não está vazio;
        if (place.getLeft() != null) {
            // Pula para o fihlo à esquerda pela recursividade;
            preOrder(place.getLeft());
        }

        // Se o filho à direita não está vazio;
        if (place.getRight() != null) {
            // Pula para o filho à direita pela recursividade;
            preOrder(place.getRight());
        }

        // Por último, imprime a informação do nó;
        System.out.print(" " + place.getInfo());
    }

    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }
}
