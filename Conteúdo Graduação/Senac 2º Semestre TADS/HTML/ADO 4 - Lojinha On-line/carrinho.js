document.addEventListener('DOMContentLoaded', function () {
    // Pegando os dados da localStorage que armazena os dados dos clientes;
    let usuario = JSON.parse(localStorage.getItem('LoginCliente')) || [];
    let imgUsuario = usuario[0].image; // Pegando a imagem do usuario 1;
    let nomeUsuario = usuario[0].username; // Pegando o nome do usuário 1;
    let divImgUsuario = document.getElementById('imgPerfil');

    // Criar um elemento "img" para colocar a imagem no HTML;
    let imagem = document.createElement('img');
    imagem.src = imgUsuario;
    divImgUsuario.appendChild(imagem);
    // Colando o nome dentro do HTML;
    let nome = document.getElementById('nomePerfil')
    nome.innerHTML = nomeUsuario;

    // Pegando os dados do carrinho;
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    // Variável para calcular o valor total do carrinho;
    let total = 0;
    // Pegando o elemento HTML, onde ficará a tabela com os produtos da carrinho; 
    let listaProdutosCarrinho = document.getElementById('listaProdutos');

    // Loop para adicionar os produtos do carrinho na tabela no HTML;
    carrinho.forEach((produto, index) => {
        // Criando um item HTML para adicionar os dados na tabela;
        let linha = document.createElement('div');
        // Índice para manipular cada produto produto e suas informações;
        let indice = 0;
        // Criando um elemento img para adicionar as imagens aos produtos;
        let imgProduto = produto[indice].imagemProduto;
        let imagemProdutos = document.createElement('img');

        // Adicionando no HTML as informações dos produtos no carrinho e o botões para remover um produto em específico;
        linha.innerHTML = `<div class="produtos">
                                    <table>
                                        <tr class="vitrine">
                                            <td><img id="imgProdutos" src=${imagemProdutos.src = imgProduto}></td>    
                                            <td>${produto[indice].Nome}</td>
                                            <td>${produto[indice].Valor_Unitário}</td>
                                            <td>${produto[indice].Quantidade}</td>
                                            <td>${produto[indice].Valor_Total}</td>
                                        </tr>
                                    </table>
                                    <div>
                                        <input type="button" id="removerProduto" value="Remover do Carrinho" onclick="removerProdutos(${index})">
                                    </div>
                                </div>`;
        listaProdutosCarrinho.appendChild(linha);
        // Loop para iterar sobre todos os produtos, fazendo a soma total dos produtos presentes no carrinho;
        for (let i = 0; i < produto.length; i++) {
            total += produto[i].Valor_Total;
        }
    });

    // Criando um item HTML para adicionar o valor total na tabela;
    let row = document.createElement('div');
    row.innerHTML = `<div class="totalProdutos">
                                    <table>
                                        <tr class="valorTotal">
                                            <th class="teste">Seu carrinho tem um total de: R$${total} reais</th>                                  
                                        </tr>
                                    </table>
                                    <input type="button" id="concluirCompra" value="Finalizar Compra" onclick="finalizarCompra()">
                                </div>`;
    listaProdutosCarrinho.appendChild(row);

    // Botão que volta para tela "Vitrine";
    document.getElementById('voltarParaVitrine').addEventListener('click', function () {
        window.location.href = "vitrine.html";
    });
});

// Função para remover um produto pelo índice;
function removerProdutos(index) {
    // Pegando a localStorage carrinho;
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    // Remover o produto;
    carrinho.splice(index, 1);
    // Adicionar na localStorage o array modificado;
    localStorage.setItem('carrinho', JSON.stringify(carrinho));
    // Mensagem falando que o produto foi removido do carrinho;
    alert(`Produto retirado do carrinho!`);

    // Atualizar a tela;
    location.reload();
}

// Função para retirar todos os produtos do carrinho;
function limparCarrinho() {
    // Pegando a localStorage carrinho;
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];

    // Verificando se a localStorage não está vazia;
    if ((carrinho.length === 0)) {
        alert(`Sem itens para retirar do carrinho!`)
        return;

    } else { // Se ela não estiver vazia, então limpe todos os dados;
        // Remover todos os dados;
        localStorage.removeItem('carrinho');
        // Mensagem dizem que todos os dados foram excluídos;
        alert('Todos os dados foram excluídos!');
    }
    // Atualizar a tela;
    location.reload();
}

// Função para finalizar a compra;
function finalizarCompra() {
    // Pegando os dados da localStorage carrinho;
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    // Pegando os dados da localStorage com os dados dos usuários;
    let usuario = JSON.parse(localStorage.getItem('LoginCliente')) || [];
    // Índice para adicionar o primeiro usuário na mensagem de compra;
    let index = 0;

    // Verificando se a localStorage não está vazia; 
    if ((carrinho.length === 0)) {
        alert(`Você precisa adicionar itens ao carrinho para finalizar a compra!`)
        return;

    } else { // Se ela não estiver vazia, então finalize a compra;
        // Removendo os itens do carrinho;
        localStorage.removeItem('carrinho');
        // Mensagem finalizando a compra;
        alert(`Compra Concluída com sucesso! Obrigado pela escolha ${usuario[index].username}`);
    }
    // Atualizar a tela;
    location.reload();
}