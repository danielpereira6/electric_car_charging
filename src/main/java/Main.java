import Classes.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public String ManageCars() {
        return "";
    }

    public static void designFatura(Fatura fatura, Descontos descontos, Impostos impostos) {
        System.out.flush(); // To clear screen
        System.out.println("========================================");
        System.out.println("             Fatura #" + fatura.getNumeroFatura());
        System.out.println("========================================");
        System.out.println("Data da Fatura: " + fatura.getDataFatura());
        System.out.println("Preço por kWh: " + fatura.getPreco() + " €");
//        System.out.println("Descontos: ");
//        for (Descontos d : fatura.getDescontos().values()) {
//            System.out.println("- " + d.getNome() + ": " + d.getValor() + d.getUnidade());
//        }
//        System.out.println("Impostos: ");
//
//        for (Impostos i : fatura.getImpostos().values()) {
//            System.out.println("- " + i.getNome() + ": " + i.getTaxa() + i.getUnidade());
//        }
        System.out.println("IVA: " + fatura.getIva() * 100 + "%");

        System.out.println("========================================");

        /*System.out.println("CARREGAMENTOS");
        for (Carregamento c : fatura.getCarregamentos().values()) {
            System.out.println("----------------------------------------");
            System.out.println("ID do Carregamento: " + c.getId());
            System.out.println("Data do Carregamento: " + c.getDataCarregamento());
            System.out.println("Hora de Início: " + c.getHoraInicio());
            System.out.println("Duração: " + c.getDuracao());
            System.out.println("Nome do Posto: " + c.getDadosPosto().getNome());
            System.out.println("Quantidade de kWh: " + c.getQuantidade() + " kWh");
            System.out.println("Consumo: " + c.getConsumido() + " kWh");
            System.out.println("Carro:");
            System.out.println("- Matrícula: " + c.getVeiculo().getMatricula());
            System.out.println("- Marca: " + c.getVeiculo().getMarca());
            System.out.println("- Modelo: " + c.getVeiculo().getModelo());
            System.out.println("- Cor: " + c.getVeiculo().getCor());
            System.out.println("- Ano: " + c.getVeiculo().getAno());
        }*/

        System.out.println("\n----- CARREGAMENTOS -----");
        System.out.println("| ID \t| Data Carreg \t| Posto \t| Desconto \t| Imposto \t| Valor Total \t|");
        System.out.println("----------------------------------------");

        for (Carregamento c : fatura.getCarregamentos().values()) {
            var quantFatura = c.getQuantidade();
            var precoFatura = c.getConsumido();
            System.out.println("| 0" + c.getId() + "\t| " + c.getDataCarregamento() + "\t| " + c.getDadosPosto().getNome() + "\t\t| " + fatura.getDescontos() + "\t\t| " + fatura.getImpostos() + "\t\t| " + Utils.calcularValorMensal(quantFatura, precoFatura, null, null) + "\t\t|");
        }
        System.out.println("========================================");
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Administração");
            System.out.println("2 - Ver fatura mensal");
            System.out.println("3 - Gestão");
            System.out.println("0 - Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Lista de carros:");
                    menuAdmin();
                    break;
                case 2:
                    System.out.println("A registar carregamento...");

                    Utils.registarCarregamentos();

                    System.out.println("Registado!");
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

    public static void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar carros");
            System.out.println("2 - Listar postos");
            System.out.println("3 - Listar carregamentos");
            System.out.println("0 - Voltar");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Lista de veículos:");
                    try {
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "veiculo.xml");
                        System.out.println(carro.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Lista de postos:");
                    // TODO: Lista de postos
                    try {
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "veiculo.xml");
                        System.out.println(carro.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Lista de carregamentos:");
                    // TODO: Lista de carregamentos
                    try {
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "veiculo.xml");
                        System.out.println(carro.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 0:
                    menu();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (escolha < 0);

        scanner.close();
    }
}