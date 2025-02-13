import prompt from "prompt-sync";

const ler = prompt();

let tipoAcai1 = 0;
let tipoAcai2 = 0;
let tipoAcai3 = 0;

console.log("Tamanhos de Açaí: [1 - Pequeno | 2 - Médio | 3 - Grande]");

do {
  
tipoAcai1 = pedirTamanhoAcai("Digite o tamanho que você deseja:");

if (verificaTamanhoAcai(tipoAcai1)) {
  tipoAcai1 = pedirTamanhoAcai("Digite um tamanho de Açaí válido!");
  continue;
}

tipoAcai2 = pedirTamanhoAcai("Digite o tamanho que você deseja:");

if (verificaTamanhoAcai(tipoAcai1)) {
  tipoAcai1 = pedirTamanhoAcai("Digite um tamanho de Açaí válido!");
  continue;
}

tipoAcai3 = pedirTamanhoAcai("Digite o tamanho que você deseja:");

if (verificaTamanhoAcai(tipoAcai1)) {
  tipoAcai1 = pedirTamanhoAcai("Digite um tamanho de Açaí válido!");
  continue;
}

break;
} while(true); 

let valor = calcularPrecoAcai(tipoAcai1, tipoAcai2, tipoAcai3);

imprimirValor(`O valor total foi de ${valor.toFixed(2)} reais`);

function pedirTamanhoAcai(mensagem) {
  console.log(mensagem);
  let tipo = Number(ler());
  return tipo;
}

function verificaTamanhoAcai(tipo) {
  return tipo === null || tipo < 1 || tipo > 3;
}

function calcularPrecoAcai(tipo1, tipo2, tipo3) {
  return pegarPreco(tipo1) + pegarPreco(tipo2) + pegarPreco(tipo3);
}

function pegarPreco(tipoAcai) {
  let preco = 0;

  switch(tipoAcai) {
    case 1 :
      preco = 13.5
      break;
      
    case 2 :
      preco = 15.0;
      break;

    case 3:
      preco = 17.5;
      break;
    
    default :
      return 0;
  }

  return preco;
}

function imprimirValor(valor) {
  console.log(valor);
}
