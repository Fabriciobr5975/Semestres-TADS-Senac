package estruturafila;

/**
 * Classe com os métodos relacionados ao conceito de Fila (FIFO - First In First
 * Out), onde o primeiro elemento a entrar é o primeiro a sair
 *
 * @author Fabrício de Araújo Santana
 */
public class Fila {

    // Atributos dos objetos;
    private Senha fila[];
    private int tamanhoFila;
    private int variavelControleFila;

    /**
     * Construtor para inicializar o vetor com uma quantidade determinada pelo
     * usuário
     *
     * @param capacidade - Recebe o tamanho que o usuário deseja para criar o
     * vetor
     */
    public Fila(int capacidade) {
        fila = new Senha[capacidade];
        this.tamanhoFila = 0;
        this.variavelControleFila = 0;
    }

    /**
     * Construtor padrão, que inicializa o vetor com 10 posições
     */
    public Fila() {
        this(10);
    }

    /**
     * Método para pegar o tamanho atual do vetor
     *
     * @return Retorna o tamanho total do vetor
     */
    public int getTamanhoFila() {
        return this.tamanhoFila;
    }

    /**
     * Método para verificar se o vetor não tem elementos, ou seja, se está
     * vazio
     *
     * @return Retorna true caso o vetor estaja vazio, ou retorna false se ele
     * tiver elementos
     */
    public boolean estaVazia() {
        return this.tamanhoFila == 0;
    }

