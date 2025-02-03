
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Escreva um método para calcular a soma de todos os elementos de um vetor de
 * inteiros.
 *
 * @author arauj
 */
public class Ex1 {

    public static void main(String[] args) {
        // Variáveis;
        int num;

        // declaração da classe Scanner;
        Scanner leitor = new Scanner(System.in);

        do { // Recebe e verifica se os elementos não são nulos ou negativos

            System.out.println("Digite a quantidade de elementos do vetor:");
            num = leitor.nextInt();

        } while (num < 1);

        // Vetor;
        int[] vetor = new int[num];

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite o %d número do vetor: %n", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        // Saída de dados;
        int resultadoSoma = somarValores(vetor);
        System.out.printf("O resultado da soma dos valores do vetor é: %d%n", resultadoSoma);
    
        // Fechamento do Scanner;
        leitor.close();
    }

    /**
     * Este método irá somar todos os elementos do vetor.
     *
     * @param num - Recebe com parâmetro um vetor.
     * @return Deve retornar uma variável inteira com o resultado da soma dos
     * elementos do vetor.
     */
    public static int somarValores(int[] num) {
        int soma = 0;

        for (int i = 0; i < num.length; i++) {
            soma += num[i];
        }
        return soma;
    }

}
