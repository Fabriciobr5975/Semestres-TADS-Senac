
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Escreva um método para encontrar o maior elemento em um vetor de inteiros.
 *
 * @author arauj
 */
public class Ex2 {

    public static void main(String[] args) {
        // Variáveis;
        int num;

        // Declaração da classe Scanner;
        Scanner leitor = new Scanner(System.in);

        do { // Recebe e verifica se os elementos não são nulos ou negativos

            System.out.println("Digite o tamanho do vetor:");
            num = leitor.nextInt();

        } while (num < 1);

        // Vetor;
        int[] vetor = new int[num];

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite o %d número do vetor: %n", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        // Saída de dados;
        int maiorNumero = encontrarMaiorValor(vetor);
        System.out.println("O maior número é " + maiorNumero);
    
        // Fechamento do Scanner;
        leitor.close();
    }

    /**
     * Este método encontra um maior valor de um vetor.
     *
     * @param num - Recebe como parâmetro um vetor.
     * @return Deve retornar uma variável, contendo o maior número verificado
     * dentro desse vetor.
     */
    public static int encontrarMaiorValor(int[] num) {
        int maiorNum = 0;

        for (int i = 0; i < num.length; i++) {

            while (maiorNum < num[i]) {
                maiorNum = num[i];
            }
        }
        return maiorNum;
    }
}
