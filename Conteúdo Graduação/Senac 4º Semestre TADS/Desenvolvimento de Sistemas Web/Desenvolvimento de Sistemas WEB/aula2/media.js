import * as fn from "./funcoes_media.js"

let notas = [];

console.log("Digite a quantidade de notas");
let qtd_notas = fn.receberQuantidadeNotas();

console.log("Digite as notas");
notas = fn.receberNotas(qtd_notas);

console.log(`A média foi ${fn.calcularMedia(notas).toFixed(2)}`)
console.log(`A maior nota foi ${fn.pegarMaiorNota(notas)}`);
console.log(`A menor nota foi ${fn.pegarMenorNota(notas)}`);
console.log(`Notas Azúis: [${fn.pegarNotasAzuis(notas)}]`)

