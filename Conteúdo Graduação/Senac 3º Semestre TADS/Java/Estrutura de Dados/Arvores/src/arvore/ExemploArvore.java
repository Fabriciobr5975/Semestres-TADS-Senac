
package arvore;

import java.util.Random;

/**
 * Classe par rodar a árvore
 */
public class ExemploArvore {
    public static void main(String[] args) {
        // Inicializa a rondomização;
        Random rand = new Random();
        // Cria uma árvore binária;
        Arvore arvore = new Arvore();
        
        // Fazer 10 vezes;
        for(int i = 0; i < 10; i++){
            // Insere um elemento aleatório de 0 até 99;
            arvore.insert(rand.nextInt(100), arvore.getRoot());
        }
        
        // Navega a árvore em pré ordem;
        System.out.println("\nPRÉ-ORDER:");
        arvore.preOrder(arvore.getRoot());
        
        // Navega a árvore em ordem;
        System.out.println("\nIN-ORDER:");
        arvore.inOrder(arvore.getRoot());
        
        // Navega a árvore em pós ordem;
        System.out.println("\nPOST-ORDER:");
        arvore.postOrder(arvore.getRoot());
        
        System.out.println();
    }
}
