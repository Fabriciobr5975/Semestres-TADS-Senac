package arvore;

/**
 *
 * @author arauj
 * @param <T>
 */
public class Arvore<T extends Comparable<T>> {

    // Atributos
    private No<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void adicionar(T elemento) {
        No<T> novoNo = new No<T>(elemento);

        if (this.raiz == null) {
            this.raiz = novoNo;

        } else {
            No<T> noAtual = this.raiz;

            while (true) {
                if (novoNo.getElemento().compareTo(noAtual.getElemento()) == -1) {
                    if (noAtual.getEsquerda() != null) {
                        noAtual = noAtual.getEsquerda();

                    } else {
                        noAtual.setEsquerda(novoNo);
                        break;
                    }

                } else {
                    if (noAtual.getDireita() != null) {
                        noAtual = noAtual.getDireita();

                    } else {
                        noAtual.setDireita(novoNo);
                        break;
                    }
                }
            }
        }
    }

    // Esquerda > Cima > Direita
    public void emOrdem(No<T> noAtual) {
        if (noAtual != null) {
            emOrdem(noAtual.getEsquerda());
            System.out.println(noAtual.getElemento());
            emOrdem(noAtual.getDireita());
        }
    }

    // Cima > Esquerda > Direita
    public void preOrdem(No<T> noAtual) {
        if (noAtual != null) {
            System.out.println(noAtual.getElemento());
            emOrdem(noAtual.getEsquerda());
            emOrdem(noAtual.getDireita());
        }
    }

    // Esquerda > Direita > Cima
    public void posOrdem(No<T> noAtual) {
        if (noAtual != null) {
            emOrdem(noAtual.getEsquerda());
            emOrdem(noAtual.getDireita());
            System.out.println(noAtual.getElemento());
        }
    }

    public boolean remover(T elemento) {
        No<T> noAtual = this.raiz;
        No<T> paiNoAtual = null;

        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                break;

            } else if (elemento.compareTo(noAtual.getElemento()) == -1) {
                paiNoAtual = noAtual;
                noAtual = noAtual.getEsquerda();

            } else {
                paiNoAtual = noAtual;
                noAtual = noAtual.getDireita();
            }
        }

        if (noAtual != null) {
            // Elemento tem 2 filhos ou elemento tem somente filho à direita
            if (noAtual.getDireita() != null) {
                No<T> substituto = noAtual.getDireita();
                No<T> paiSubstituto = noAtual;

                while (substituto.getEsquerda() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }
                
                substituto.setEsquerda(noAtual.getEsquerda());
            
                if (paiNoAtual != null) {

                    if (noAtual.getElemento().compareTo(paiNoAtual.getElemento()) == -1) {
                        paiNoAtual.setEsquerda(substituto);

                    } else {
                        paiNoAtual.setDireita(substituto);
                    }

                } else { // Se não tem pai atual, então é a raiz
                    this.raiz = substituto;
                }
                // Removeu o elemento da árvore
                if (substituto.getElemento().compareTo(paiSubstituto.getElemento()) == -1) {
                    paiSubstituto.setEsquerda(null);

                } else {
                    paiSubstituto.setDireita(null);
                }
                
            } else if (noAtual.getEsquerda() != null) {
                No<T> substituto = noAtual.getEsquerda();
                No<T> paiSubstituto = noAtual;

                while (substituto.getDireita() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }

                if (paiNoAtual != null) {

                    if (noAtual.getElemento().compareTo(paiNoAtual.getElemento()) == -1) {
                        paiNoAtual.setEsquerda(substituto);

                    } else {
                        paiNoAtual.setDireita(substituto);
                    }

                } else {
                    this.raiz = substituto;
                }

                // Removeu o elemento da árvore
                if (substituto.getElemento().compareTo(paiSubstituto.getElemento()) == -1) {
                    paiSubstituto.setEsquerda(null);

                } else {
                    paiSubstituto.setDireita(null);
                }

            } else { // Não tem filhos
                if (paiNoAtual != null) {

                    if (noAtual.getElemento().compareTo(paiNoAtual.getElemento()) == -1) {
                        paiNoAtual.setEsquerda(null);

                    } else {
                        paiNoAtual.setDireita(null);
                    }

                } else {
                    this.raiz = null;
                }
            }
        }

        return (noAtual != null);
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

}
