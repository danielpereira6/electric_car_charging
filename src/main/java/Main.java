import Classes.Veiculo;
import Classes.Veiculos;
import jakarta.xml.bind.JAXBException;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public String ManageCars() {
        return "";
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar postos de carregamento");
            System.out.println("2 - Listar carros");
            System.out.println("3 - Calcular dados da carga");
            System.out.println("0 - Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Listando postos de carregamento...");
                    // Aqui você pode colocar a lógica para listar os postos de carregamento
                    break;
                case 2:
                    try {
                        System.out.println("PATH: "+XMLHandler.FILEPATH+"veiculos.xml");
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILEPATH+"veiculo.xml");
                        System.out.println(carro.toString());

//                        XMLHandler.validateXML(Veiculo.class, "veiculos.xml", "veiculos.xsd");
                    } catch (Exception e) {
                        e.printStackTrace();
                        //return "Error: "+e;
                    }
                    break;
                case 3:
                    System.out.println("Calculando dados da carga...");
                    // Aqui você pode colocar a lógica para calcular os dados da carga
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (escolha != 0);

        scanner.close();
    }
}