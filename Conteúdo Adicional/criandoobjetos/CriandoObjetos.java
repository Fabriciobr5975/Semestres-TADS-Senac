package criandoobjetos;

import java.util.ArrayList;

public class CriandoObjetos {

    public static void main(String[] args) {
        // Criando um ArrayList para armazenar os objetos do tipo Carro;
        ArrayList<Carros> carros = new ArrayList<>();
        
        // Criando os objetos
        Carros carro1 = new Carros("Peugeot", "Peugeot 206", "Allure", "Cinza", "4", "1.6 16v");
        Carros carro2 = new Carros("Chevrolet", "Chevrolet Corsa C", "Premium", "Vermelho", "4", "1.8 8v");
        Carros carro3 = new Carros("Fiat", "Fiat Marea", "Turbo", "Prata", "4", "2.0 24v Turbo");
        Carros carro4 = new Carros("volkswagen", "volkswagen Jetta", "R-Line", "Preto", "4", "2.4 16v Turbo");
        Carros carro5 = new Carros("Ford", "Ford Ka", "Trail", "Prata", "4", "1.5 12v");

        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);
        
        for (Carros i : carros) {
            System.out.println(i.toString());
            System.out.println();
        }
    }
}
