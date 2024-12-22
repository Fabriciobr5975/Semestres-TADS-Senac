package veiculo;

/**
 * @author Fabrício de Araújo Santana
 */
public class VetorVeiculos {

    // Atributos da classe;
    private Object[] elementos;
    private int tamanho;

    /**
     * Método Construtor para inicializar o vetor com um valor de posições
     * específico
     *
     * @param capacidade - Recebe um int que será usado para criar o vetor com o
     * tamanho informado
     */
    public VetorVeiculos(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    /**
     * Método Cosntrutor padrão para inicializar o vetor com 10 posições, caso o
     * usuário não informe uma quantidade para inicializar o vetor
     */
    public VetorVeiculos() {
        this(10);
    }

    /**
     * Contrutor para criar os objetos com um tamanho específico
     *
     * @param elemento - Recebe um objeto para ser adicionado dentro do vetor
     * @throws Exception Para as exceções que podem ocorrer
     */
    public void adicionarVeiculo(Object elemento) throws Exception {
        aumentarCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    /**
     * Método para verificar o tamanho total do vetor;
     *
     * @return Retorna o tamanho do vetor;
     */
    public int tamanhoVetor() {
        return this.elementos.length;
    }

    /**
     * Método para ver a quantidade de elementos dentro do vetor;
     *
     * @return Retorna a quantidade de elementos dentro do vetor;
     */
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Método para buscar um objeto pela posição e retorna qual objeto está na
     * posição informada
     *
     * @param posicao - Recebe um int para procurar um objeto dentro do vetor
     * pela posição
     *
     * @return Retorna o objeto que foi encontrado a partir da posição informada
     * pelo usuário
     * @throws Exception Caso a posição seja inválida, ou que o vetor esteja
     * vazio
     */
    public Object buscarVeiculo(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }
    }

    /**
     * Método para buscar um veículo pelo nome e retornar a sua posição dentro
     * do vetoer
     *
     * @param elemento - Recebe uma String para comparar com o nome do objeto
     * para verificar se o objeto que o usuário deseja procurar existe dentro do
     * vetor
     *
     * @return Retorna a posição do objeto que o usuário procura
     * @throws Exception - Caso o elemento não seja encontrado e o vetor não
     * tenha veículos
     */
    public int buscarVeiculo(String elemento) throws Exception {
        for (int i = 0; i < this.elementos.length; i++) {
            Veiculo veiculo = (Veiculo) this.elementos[i];

            if (elementos[i] == null) {
            } else {
                if (veiculo.getNome().equalsIgnoreCase(elemento)) {
                    return i;
                }
            }
        }
        throw new Exception("Não foi possível encontrar esse veículo");
    }

    /**
     * Método para adicionar os veículos em uma posição especifica dentro do
     * vetor
     *
     * @param posicao - Recebe a posição na qual o usuário que adicionar um
     * veículo
     * @param elemento - Recebe um objeto que será colocado dentro do vetor
     *
     * @throws Exception Caso a posição informada pelo usuário não seja válida
     */
    public void adicionarVeiculoInicio(int posicao, Object elemento) throws Exception {
        if (posicao >= 0 && posicao < tamanhoVetor()) {
            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Posição Inválida");
        }
    }

    /**
     * Método para aumentar a capacidade do vetor, quando o usuário colocar um
     * dado a mais dentro do vetor.
     */
    private void aumentarCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];

            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos;
            }
            this.elementos = elementosNovos;
        }
    }

    /**
     * Método para remover um veículo
     *
     * @param posicao - Recebe a posição que o usuário deseja excluir de dentro
     * do vetor
     * @throws Exception Caso a posição seja inválida, ou o vetor esteja vazio
     */
    public void removerVeiculo(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.tamanho--;
        } else {
            throw new Exception("Posição inválida");
        }
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    /**
     * Método para mudar os dados do veículo
     *
     * @param posicao - Recebe uma posição dentro do vetor para alterar algum
     * veículo
     * @param opcao - Recebe uma opção para a escolha de qual modificação o
     * usuário quer
     * @param elementos - Recebe um vetor de String para a manipulação dos dados
     * do tipo String do veículo
     * @param anoFabricaoVeiculo - Recebe uma variável int para mudar o ano de
     * fabricação do veículo
     * @param precoVeiculo - Recebe uma variável double para mudar o preço do
     * veículo
     *
     * @return Retorna uma String com uma mensagem dizendo que os dados foram
     * alterados com sucesso
     * @throws Exception Caso o vetor ainda não tenha veículos
     */
    public String mudarDadosVeiculo(int posicao, int opcao, String[] elementos, int anoFabricaoVeiculo, double precoVeiculo) throws Exception {
        if (!this.estaVazio()) {
            Veiculo veiculo = (Veiculo) buscarVeiculo(posicao);

            if (veiculo == null) {
                return "O veículo ainda não foi cadastrado nesta posição";

            } else {
                switch (opcao) {
                    case 1 -> {
                        veiculo.setMarca(elementos[0]);
                        veiculo.setNome(elementos[1]);
                        veiculo.setVersao(elementos[2]);
                        veiculo.setMotor(elementos[5]);
                    }
                    case 2 -> {
                        veiculo.setCor(elementos[3]);
                        veiculo.setPortas(elementos[4]);
                        veiculo.setAnoFabricacao(anoFabricaoVeiculo);
                    }
                    case 3 -> {
                        veiculo.setPreco(precoVeiculo);
                    }
                    case 4 -> {
                        veiculo.setMarca(elementos[0]);
                        veiculo.setNome(elementos[1]);
                        veiculo.setVersao(elementos[2]);
                        veiculo.setCor(elementos[3]);
                        veiculo.setPortas(elementos[4]);
                        veiculo.setAnoFabricacao(anoFabricaoVeiculo);
                        veiculo.setMotor(elementos[5]);
                        veiculo.setPreco(precoVeiculo);
                    }
                }
                return String.format("Dados alterados com sucesso. Dados atuais do veículo:%n%s%n", this.imprimirVeiculo(posicao));
            }
        }
        throw new Exception("O Vetor não tem veículos salvos");
    }

    /**
     * Método para formatar a impressão dos objetos
     *
     * @param posicao - Recebe uma posição a realizar a formatação
     *
     * @return Retorna uma String com os dados do objeto encontrado na posição
     * inserida pelo usuário
     * @throws Exception Para as exceções que podem ocorrer
     */
    public String imprimirVeiculo(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanhoVetor() - 1) {
            StringBuilder s = new StringBuilder();
            s.append(this.elementos[posicao]);
            s.append("\n");
            return s.toString();

        } else {
            throw new Exception("Elementro não encontrado");
        }
    }

    /**
     * Método para formatar a impressão dos objetos
     *
     * @return Retorna uma String formatada para a impressão de todos os objetos
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Object obj : this.elementos) {
            if (obj == null) {
                continue;
            }
            s.append(obj);
            s.append(", ");
        }
        return s.toString();
    }
}
