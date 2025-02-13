import * as fn from './funcoes.js'

let nota1 =  fn.pedirNota("Digite a primeira nota");
let nota2 = fn.pedirNota("Digite a segunda nota");
let nota3 = fn.pedirNota("Digite a terceira nota");

let media = fn.calcularMedia(nota1, nota2, nota3);
let situacao = fn.verificarSituacao(media);

fn.escrever(`Média: ${media}`);
fn.escrever(`Situação: ${situacao}`);

