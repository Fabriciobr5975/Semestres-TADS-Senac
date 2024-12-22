document.addEventListener('DOMContentLoaded', function () {
    // Pegando os dados da localStorage que armazena os dados dos clientes;
    let usuario = JSON.parse(localStorage.getItem('LoginCliente')) || [];
    let imgUsuario = usuario[0].image; // Pegando a imagem do usuario 1;
    let nomeUsuario = usuario[0].username; // Pegando o nome do usuário 1;
    let divImgUsuario = document.getElementById('imgPerfil');

    // Criar um elemento "img" para colocar a imagem do usuário no HTML;
    let imagem = document.createElement('img');
    imagem.src = imgUsuario;
    divImgUsuario.appendChild(imagem);
    // Colando o nome dentro do HTML;
    let nome = document.getElementById('nomePerfil')
    nome.innerHTML = nomeUsuario;

    // Criando o array que contém os objetos(produtos);
    let produtos = [
        { id: 0, Nome: "Televisão 32 Polegadas 4K", Imagem: "imagens/Televisao.jpeg", Descrição: "Para assistir, ou jogar em 4K", Valor: "2304,00" },
        { id: 1, Nome: "Samsung Galaxy A55", Imagem: "imagens/Celularjpeg.jpeg", Descrição: "Celular lançamento", Valor: "2500,00" },
        { id: 2, Nome: "Tênis Esportivo", Imagem: "imagens/Tenis.jpeg", Descrição: "Para fazer aquela caminhada marota", Valor: "249,00" },
        { id: 3, Nome: "Notebook DELL Inspiron 15", Imagem: "imagens/NotebookDell.jpeg", Descrição: "Um bom notebook", Valor: "2999,00" },
        { id: 4, Nome: "Aprenda Java em 21", Imagem: "imagens/Livro.jpeg", Descrição: "Livro para aprende Java", Valor: "33,00" },
        { id: 5, Nome: "Notebook Lenovo Ideapad 3i Gaming", Imagem: "imagens/NotebookLenovo.jpeg", Descrição: "Bom para jogos", Valor: "5400,00" },
    ]
    // Criando o localStorage dos produtos e adicionando o array;
    localStorage.setItem('produtos', JSON.stringify(produtos));

    // Pegando o campo HTML que a tabela ficará;
    let listaProdutos = document.getElementById('listaProdutos');
    // Loop para adicionar os produtos na tabela no HTML;
    produtos.forEach((produto) => {
        // Criando um item HTML para adicionar os dados na tabela;
        let linha = document.createElement('div');
        // Criando um elemento img para as imagens dos produtos;
        let imagemProdutos = document.createElement('img');
      
        // Adicionando no HTML as informações dos produtos e os botões para a manipulação dos mesmos;
        linha.innerHTML = `<div class="produtos">
                                <table>
                                    <tr class="vitrine">
                                        <td> <img id="imgProdutos" src=${imagemProdutos.src = produto.Imagem}></td>
                                        <td>${produto.Nome}</td>
                                        <td>${produto.Descrição}</td>
                                        <td>${produto.Valor}</td>
                                    </tr>
                                </table>
                                <div>
                                    Quantidade: <input type="number" id="qtdProd${produto.id}" value="1" min="1" max="10">
                                </div>
                                <div>
                                    <input type="button" id="btnAdicionar" value="Adicionar ao Carrinho" onclick="adicionarAoCarrinho(${produto.id})">
                                </div>
                            </div>`;
        listaProdutos.appendChild(linha); 
    });

    // Botão que abre a tela "Carrinho";
    document.getElementById('abrirCarrinho').addEventListener('click', function () {
        window.location.href = "carrinho.html"; // Abrir a tela do carrinho se for clicada;
    });
});

// Função para adicionar produtos na localStorage carrinho;
function adicionarAoCarrinho(index) {
    // Pegando a localStorage dos produtos;
    let produto = JSON.parse(localStorage.getItem('produtos')) || [];

    // Pegando o valor da quantidade;
    let qtd = document.getElementById(`qtdProd${index}`).value;

    // Verificação simples para a quantidade;
    if ((qtd < 1) || (qtd > 10)) {
        alert(`Quantidade Inválida, a quantidade máxima de produtos é 10`);
        return;
    }

    // Array que contém o objeto para formar o carrinho;  
    let itemCarrinho = [
        {
            id: produto[index].id,
            imagemProduto: produto[index].Imagem,
            Nome: produto[index].Nome,
            Valor_Unitário: parseFloat(produto[index].Valor),
            Quantidade: qtd,
            Valor_Total: parseFloat(produto[index].Valor) * qtd
        }
    ]

    // Pegando a localStorage carrinho se já tiver sido criada; 
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    // Empurrando os dados para do array com os produtos que iram para o carrinho;
    carrinho.push(itemCarrinho); 
    // Salvando os dados na localStorage
    localStorage.setItem('carrinho', JSON.stringify(carrinho));
    // Mensagem dizem que os dados foram adicionados;
    alert(`Produto adicionado ao carrinho!`);
}