const pegarTipoOperacao = () => String((formulario.opcao.value));

const valor = valor => Number(valor);

const realizarCalculo = (pegarOperacao) => {
    const operacao = pegarOperacao();

    const valor1 = valor(formulario.valor1.value);
    const valor2 = valor(formulario.valor2.value);

    switch (operacao) {
        case "soma":
            return somar(valor1, valor2);

        case "subtracao":
            return subtrair(valor1, valor2);

        case "multiplicacao":
            return multiplicar(valor1, valor2);

        case "divisao":
            return dividir(valor1, valor2);

        default:
            alert("Houve um erro na hora de realizar o calculo, por favor, tente novamente!");
            break;
    }
}

const somar = (n1, n2) => Number(n1 + n2);

const subtrair = (n1, n2) => Number(n1 - n2);

const multiplicar = (n1, n2) => Number(n1 * n2);

const dividir = (n1, n2) => {
    if (n1 === 0 || n2 === 0) {
        alert("Não é possível dividir um número por zero");
        return null;
    }

    return Number(n1 / n2);
}

function mostrarResultados() {
    formulario.resultado.value = realizarCalculo(pegarTipoOperacao);
}
