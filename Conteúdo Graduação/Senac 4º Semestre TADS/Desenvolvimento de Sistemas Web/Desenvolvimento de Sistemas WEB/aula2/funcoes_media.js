import prompt from "prompt-sync";

const ler = prompt();

export function receberQuantidadeNotas() {
  let quantidadeNotas = Number(ler());

  return quantidadeNotas;
}

export function receberNotas(quantidadeNotas) {
  let notas = [];

  for (let i = 0; i < quantidadeNotas; i++) {
    notas.push(Number(ler()));

    while (notas[i] < 0 || notas[i] > 10) {
      notas.pop();
      console.log("Nota inválida, digite novamente: ");
      notas.push(Number(ler()));
    }
  }

  return notas;
}

export function calcularMedia(notas) {
  let soma = 0;

  for (let item of notas) {
    soma += item;
  }

  return soma / notas.length;
}

export function pegarMaiorNota(notas) {
  let maiorNota = 0;

  for (let item of notas) {
    if (item > maiorNota) {
      maiorNota = item;
    }
  }

  return maiorNota;
}

export function pegarMenorNota(notas) {
  let menorNota = Infinity;

  for (let item of notas) {
    if (item < menorNota) {
      menorNota = item;
    }
  }

  return menorNota;
}

export function pegarNotasAzuis(notas) {
  let notasAzuis = [];
  for (let item of notas) {
    if (item >= 6) {
      notasAzuis.push(item);
    }
  }

  return notasAzuis;
}
