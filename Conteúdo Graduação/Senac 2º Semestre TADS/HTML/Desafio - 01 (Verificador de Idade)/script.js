function mostrarMensagem() {
  // Variáveis para pegar o campo data de nascimento;
  let dataNascimento = window.document.getElementById('txtDataNascimento');
  let result = Number(dataNascimento.value);
  const data = new Date();
  const anoAtual = data.getFullYear(); 
  
  let ano = anoAtual;

  // Variáveis para pegar o campo input:radio;
  var masculino = window.document.getElementById('masculino');
  var feminino = window.document.getElementById('feminino');
  var mensagem = window.document.getElementById('mensagem');

  if (result == "") {
   alert("Informe um ano válido para continuar!")

  } else {
    result = ano - result;

    if (masculino.checked && (result >= 0 && result <= 100)) {
      mensagem.innerHTML = `<p>O gênero: ${masculino.value}, com ${result} anos de idade</p>`;

      addImagemMasculino(result);

    } else if (feminino.checked && (result >= 0 && result <= 100)) {
      mensagem.innerHTML = `<p>O gênero: ${feminino.value}, com ${result} anos de idade</p>`;

      addImagemFeminino(result);

    } else {
      alert("Selecione um campo para continuar!\nVerique também se o ano que você inseriu é válido!")
    }
  }
}

// Função para adicionar uma imagem masculina para cada faixa etária no formulário HTML
function addImagemMasculino(result) {
  if (result >= 0 && result <= 10) {
    imagens.innerHTML = `<img src="Imagens/CriancaM.jpeg" alt="">`

  } else if (result >= 11 && result <= 25) {
    imagens.innerHTML = `<img src="Imagens/JovemM.jpeg" alt="">`;

  } else if (result >= 26 && result < 60) {
    imagens.innerHTML = `<img src="Imagens/AdultoM.jpeg" alt="">`;

  } else if (result >= 60) {
    imagens.innerHTML = `<img src="Imagens/IdosoM.jpeg" alt="">`;
  }
}

// Função para adicionar uma imagem feminina para cada faixa etária no formulário HTM
function addImagemFeminino(result) {
  if (result >= 0 && result <= 10) {
    imagens.innerHTML = `<img src="Imagens/CriancaF.jpeg" alt="">`

  } else if (result >= 11 && result <= 25) {
    imagens.innerHTML = `<img src="Imagens/JovemF.jpeg" alt="">`;

  } else if (result >= 26 && result < 60) {
    imagens.innerHTML = `<img src="Imagens/AdultoF.jpeg" alt="">`;

  } else if (result >= 60) {
    imagens.innerHTML = `<img src="Imagens/IdosoF.jpeg" alt="">`;
  }
}
