
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Escreva um método para verificar se os elementos de um vetor de inteiros
 * estão em ordem crescente.
 *
 * @author arauj
 */
public class Ex5 {

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

        for (int i = 0; i < num; i++) {
            System.out.printf("Digite o %d número do vetor: %n", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        verificador(vetor);

        if (verificador(vetor) == true) {
            System.out.println("O vetor está em ordem crescente!");
        } else {
            System.out.println("o vetor não está em ordem crescente!");
        }

        // Fechamento do Scanner;
        leitor.close();
    }

    /**
     * Este método verifica se os elementos do vetor estão ordenados de forma
     * crescente.
     *
     * @param num - Recebe como parâmetro um vetor.
     *
     * @return Devera retornar verdadeiro se o vetor está ordenado de forma
     * crescente ou retorna falso se não estiver ordenado de forma crescente.
     */
    public static boolean verificador(int[] num) {
        if (num.length <= 1) {
            return true;
        }

        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > num[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
