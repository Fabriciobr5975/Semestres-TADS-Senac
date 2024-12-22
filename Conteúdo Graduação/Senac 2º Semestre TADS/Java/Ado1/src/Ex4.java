
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Escreva um método para calcular a média dos elementos de um vetor de inteiros
 *
 * @author arauj
 */
public class Ex4 {

    public static void main(String[] args) {
        // Variáveis;
        int num;

        // Declaração da classe Scanner;
        Scanner leitor = new Scanner(System.in);

        do { // Recebe e verifica se os elementos não são nulos ou negativos

            System.out.println("Digite o tamanho do vetor:");
            num = leitor.nextInt();

        } while (num < 1);

        // Array;
        int[] vetor = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("Digite o %d número do vetor: %n", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        // Saída de dados;
        int resultado = getMediaVetor(vetor);
        System.out.printf("A média do vetor é: %d%n", resultado);

        // Fechamento do Scanner;
        leitor.close();
    }

    /**
     * Este método calcula todos os termos de um vetor e pega a média dessa
     * soma.
     *
     * @param num - Recebe como parâmetro um vetor.
     *
     * @return Deve retornar a média, baseada na soma dos elementos do vetor
     * divido pela quantidade de elementos desse vetor.
     */
    public static int getMediaVetor(int[] num) {
        int soma = 0, media;

        for (int i = 0; i < num.length; i++) {
            soma += num[i];
        }

        media = soma / num.length;
        return media;
    }

}