    /**
     * Método para comparar se a senha armazenada no vetor é do tipo "P", neste
     * caso se a senha é prioritária
     *
     * @return Retorna true se a senha for do tipo P, caso contrário retornará
     * false
     */
    private boolean compararTipoSenha() {
        for (int i = 0; i < this.tamanhoFila; i++) {
            if (fila[i].getTipo().equals("P")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para buscar um senha em específico
     *
     * @param posicao - Recebe a posição que deseja realizar a busca
     * @return Retorna o elemento na posição informada
     * @throws Exception Caso a fila esteja vazia
     */
    public Senha buscarSenha(int posicao) throws Exception {
        if (this.estaVazia()) {
            throw new Exception("A Fila está vazia");
        }
        return this.fila[posicao];
    }

    /**
     * Método para pegar a posição das senhas do tipo "P", ou seja, senhas
     * prioritárias armazenadas no vetor. Como estamos tratando uma fila de um
     * laboratório de coleta de sangue, é necessário ter um controle de
     * prioridade, neste caso a regra é a seguinte, a cada 3 pacientes
     * prioritários chamados, deverá chamar 1 paciente normal.
     *
     * @return Retorna a posição da próxima senha do tipo "P" a ser atendida
     */
    private int pegarPosicaoSenhaPrioritaria() {
        int posicao = 0;

        if (this.compararTipoSenha()) {
            for (int i = 0; i < this.tamanhoFila; i++) {
                if (this.fila[i].getTipo().equals("P")) {
                    posicao = i;
                    break;
                }
            }
        }
        return posicao;
    }

    /**
     * Método para pegar a posição das senhas do tipo "N", ou seja, senhas
     * normais armazenadas no vetor. Como estamos tratando uma fila de um
     * laboratório de coleta de sangue, é necessário ter um controle de
     * prioridade, neste caso a regra é a seguinte, a cada 3 pacientes
     * prioritários chamados, deverá chamar 1 paciente normal.
     *
     * @return Retorna a posição da próxima senha do tipo "P" a ser atendida
     */
    private int pegarPosicaoSenhaComum() {
        int posicao = 0;

        if (this.compararTipoSenha()) {
            for (int i = 0; i < this.tamanhoFila; i++) {
                if (this.fila[i].getTipo().equals("N")) {
                    posicao = i;
                    break;
                }
            }
        }
        return posicao;
    }

    /**
     * Método para aumentar a capacidade do vetor, quando ele atingir a sua
     * capacidade máxima
     *
     * @throws Exception Para as exceções que podem acontecer
     */
    private void aumentarCapacidade() throws Exception {
        if (this.tamanhoFila == this.fila.length - 1) {
            Senha[] elementosNovos = new Senha[this.fila.length * 2];

            for (int i = 0; i < this.tamanhoFila; i++) {
                elementosNovos[i] = this.fila[i];
            }
            this.fila = elementosNovos;
        }
    }

    /**
     * Método para enfileirar as senhas, ou seja adicionar novas senhas no vetor
     * seguindo a ideia da estrutura fila
     *
     * @param senha - Recebe um novo objeto do tipo Senha que será armazenado no
     * vetor
     * @throws Exception Caso o método aumentarCapacidade() lance um exceção
     */
    public void enfileirar(Senha senha) throws Exception {
        this.aumentarCapacidade();
        this.fila[tamanhoFila] = senha;
        this.tamanhoFila++;
    }

    /**
     * Método para espiar a proxíma senha a ser chamada, ou seja, a próxima
     * senha que será desenfileirada do vetor
     *
     * @return Retorna a proxíma senha a ser desenfileirada
     * @throws Exception Caso a fila esteja vazia
     */
    public Senha espiar() throws Exception {
        if (this.estaVazia()) {
            throw new Exception("A Fila está vazia");
        }

        if (this.compararTipoSenha() && !(this.variavelControleFila == 3)) {
            return this.fila[this.pegarPosicaoSenhaPrioritaria()];
        }
        return this.fila[this.pegarPosicaoSenhaComum()];
    }

    /**
     * Método para desenfileirar as senhas seguindo o conceito de Fila, porém
     * como estamos lidando com senhas que podem ter prioridade, é
     * desenfileirado primeiro 3 primeiras senhas do tipo prioritárias (P),
     * depois é desenfileirar uma senha normal. Esse ciclo se repete, caso
     *
     * @return Retorna a senha que foi desenfileirada
     * @throws Exception Caso a fila esteja vazia
     */
    public Senha desenfileirar() throws Exception {
        if (this.estaVazia()) {
            throw new Exception("A Fila está vazia");
        }
        Senha senha = null;

        // Desenfileirar as senhas normais;
        if (this.variavelControleFila == 3 || !this.compararTipoSenha()) {
            senha = fila[this.pegarPosicaoSenhaComum()];

            for (int i = this.pegarPosicaoSenhaComum(); i < this.tamanhoFila - 1; i++) {
                this.fila[i] = this.fila[i + 1];
            }
            this.tamanhoFila--;
            this.variavelControleFila = 0;
        } else { // Desenfileirar as senhas prioritárias
            senha = fila[this.pegarPosicaoSenhaPrioritaria()];

            for (int i = this.pegarPosicaoSenhaPrioritaria(); i < this.tamanhoFila - 1; i++) {
                this.fila[i] = this.fila[i + 1];
            }
            this.tamanhoFila--;
            ++this.variavelControleFila;

        }
        //this.limparPosicoesFila();
        return senha;
    }

    /**
     * Método para limpar as posições que forma desenfileiradas
     */
    private void limparPosicoesFila() {
        for (int i = this.tamanhoFila; i < this.fila.length; i++) {
            this.fila[i] = null;
        }
    }

    /**
     * Método para excluir um senha, caso necessário
     *
     * @param posicao - Recebe uma posição que existe elemente para ser excluído
     * @return Retorna a senha que foi excluida
     * @throws Exception Caso a fila esteja vazia
     */
    public Senha excluirSenhar(int posicao) throws Exception {
        if (this.estaVazia()) {
            throw new Exception("A Fila está vazia");
        }

        Senha senha = this.fila[posicao];

        for (int i = posicao; i < this.tamanhoFila - 1; i++) {
            this.fila[i] = this.fila[i + 1];
        }
        this.tamanhoFila--;
        this.limparPosicoesFila();
        return senha;
    }

    /**
     * Método para formatar a impressão dos elementos no vetor
     *
     * @return Retorna os elementos formatados para ser impresso
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int contador = 0;

        for (int i = 0; i < this.tamanhoFila - 1; i++) {
            s.append(this.fila[i]);
            s.append(", ");
            contador++;

            if (contador == 10) {
                s.append("\n");
                contador = 0;
            }
        }

        if (this.tamanhoFila > 0) {
            s.append(this.fila[this.tamanhoFila - 1]);
        }
        return s.toString();
    }
}
