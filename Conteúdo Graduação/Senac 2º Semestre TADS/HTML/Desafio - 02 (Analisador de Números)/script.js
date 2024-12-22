let numerosInseridos = [];

function adicionarValores() {
    // Pegando o campo input:number do HTML;
    let number = window.document.getElementById("numeros");
    // Atribuindo o número recebido a uma váriavel;
    let result = Number(number.value);

    // Verificação dos dados;
    if (result == "" || (result < 1 || result > 100)) {
        alert("Por favor, informe um valor entre 0 e 100 para continuar!")

    } else {
        numerosInseridos.push(Number(result));
        // Pegando o campo select do HTML;
        let select = window.document.getElementById("mostrar");
        // Criando um elemento opção no HTML
        let option = window.document.createElement("option");
        option.text = `Valor ${result} adicionado`;
        select.add(option);
    }
    // Limpar o campo input:number para o usuário poder digitar novamente;
    window.document.getElementById("numeros").value = "";
}

function mostrarMensagem() {
    /* Método para somar todos os elemetos do vetor, onde a é o 
    valor acumulado e b é o elemento  do vetor */
    let somaElementos = numerosInseridos.reduce(function (a, b) {
        return a + b;
    }, 0);

    // Pega o tamanho do vetor;
    let tamanho = numerosInseridos.length;
    // Calcula a média através do soma dos elemetos e do tamanho do vetor;
    let media = somaElementos / numerosInseridos.length;
    // Objeto para pegar o maior valor inserido pelo usuário; 
    let maiorVlr = Math.max(...numerosInseridos);
    // Objeto para pegar o menor valor inserido pelo usuário;
    let menorVlr = Math.min(...numerosInseridos);

    // Mensagem que serão exibidas na página;
    mensagem.innerHTML = ` <p>Ao todo, temos ${tamanho} elementos cadastrados</p>`;
    mensagem.innerHTML += ` <p>O maior valor informado foi: ${maiorVlr}</p>`;
    mensagem.innerHTML += ` <p>O menor valor informado foi: ${menorVlr}</p>`;
    mensagem.innerHTML += ` <p>A soma dos valores foi: ${somaElementos}</p>`;
    mensagem.innerHTML += ` <p>A Média dos valores foi: ${media}</p>`;
    mostrar.innerHTML = null;
    numerosInseridos.length = 0;
}
