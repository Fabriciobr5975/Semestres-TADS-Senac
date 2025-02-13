import {calcularMedia, carregarNotas, filtrarAzuis, float, input, int, maiorNota, print} from './ex1_funcoes.js';

print('Informe a qtd de notas:');
let qtd = int(input())

let notas = carregarNotas(qtd);
let media = calcularMedia(notas);
let maior = maiorNota(notas);
let azuis = filtrarAzuis(notas);

print(`A média é ${media}`)



//////

import prompt from 'prompt-sync'
const ler = prompt();


export function int(msg) {
  return Number(msg)
}

export function float(msg) {
  return Number(msg)
}

export function input() {
  return ler();
}

export function print(msg) {
  console.log(msg);
}

export function carregarNotas(qtd) {
  let notas = [];

  for (let i = 0; i < qtd; i++) {
    print('Informe a nota:')
    let nota = float(input())
    notas.push(nota);
  }
  return notas;
}

export function calcularMedia(notas) {
  let soma = 0;
  for (let item of notas)
    soma += item
  return soma / notas.length;
}

export function maiorNota(notas) {
  let maior = 0;
  for (let item of notas)
    if (item > maior) maior = item
  return maior;
}

export function filtrarAzuis(notas) {
  let positivas = [];
  for (let item of notas)
    if (item >= 6) positivas.push(item)
  return positivas;
}

