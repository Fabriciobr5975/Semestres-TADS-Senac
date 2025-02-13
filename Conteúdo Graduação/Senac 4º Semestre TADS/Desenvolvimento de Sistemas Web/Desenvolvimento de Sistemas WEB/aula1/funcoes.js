import prompt from "prompt-sync";
const ler = prompt();

function pedirNota(mensagem) {
  console.log(mensagem);
  let num = Number(ler());
  return num;
}

function calcularMedia(n1, n2, n3) {
  return (n1, n2, n3) / 3;
}

function verificarSituacao(media) {
  let mensagem = "";

  if (media >= 6) {
    mensagem = "Aprovado";
  } else {
    mensagem = "Reprovado";
  }

  return mensagem;
}

function escrever(media) {
  let mensagem = "";

  if (media >= 6) {
    mensagem = "Aprovado";
  } else {
    mensagem = "Reprovado";
  }

  return mensagem;
}
