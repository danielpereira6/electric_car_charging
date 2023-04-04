import Classes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.time.LocalDate;

public class Utils {
    public static LocalDate curDate = LocalDate.now(); // Hoje
    public static String curMonth = curDate.getMonth().toString();

    /** Criar fatura mensal do cliente **/
    public static void criarFatura() {
        Double quantCarreg;
        Double precoCarreg;
        Double valorFatura;
        ArrayList<Double> valores = new ArrayList<>();
        Double totalFatura = 0.00;
        Boolean valido;
        String novoCarregamento;
        Carregamento lerCarregamentos;
        HashMap<Integer, Carregamento> carregamentos = new HashMap<>();

        try {
            String[] carregamentosMes = listFiles(XMLHandler.CLIENT_PATH + "/" + curMonth);

            // Excepção caso não existam carregamentos
            if (carregamentosMes == null) {
                System.out.println("Não existem carregamentos neste mês");
            }
            else {
//            var lerPosto = XMLHandler.readXML(Posto.class, XMLHandler.FILE_PATH + "posto1.xml");
//             System.out.println("Posto 1: "+lerPosto.toString());

                // Criar Descontos / Impostos para teste
                Descontos descontoFatura = new Descontos(1, "Desc. p/quantidade", 0.25, "%");
                Impostos impostoFatura = new Impostos(1, "Tarifa OPC", 0.50, "€");
                Impostos imposto2Fatura = new Impostos(2, "IEC", 0.05, "%");

                HashMap<Integer, Descontos> listaDescontos = new HashMap<>();
                listaDescontos.put(descontoFatura.getId(), descontoFatura);
                HashMap<Integer, Impostos> listaImpostos = new HashMap<>();
                listaImpostos.put(impostoFatura.getId(), impostoFatura);
                listaImpostos.put(imposto2Fatura.getId(), imposto2Fatura);

                /** Lista de carregamentos **/
                for (int i = 0; i < carregamentosMes.length; i++) {
                    // System.out.println(carregamentosMes[i]); // Lista de ficheiros
                    novoCarregamento = XMLHandler.CLIENT_PATH + curMonth + "/" + carregamentosMes[i];
                    lerCarregamentos = XMLHandler.readXML(Carregamento.class, novoCarregamento);

                    // Verificar se os carregamentos são válidos
                    valido = XMLHandler.validateXML(Carregamento.class, novoCarregamento, XMLHandler.FILE_PATH + "carregamento.xsd");

                    if (valido == true) {
                        // System.out.println("XML válido: "+valido);

                        // Se válido, guarda carregamento numa lista (HashMap)
                        carregamentos.put(lerCarregamentos.getId(), lerCarregamentos);

                        quantCarreg = lerCarregamentos.getQuantidade();
                        precoCarreg = lerCarregamentos.getPreco();

                        valorFatura = calcularTotal(quantCarreg, precoCarreg, descontoFatura, impostoFatura);
                        valores.add(valorFatura);
//                    System.out.println("Total c/ Desc.+Taxa: " + valorFatura + " €");
//                    System.out.println("---");
                    }
                }

                for (int i = 0; i < valores.size(); i++) {
                    totalFatura = totalFatura + valores.get(i);
                }

                /** Criar fatura mensal com carregamentos **/
                Fatura novaFatura = new Fatura(1001, curDate.toString(), listaDescontos, listaImpostos, carregamentos, 0.23, totalFatura);
                XMLHandler.writeXML(Fatura.class, novaFatura, XMLHandler.CLIENT_PATH + "fatura_mes.xml");

                // Design FATURA
                Main.designFatura(novaFatura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Calcular valor a pagar na fatura mensal **/
    public static double calcularTotal(double quant, double preco, Descontos desconto, Impostos imposto) {
        double preco_final = quant * preco;
        if (desconto != null) {
            if (desconto.getUnidade() == "%") {
//                System.out.println("Desconto (%): "+desconto.getValor());
                preco_final = preco_final - (preco_final*desconto.getValor());
            }
            else { // se é um valor direto em €
//                System.out.println("Desconto (€): "+desconto.getValor());
                preco_final = preco_final - desconto.getValor();
            }
        }
        if (imposto != null) {
            if (imposto.getUnidade() == "%") {
//                System.out.println("Taxa (%): "+imposto.getTaxa());
                preco_final = preco_final + (preco_final*imposto.getTaxa());
            }
            else { // se é um valor direto em €
//                System.out.println("Taxa (€): "+imposto.getTaxa());
                preco_final = preco_final + imposto.getTaxa();
            }
        }
        return round(preco_final, 2);
    }

    /** Arredondar 2 casas decimais **/
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /** Lista ficheiros dentro de diretório **/
    public static String[] listFiles(String dir) {
        // Create a file object
        File f = new File(dir);

        // Get all the names of the files present
        // in the given directory
        String[] files = f.list();

        // Display the names of the files [Debug]
        /*for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }*/
        return files;
    }

    /** Cria ficheiro **/
    public static void createFile(String filename, byte[] bytes) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            file.write(bytes);
            file.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** Apagar ficheiro **/
    public static void deleteFile(String filename) {
        File myObj = new File(filename);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
