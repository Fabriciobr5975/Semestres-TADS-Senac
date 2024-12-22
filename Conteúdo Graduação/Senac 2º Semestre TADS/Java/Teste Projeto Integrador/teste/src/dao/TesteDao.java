/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Classe DAO, (Data Access Object), para acessar o Banco de dados e realizar as
 * operações no mesmo.
 *
 * @author arauj
 */
public class TesteDao {

    // Criando uma variável para a conexão ao Banco de dados;
    private Connection conectar;

    /**
     * Método para estabelecer a conexeão entre a aplicação e o Banco de Dados
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/dados", "root", "");
    }

    /**
     * Método para cadastrar Produtos e salvar no Banco de Dados
     *
     * @param idProduto - Recebe o id do produto
     * @param nomeProduto - Recebe o nome do produto
     * @param marcaProduto - Recebe a marca do produto
     * @param composicaoProduto - Recebe a composição do produto
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public void cadastrarProduto(String idProduto, String nomeProduto, String marcaProduto, String composicaoProduto) throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Preparar os comandos para enviar ao BD;
        PreparedStatement st = conectar.prepareStatement("INSERT INTO produto VALUES(?, ?, ?, ?)");
        st.setString(1, idProduto);
        st.setString(2, nomeProduto);
        st.setString(3, marcaProduto);
        st.setString(4, composicaoProduto);
        //Executar os comandos acima;
        st.executeUpdate();
    }

    /**
     * Método para excluir um produto a partir do id junto com o seu nome
     *
     * @param idProduto - Recebe o id do produto
     * @return - Retorna um valor inteiro que caso seja igual a 1, significa que
     * o produto foi excluido, caso contrário, o produto não foi excluido.
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public int excluirProduto(String idProduto) throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Preparar os comandos para enviar ao BD;
        PreparedStatement st = conectar.prepareStatement("DELETE FROM produto WHERE id = ?");
        st.setString(1, idProduto);
        //Executar os comandos acima;
        int retorno = st.executeUpdate(); //Deletar retorna um valor inteiro para o controle de fluxo por isso da variável

        //retornando o resultado para o programa principal; 
        return retorno;
    }

    /**
     * Método para pegar um produto através do nome retornar esses dados para o
     * programa principal
     *
     * @param nome - Recebe o nome do produto
     * @return - Retorna os dados do produto para o programa principal
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public ResultSet buscarProdutos(String nome) throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Preparar os comandos para enviar ao BD;
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM produto WHERE nome = ?");
        st.setString(1, nome);
        // ResultSet salva os dados em forma de array, usado principalmente para armazenar os dados
        ResultSet produto = st.executeQuery(); //Executa o comando;

        return produto;
    }

    /**
     * Método para alterar algum produto já existente no Banco de Dados
     *
     * @param nome - Recebe o nome do produto
     * @param marca - Recebe a marca do produto
     * @param composicao - Recebe a composição do produto
     * @param id - Recebe o id do produto
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public void alterarProdutos(String nome, String marca, String composicao, String id) throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Preparar os comandos para alterar o produto;
        PreparedStatement st = conectar.prepareStatement("UPDATE produto SET nome = ?, marca = ?, composicao = ? WHERE id = ?");
        st.setString(1, nome);
        st.setString(2, marca);
        st.setString(3, composicao);
        st.setString(4, id);
        st.executeUpdate(); //Executa a alteração dentro do BD;
    }

    /**
     * Método que lista todos os produtos salvos no Banco de Dados
     *
     * @return - Retorna todos os produtos para o programa principal, onde
     * iremos mostrar em uma table os produtos
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public ResultSet listarTodosOsProdutos() throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Comando para buscar todos os dados de dentro do BD;
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM produto");
        // ResultSet salva os dados em forma de array, usado principalmente para armazenar os dados
        ResultSet produto = st.executeQuery(); //Executa o SELECT

        return produto;

    }

    /**
     * Método que lista todos os produtos de uma mesma marca salvos no Banco de
     * Dados
     *
     * @param marca - Recebe a marca do produto que se deseja buscar e listar
     * @return - Retorna todos os produtos que tiverem a mesma marca para o
     * programa principal, onde iremos mostrar em uma table os produtos
     *
     * @throws ClassNotFoundException - Caso alguma exceção seja lançada pelo
     * Driver MySQL;
     * @throws SQLException - Caso alguma exceção seja lançada pelo SQL;
     */
    public ResultSet listarProdutosPorMarca(String marca) throws ClassNotFoundException, SQLException {
        // Estabelecendo a conexão ao Banco de dados;
        conectar();

        //2 - Comando para buscar todos os dados de dentro do BD;
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM produto WHERE marca LIKE ?");
        st.setString(1, "%" + marca + "%");
        // ResultSet salva os dados em forma de array, usado principalmente para armazenar os dados
        ResultSet produto = st.executeQuery(); //Executa o SELECT

        return produto;

    }
}
