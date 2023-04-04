import Classes.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void designFatura(Fatura fatura) {
        System.out.flush(); // To clear screen
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("             Fatura #" + fatura.getNumeroFatura());
        System.out.println("========================================");
        System.out.println("Data da Fatura: " + fatura.getDataFatura());
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

        System.out.println("----- CARREGAMENTOS -----");
        System.out.println("| ID \t| Data Carreg \t| Posto \t| Quantidade \t| Preço \t| Descontos \t| Impostos \t| IVA \t| Valor Total \t|");
        System.out.println("----------------------------------------");

        for (Carregamento c : fatura.getCarregamentos().values()) {
            var quantFatura = c.getQuantidade();
            var precoFatura = c.getPreco();

            String cid = String.valueOf(c.getId());
            String descontoNulo = "-";
            String impostoNulo = "-";

            if (fatura.getDescontos() != null) {
                descontoNulo = fatura.getDescontos().toString();
            }
            if (fatura.getImpostos() != null) {
                impostoNulo = fatura.getImpostos().toString();
            }

            if (c.getId() < 10) cid = "0"+cid;
            System.out.println("| " +
                    cid + "\t| " +
                    c.getDataCarregamento() + "\t| " +
                    c.getDadosPosto().getNome() + "\t| " +
                    c.getQuantidade() + " kWh\t| " +
                    c.getPreco() + " €\t| " +
                    descontoNulo + "\t| " +
                    impostoNulo + "\t| " +
                    fatura.getIva() * 100 + " %\t| " +
                    Utils.calcularTotal(quantFatura, precoFatura, null, null) +
                    " €\t|");
        }
        System.out.println("========================================");

        System.out.println("TOTAL A PAGAR: " + fatura.getTotal() + " €");
        System.out.println("\n");
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Administração");
            System.out.println("2 - Ver fatura mensal");
            System.out.println("3 - Selecionar o mês de consulta");
            System.out.println("0 - Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    System.out.println("A registar carregamento...");
                    Utils.criarFatura();
                    break;
                case 3:
                    selecMes();
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
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "Cliente/veiculo.xml");
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
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "Cliente/veiculo.xml");
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
                        var carro = XMLHandler.readXML(Veiculos.class,XMLHandler.FILE_PATH + "Cliente/veiculo.xml");
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

    public static void selecMes() {
        Scanner scannerMes = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha o mês:");
            System.out.println("1 - JANUARY – JANEIRO");
            System.out.println("2 - FEBRUARY – FEVEREIRO");
            System.out.println("3 - MARCH – MARÇO");
            System.out.println("4 - APRIL – ABRIL");
            System.out.println("5 - MAY – MAIO");
            System.out.println("6 - JUNE – JUNHO");
            System.out.println("7 - JULY – JULHO");
            System.out.println("8 - AUGUST – AGOSTO");
            System.out.println("9 - SEPTEMBER – SETEMBRO");
            System.out.println("10 - OCTOBER – OUTUBRO");
            System.out.println("11 - NOVEMBER – NOVEMBRO");
            System.out.println("12 - DECEMBER – DEZEMBRO");
            System.out.println("0 - Voltar");

            escolha = scannerMes.nextInt();

            switch (escolha) {
                case 1:
                    Utils.curMonth = "JANUARY";
                    break;
                case 2:
                    Utils.curMonth = "FEBRUARY";
                    break;
                case 3:
                    Utils.curMonth = "MARCH";
                    break;
                case 4:
                    Utils.curMonth = "APRIL";
                    break;
                case 5:
                    Utils.curMonth = "MAY";
                    break;
                case 6:
                    Utils.curMonth = "JUNE";
                    break;
                case 7:
                    Utils.curMonth = "JULY";
                    break;
                case 8:
                    Utils.curMonth = "AUGUST";
                    break;
                case 9:
                    Utils.curMonth = "SEPTEMBER";
                    break;
                case 10:
                    Utils.curMonth = "OCTOBER";
                    break;
                case 11:
                    Utils.curMonth = "NOVEMBER";
                    break;
                case 12:
                    Utils.curMonth = "DECEMBER";
                    break;
                case 0:
                    menu();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (escolha < 0);
    }
}