
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Escreva um método para verificar se um determinado elemento está presente em
 * um vetor de inteiros
 *
 * @author arauj
 */
public class Ex3 {

    public static void main(String[] args) {
        // Variáveis;
        int num, verificarNum;

        // Declaração da classe Scanner;
        Scanner leitor = new Scanner(System.in);

        do { // Recebe e verifica se os elementos não são nulos ou negativos

            System.out.println("Digite o tamanho do vetor:");
            num = leitor.nextInt();

        } while (num < 1);

        // Array;
        int[] vetor = new int[num];

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite o %d número do array: %n", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Digite o número que deseja verificar dentro do vetor:");
        verificarNum = leitor.nextInt();

        // Saída de dados;
        verificador(vetor, verificarNum);

        if(verificador(vetor, verificarNum) == true){
            System.out.printf("O número %d está presente dentro do vetor!%n", verificarNum);
        
        } else {
            System.out.printf("O número %d não está presente dentro do vetor!%n", verificarNum);    
        }
        
        // Fechamento do Scanner;
        leitor.close();
    }

    /**
     * Este método verifica se um valor que o usuário escolhe está dentro do
     * vetor.
     *
     * @param num - Recebe com parâmetro um vetor;
     * @param Numverificador - Recebe como parâmetro o número que o usuário
     * inseriu.
     *
     * @return Deve retornar uma mesagem dizendo se aquele número inserido pelo
     * usuário está dentro do vetor, ou se ele não está inserido dentro do
     * mesmo.
     */
    public static boolean verificador(int[] num, int Numverificador) {
        for (int i = 0; i < num.length; i++) {
            if (Numverificador == num[i]) {
                return true;
            }
        }
        return false;
    }
}
