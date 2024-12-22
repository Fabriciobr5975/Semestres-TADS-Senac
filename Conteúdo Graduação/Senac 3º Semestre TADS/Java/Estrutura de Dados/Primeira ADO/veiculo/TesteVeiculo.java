package veiculo;

import javax.swing.JOptionPane;

/**
 * @author Fabrício de Araújo Santana
 */
public class TesteVeiculo {

    /**
     * Método para formatar o menu de opções
     *
     * @return Retorna as opções do menu formatado
     */
    public static String menuOpcoes() {
        return """
               1 - Adicionar um veículo
               2 - Adicionar um veículo na posição desejada
               3 - Buscar veículo pela posição
               4 - Buscar pelo Nome do veículo
               5 - Mudar dados do veículo desejado
               6 - Excluir veículo
               7 - Imprimir dados do veículo escolhido
               8 - Imprimir todos os veículos""";
    }

    /**
     * Método para receber um número do tipo inteiro e criar um vetor de
     * veículos com esse tamanho
     *
     * @return Retorna um número inteiro maior que 0 para criar um vetor de
     * veículos com o valor especificado
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int receberTamanhoVetorVeiculo() throws Exception {
        int tamanho = 0;

        do {
            tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um inteiro para inicializar o vetor", "Receber valor", JOptionPane.INFORMATION_MESSAGE));
        } while (tamanho < 1);

        return tamanho;
    }

    /**
     * Método para adicionar veículos ao vetor de veículos
     *
     * @param vetorVeiculo - Recebe a variável de referência ao objeto para
     * adicionar os veículos ao vetor
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static void adicionarVeiculos(VetorVeiculos vetorVeiculo) throws Exception {
        String[] dadosVeiculo = {"Marca", "Nome", "Versão", "Cor", "Quantidade de Porta", "Cilindrada do Motor"};
        int anoFabricacao = 0;
        double preco = 0;

        // Pegando os dados para adicionar para criar e adicionar um veículo;
        for (int i = 0; i < dadosVeiculo.length; i++) {
            dadosVeiculo[i] = JOptionPane.showInputDialog(null, String.format("%s do veículo:%n", dadosVeiculo[i]), "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (dadosVeiculo[i] == null) {
                throw new Exception("Cannot parse null string");
            }

            while (dadosVeiculo[i].isEmpty()) {
                dadosVeiculo[i] = JOptionPane.showInputDialog(null, String.format("Digite Novamente:", dadosVeiculo[i]), "Dados do Veículo", JOptionPane.WARNING_MESSAGE);
            }

            if (i == dadosVeiculo.length - 1) {
                do {
                    anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de fabricação do veículo", "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE));
                    preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço do veículo. Ex: 20.000 ou 20000", "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE));
                } while (preco < 0 || (anoFabricacao < 0));
            }
        }
        vetorVeiculo.adicionarVeiculo(new Veiculo(dadosVeiculo[0], dadosVeiculo[1], dadosVeiculo[2], dadosVeiculo[3], dadosVeiculo[4], anoFabricacao, dadosVeiculo[5], preco));
    }

    /**
     *
     * @param posicao
     * @param vetorVeiculo
     * @throws Exception
     */
    public static void adicionarVeiculos(int posicao, VetorVeiculos vetorVeiculo) throws Exception {
        String[] dadosVeiculo = {"Marca", "Nome", "Versão", "Cor", "Quantidade de Porta", "Cilindrada do Motor"};
        int anoFabricacao = 0;
        double preco = 0;

        // Pegando a posição;
        do {
            posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a posição que deseja adicionar um veículo", "Adicionar Veiculo", JOptionPane.QUESTION_MESSAGE));
        } while (posicao < 0 || posicao > vetorVeiculo.tamanhoVetor() - 1);

        // Pegando os dados para adicionar para criar e adicionar um veículo;
        for (int i = 0; i < dadosVeiculo.length; i++) {
            dadosVeiculo[i] = JOptionPane.showInputDialog(null, String.format("%s do veículo:%n", dadosVeiculo[i]), "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (dadosVeiculo[i] == null) {
                throw new Exception("Cannot parse null string");
            }

            while (dadosVeiculo[i].isEmpty()) {
                dadosVeiculo[i] = JOptionPane.showInputDialog(null, String.format("Digite Novamente:", dadosVeiculo[i]), "Dados do Veículo", JOptionPane.WARNING_MESSAGE);
            }

            if (i == dadosVeiculo.length - 1) {
                do {
                    anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de fabricação do veículo", "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE));
                    preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço do veículo. Ex: 20.000 ou 20000", "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE));
                } while (preco < 0 || (anoFabricacao < 0));
            }
        }
        vetorVeiculo.adicionarVeiculoInicio(posicao, new Veiculo(dadosVeiculo[0], dadosVeiculo[1], dadosVeiculo[2], dadosVeiculo[3], dadosVeiculo[4], anoFabricacao, dadosVeiculo[5], preco));
    }

    /**
     * Método para pegar um valor do tipo inteiro para realizar a busca por
     * índice
     *
     * @return - Retorna um número inteiro para realizar a busca
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int pegarValorParaBuscarPorNumero() throws Exception {
        int opcao = 0;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor inteiro para buscar a posição de veículo dentro do vetor", "Buscar por Número", JOptionPane.INFORMATION_MESSAGE));
        } while (opcao < 0);
        return opcao;
    }

    /**
     * Método para pegar um valor do tipo String para realizar a busca pelo nome
     * do objeto
     *
     * @return Retorna uma String para realizar a busca
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static String pegarValorParaBuscarPorNome() throws Exception {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome para buscar", "Buscar por Nome", JOptionPane.INFORMATION_MESSAGE);
        return nome;
    }

    /**
     * Método para pegar um número inteiro que será usado para excluir um
     * veículo do vetor
     *
     * @return - Retorna um número inteiro para realizar a exclusão
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int pegarNumeroParaExcluirVeiculo() throws Exception {
        int opcao = 0;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro para excluir o veículo"));
        } while (opcao < 0);

        return opcao;
    }

    /**
     * Método para pegar um número inteiro que será usado para imprimir um
     * véiculo do vetor
     *
     * @return Retorna um número relacionado a posição de um veículo no vetor
     * @throws Exception Para as exceções que podem ocorrer
     */
    public static int pegarNumeroParaImprimirVeiculo() throws Exception {
        int opcao = 0;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro para imprimir um veículo"));
        } while (opcao < 0);

        return opcao;
    }

    /**
     * Método para pegar os dados referente a alteração dos objetos e realizar
     * as alterações dos dados do veículo
     *
     * @param vetorVeiculo - Recebe o objeto que contém o vetor que armazena os
     * veículos, juntamente com os métodos da classe VetorVeiculo
     *
     * @return Retorna o resultado do método "mudarDadosVeiculo" da classe
     * VetorVeiculo e altera os dados do veículo
     * @throws Exception Para a exceções que podem ocorrer
     */
    public static String mudarDadosVeiculo(VetorVeiculos vetorVeiculo) throws Exception {
        // Variáveis para pegar os novos dadaos do veículo;
        String[] elementos = {"Marca", "Nome", "Versão", "Cor", "Portas", "Cilindrada do Motor"};
        int posicao = 0, opcao = 0, anoFabricacao = 0;
        double preco = 0;

        // Pegando a posição do veículo que o usuário deseja modificar;
        do {
            posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite em que posição dentro do vetor deseja alterar os dados do veículo", "Alteração de Dados", JOptionPane.INFORMATION_MESSAGE));
        } while (posicao < 0 || posicao > vetorVeiculo.tamanhoVetor() - 1);

        // Pegando qual tipo de modificação ele que fazer;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Mudar marca, nome, versão e cilindrada do motor\n2 - Mudar cor, quantidade de portas"
                    + " e ano de fabricação\n3 - Mudar preço\n4 - Mudar todos os dados\n5 - Voltar", "Digite uma Opção", JOptionPane.INFORMATION_MESSAGE));
        } while (opcao < 1 || opcao > 5);

        // Estrutura para pegar os novos dados e modificar de acordo com a solicitação do usuário
        switch (opcao) {
            // Modificar marca, nome e cilindrada do motor;
            case 1 -> {
                elementos[0] = JOptionPane.showInputDialog(null, "Digite a nova marca para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[0] == null) {
                    throw new Exception("Cannot parse null string");
                }
                elementos[1] = JOptionPane.showInputDialog(null, "Digite o novo nome para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[1] == null) {
                    throw new Exception("Cannot parse null string");
                }

                elementos[2] = JOptionPane.showInputDialog(null, "Digite a nova versão para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[2] == null) {
                    throw new Exception("Cannot parse null string");
                }

                elementos[5] = JOptionPane.showInputDialog(null, "Digite a nova cilindrada para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[5] == null) {
                    throw new Exception("Cannot parse null string");
                }

            }
            // Modificar a cor, a quantidade de portas e ano de fabricação/
            case 2 -> {
                elementos[3] = JOptionPane.showInputDialog(null, "Digite a nova cor para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[3] == null) {
                    throw new Exception("Cannot parse null string");
                }

                elementos[4] = JOptionPane.showInputDialog(null, "Digite a nova quantidade de portas para o veículo", "Mudar dados", JOptionPane.INFORMATION_MESSAGE);
                if (elementos[4] == null) {
                    throw new Exception("Cannot parse null string");
                }

                anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo ano de fabricação", "Mudar dados", JOptionPane.INFORMATION_MESSAGE));
                while (anoFabricacao <= 0) {
                    anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano de fabricação inválido, digite novamente", "Mudar dados", JOptionPane.WARNING_MESSAGE));
                }
            }
            // Modificar o preço do veículo;
            case 3 -> {
                preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o novo Preço. Ex: 20.000 ou 20000", "Mudar dados", JOptionPane.INFORMATION_MESSAGE));
                while (anoFabricacao < 0) {
                    preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço Inválido digite novamente", "Mudar dados", JOptionPane.WARNING_MESSAGE));
                }
            }
            // Modificar todos os dados do veículo;
            case 4 -> {
                for (int i = 0; i < elementos.length; i++) {
                    elementos[i] = JOptionPane.showInputDialog(null, String.format("Novo/a %s do veículo ", elementos[i]), "Mudar dados", JOptionPane.INFORMATION_MESSAGE);

                    if (elementos[i].isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O campo não pode ficar vazio", "Mensagem", JOptionPane.WARNING_MESSAGE);
                        elementos[i] = JOptionPane.showInputDialog(null, String.format("Digite o %s do veículo ", elementos[i]), "Teste", JOptionPane.INFORMATION_MESSAGE);
                    }

                    if (elementos[i] == null) {
                        throw new Exception("Cannot parse null string");
                    }

                    if (i == elementos.length - 1) {
                        anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo ano de fabricação", "Mudar dados", JOptionPane.INFORMATION_MESSAGE));
                        while (anoFabricacao <= 0) {
                            anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano de fabricação inválido, digite novamente", "Mudar dados", JOptionPane.WARNING_MESSAGE));
                        }

                        preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o novo Preço. Ex: 20.000 ou 20000", "Mudar dados", JOptionPane.INFORMATION_MESSAGE));
                        while (anoFabricacao < 0) {
                            preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço Inválido digite novamente", "Mudar dados", JOptionPane.WARNING_MESSAGE));
                        }
                    }

                }
            }
            // Voltar para o menu;
            case 5 -> {
                return "Voltado para o Menu principal";
            }
        }
        return vetorVeiculo.mudarDadosVeiculo(posicao, opcao, elementos, anoFabricacao, preco);
    }

    public static void main(String[] args) {
        // Variável de referência ao objeto;
        VetorVeiculos vetorVeiculo = null;
        // Variáveis;
        int opcao = 0;
        int opcaoCriarVetor = 0;

        do {
            try {
                opcaoCriarVetor = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Para criar um vetor com um tamanho padrão\n2 - Para criar um vetor com um tamanho específico", "Digite o que Você Deseja", JOptionPane.QUESTION_MESSAGE));
                switch (opcaoCriarVetor) {
                    case 1 -> {
                        vetorVeiculo = new VetorVeiculos();
                    }
                    case 2 -> {
                        vetorVeiculo = new VetorVeiculos(receberTamanhoVetorVeiculo());
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Digite novamente", "Criar Vetor", JOptionPane.WARNING_MESSAGE);
                    }
                }

            } catch (Exception ex) {
                // Pegando a mensagem de erro;
                String erro = ex.getMessage();

                if (erro.contains("For input string:")) {
                    JOptionPane.showMessageDialog(null, "Inserção inválida de dados, digite novamente");

                } else if (erro.contains("Cannot parse null string")) {
                    JOptionPane.showMessageDialog(null, "Fechado o sistema, aguarde", "Mensagem", JOptionPane.WARNING_MESSAGE);
                    System.exit(opcao);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (opcaoCriarVetor > 2 || opcaoCriarVetor < 1);
        while (true) {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menuOpcoes(), "Digite uma Opção", JOptionPane.INFORMATION_MESSAGE));

                switch (opcao) {
                    // Adicionar um veículo ao vetor;
                    case 1 -> {
                        adicionarVeiculos(vetorVeiculo);
                    }
                    // Adicionar um veículo ao vetor, porém na posição em que o usuário desejar
                    case 2 -> {
                        adicionarVeiculos(0, vetorVeiculo);
                    }
                    // Buscar um veículo por posição
                    case 3 -> {
                        if (!vetorVeiculo.estaVazio()) {
                            JOptionPane.showMessageDialog(null, vetorVeiculo.buscarVeiculo(pegarValorParaBuscarPorNumero()), "Buscar Veículo por índice", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sem elementos para buscar", "Mensagem", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    // Buscar um veículo por nome;
                    case 4 -> {
                        if (!vetorVeiculo.estaVazio()) {
                            JOptionPane.showMessageDialog(null, String.format("O elemento está presente na posição %d do vetor%n", vetorVeiculo.buscarVeiculo(pegarValorParaBuscarPorNome())), "Buscar Veículo por índice", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sem elementos para buscar", "Mensagem", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    // Mudar os dados do veículo;
                    case 5 -> {
                        if (!vetorVeiculo.estaVazio()) {
                            JOptionPane.showMessageDialog(null, mudarDadosVeiculo(vetorVeiculo), "Alterar Dados", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não há veículos salvos no vetor", "Mensagem", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    // Excluir um veículo;
                    case 6 -> {
                        int opcaoExcluir = pegarNumeroParaExcluirVeiculo();

                        if (!vetorVeiculo.estaVazio()) {
                            vetorVeiculo.removerVeiculo(opcaoExcluir);
                            JOptionPane.showMessageDialog(null, "Veículo removido com sucesso", "Remover veículo", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Teste");
                        }
                    }
                    // Imprimir um veículo em específico;
                    case 7 -> {
                        if (!vetorVeiculo.estaVazio()) {
                            JOptionPane.showMessageDialog(null, vetorVeiculo.imprimirVeiculo(pegarNumeroParaImprimirVeiculo()), "Dados do Veículo", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Sem veículos para imprimir", "Dados do veículo", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    // Imprimir todos os veículos;
                    case 8 -> {
                        if (!vetorVeiculo.estaVazio()) {
                            JOptionPane.showMessageDialog(null, String.format("Quantidade de Veículos cadastrados: %d%nQuantidade total de Veículos criados %d%n%s%n", vetorVeiculo.tamanho(), Veiculo.getQuantidadeDeVeiculos(), vetorVeiculo), "Veículos", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Não há elementos para mostrar");
                        }
                    }
                    // Caso a opção fornecida pelo usuário seja inválida com as opções do sistema;
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Mensagem", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                // Pegando a mensagem de erro;
                String erro = ex.getMessage();
                
                if (erro.contains("Cannot parse null string")) {
                    JOptionPane.showMessageDialog(null, "Fechando o programa", "Sistema", JOptionPane.WARNING_MESSAGE);
                    break;

                } else if (erro.contains("For input string:")) {
                    JOptionPane.showMessageDialog(null, "Inserção inválida de dados, digite um valor válido para o campo", "Erro", JOptionPane.ERROR_MESSAGE);

                } else if (vetorVeiculo.estaVazio()) {
                    JOptionPane.showMessageDialog(null, "Não há veiculos salvos", "Erro", JOptionPane.ERROR_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, String.format("Erro: %s%n", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}