let filmes = [
    "Os Sete Samurais(1954)",
    "Bonnie e Clyde - Uma Rajada de Balas(1967)",
    "Apertem os Cintos... O Pilto Sumiu (1980)",
    "Outro Jivago (1965)",
    "Contratos Imediatos de Terceiro Grau (1977)",
    "Quem Quer ser um Milionário(2008)",
    "A Ponte do Rio Kwai (1957)",
];

// Função para imprimir o couteúdo do array;
function listarFilmes() {
    let listaFilmes = document.getElementById("listaFilmes");

    // Limpa a lista antes de adicionar os filmes;
    listaFilmes.innerHTML = "";

    // Loop FOR para rodar na estrutura do array filme, para imprimi-lo no HTML;
    for (let i = 0; i < filmes.length; i++) {
        listaFilmes.innerHTML += `<p>Filme: ${filmes[i]}</p`
    }
}

function limparDados() {
    listaFilmes.innerHTML = "";
}