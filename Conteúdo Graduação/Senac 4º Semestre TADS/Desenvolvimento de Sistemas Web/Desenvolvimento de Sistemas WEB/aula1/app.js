import prompt from "prompt-sync"

const ler = prompt();

console.log("Digite um número");
let num1 = Number(ler());

console.log("Digite um outro número");
let num2 = Number(ler());

let soma = num1 + num2;

console.log(`O resultado da soma é ${soma}`);


