package estruturafila;

import javax.swing.JOptionPane;

/**
 * Classe para testar os métodos da classe Fila
 * 
 * @author Fabrício de Araújo Santana
 */
public class TesteFila {

    /**
     * Método para criar novas senha, neste caso o contrutor recebe o tipo da
     * senha, onde o usuário terá duas opções, Prioritária (P) ou Normal (N).
     *
     * @return Retorna um novo objeto do tipo Senha que foi criado
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static Senha criarSenha() throws Exception {
        String[] opcoes = {"Prioritária", "Normal"};
        String senha = "";

        do {
            senha = (String) JOptionPane.showInputDialog(null, "Pegue uma senha para ser atendido/a",
                    "Senha", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes);
        } while (senha.isEmpty());

        if (senha.equals("Prioritária")) {
            return new Senha("P");
        }
        return new Senha("N");
    }
    
    /**
     * Método para criar uma fila com um tamanho determinado, ou com um tamanho
     * padrão
     *
     * @return Retorna um novo objeto do tipo Fila para a manipulação da fila 
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static Fila criarFila() throws Exception {
        Fila fila = null;

        // Para criar a fila apenas uma vez
        while (fila == null) {
            int opcaoCriarVetor = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Para criar um vetor com um tamanho padrão"
                    + "\n2 - Para criar um vetor com um tamanho específico", "Digite o que Você Deseja",
                    JOptionPane.QUESTION_MESSAGE));

            // Criando a fila de acordo com a opção escolhida pelo usuário
            switch (opcaoCriarVetor) {
                // Criando a fila com um valor padrão
                case 1 -> {
                    fila = new Fila();
                    break;
                }
                // Criando a fila com um tamanho determinado
                case 2 -> {
                    fila = new Fila(receberTamanhoFila());
                    break;
                }
                // Caso a opção não seja válida
                default -> {
                    JOptionPane.showMessageDialog(null, "Digite novamente", "Criar Vetor", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
            }
        }
        return fila;
    }

    /**
     * Método para formatar o menu de opções que será usado no JOptionPane para
     * a manipulação do programa
     *
     * @return Retorna o menu formatado
     */
    public static String formatarMenuOpcoes() {
        return """
               1 - Adicionar Senhas na Fila
               2 - Próxima Senha a ser Chamada
               3 - Chamar Próxima Senha 
               4 - Excluir Senha
               5 - Verificar o Tamanho da Fila
               6 - Imprimir Todas as Senhas
               """;
    }

    /**
     * Método para receber um número do tipo inteiro e criar a fila com este
     * tamanho
     *
     * @return Retorna um número inteiro maior que 0 para criar um vetor que
     * manipulara os objetos Senha seguindo a ideia de Fila
     *
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int receberTamanhoFila() throws Exception {
        int tamanho = 0;

        do {
            tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um inteiro para inicializar o Fila", "Receber valor", JOptionPane.INFORMATION_MESSAGE));
        } while (tamanho < 1);

        return tamanho;
    }

    /**
     * Método para receber uma posição válida para a exclusão de uma senha de
     * dentro do vetor
     *
     * @param fila - Recebe o objeto do tipo Fila
     * @return Retorna um número inteiro que será usado para excluir uma senha
     * em uma posição em expecifico do vetor
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int receberPosicaoParaExcluirSenha(Fila fila) throws Exception {
        int opcao = 0;

        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual posição que deseja excluir uma senha", "Excluir Senha", JOptionPane.INFORMATION_MESSAGE));

        while (opcao < 0 || opcao >= fila.getTamanhoFila()) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Opção inválida, porfavor digite novamente",
                    "Excluir Senha", JOptionPane.WARNING_MESSAGE));
        }
        return opcao;
    }

    // Método main
    public static void main(String[] args) throws Exception {
        // Variável de referência ao objeto Fila;
        Fila fila = null;
        // Variáveis para a manipulação do programa;
        int opcao = 0, opcaoCriarVetor = -1;

        while (true) {
            try {
                if (opcaoCriarVetor == -1) {
                    fila = criarFila();
                    opcaoCriarVetor = 0;
                }
                // Pegando a opção do menu para a manipulação da Fila;
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, formatarMenuOpcoes(),
                        "Menu de Opções", JOptionPane.INFORMATION_MESSAGE));

                // Opções para a manipulação das senhas na Fila 
                switch (opcao) {
                    // Enfileirar novas senhas
                    case 1 -> {
                        fila.enfileirar(criarSenha());
                    }
                    // Espiar qual será a próxima senha a ser desenfileirada
                    case 2 -> {
                        if (!fila.estaVazia()) {
                            JOptionPane.showMessageDialog(null, String.format("A próxima senha a ser atendida é: %s",
                                    fila.espiar()), "Próxima Senha", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A Fila está vazia", "Próxima Senha", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    // Desenfileirar as senhas
                    case 3 -> {
                        if (!fila.estaVazia()) {
                            JOptionPane.showMessageDialog(null, String.format("A senha que foi chamada é: %s", fila.desenfileirar()),
                                    "Atender Paciente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A Fila está vazia",
                                    "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    // Excluir uma senha
                    case 4 -> {
                        if (fila.estaVazia()) {
                            JOptionPane.showMessageDialog(null, "A Fila está vazia",
                                    "Tamanho da Fila", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }
                        // Pegando a posição que seja excluida;
                        int opcaoExcluir = receberPosicaoParaExcluirSenha(fila);

                        // Perguntando se o usuário realmente deseja excluir a senha
                        if (JOptionPane.showConfirmDialog(null, String.format("Deseja excluir a senha %s ?",
                                fila.buscarSenha(opcaoExcluir)), "Excluir Senha", JOptionPane.INFORMATION_MESSAGE) == 0) {

                            // Excluindo a senha;
                            JOptionPane.showMessageDialog(null, String.format("A senha %s foi excluída com sucesso",
                                    fila.excluirSenhar(opcaoExcluir)), "Excluir Senha", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ação cancelada");
                        }
                    }
                    // Verificar a quantidade de elementos presentes na fila
                    case 5 -> {
                        if (fila.estaVazia()) {
                            JOptionPane.showMessageDialog(null, "A Fila está vazia",
                                    "Tamanho da Fila", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, String.format("O tamanho da Fila: %d",
                                fila.getTamanhoFila()), "Tamanho da Fila", JOptionPane.INFORMATION_MESSAGE);
                    }
                    // Imprimir todas as senhas
                    case 6 -> {
                        if (fila.estaVazia()) {
                            JOptionPane.showMessageDialog(null, "Não há senhas na Fila",
                                    "Imprimir Senhas", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, fila.toString(), "Imprimir Senhas", JOptionPane.INFORMATION_MESSAGE);
                    }
                    // Caso a opção informada não corresponda as opções do sistema
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente",
                                "Opção Inválida", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                }
            } catch (Exception ex) {
                String erro = ex.getMessage();

                if (erro.contains("Cannot parse null string")) {
                    int opcaoSair = 0;

                    opcaoSair = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema? Aperte Sim para sair "
                            + "| Aperte Cancelar para sair", "Sair do Sistema", JOptionPane.INFORMATION_MESSAGE);

                    if (opcaoSair != 0) {
                        continue;
                    }
                    break;
                } else if (erro.contains("For input string")) {
                    JOptionPane.showMessageDialog(null, "Inserção inválida, digite novamente", "Erro", JOptionPane.WARNING_MESSAGE);

                } else if(erro.contains("String.isEmpty()")){
                    JOptionPane.showMessageDialog(null, "Voltando para o menu", "Voltar", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }
}