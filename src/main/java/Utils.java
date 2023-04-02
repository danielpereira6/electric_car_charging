import Classes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.List;

public class Utils {
    /** Criar fatura mensal do cliente **/
    public static void registarCarregamentos() {
        try {
            LocalDate curDate = LocalDate.now(); // Hoje
            Double quantFatura;
            Double precoFatura;
            Double valorFatura;
            Carregamento lerCarregamentos;
            HashMap<Integer, Carregamento> carregamentos = new HashMap<>();
            String[] carregamentosMes = listFiles(XMLHandler.CLIENT_PATH + "/mar");

            var lerPosto = XMLHandler.readXML(Posto.class, XMLHandler.FILE_PATH + "posto1.xml");
            System.out.println("Posto 1: "+lerPosto.toString());

            /** Lista de carregamentos **/
            for (int i = 0; i < carregamentosMes.length; i++) {
                System.out.println(carregamentosMes[i]);
                lerCarregamentos = XMLHandler.readXML(Carregamento.class, XMLHandler.CLIENT_PATH + "mar/"+carregamentosMes[i]);

                quantFatura = lerCarregamentos.getQuantidade();
                precoFatura = lerCarregamentos.getConsumido();
                carregamentos.put(lerCarregamentos.getId(), lerCarregamentos);
                valorFatura = calcularValorMensal(quantFatura, precoFatura, null, null);
                System.out.println("Quantidade*Preço: " + quantFatura + "*" + precoFatura + " = " + valorFatura + " €");
            }

            // Criar fatura mensal com carregamentos
            Fatura novaFatura = new Fatura(1001, curDate.toString(), 0.21, 0.23, null, null, carregamentos);
            XMLHandler.writeXML(Fatura.class, novaFatura ,XMLHandler.CLIENT_PATH + "fatura_mes_teste.xml");

            Main.designFatura(novaFatura, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Calcular valor a pagar na fatura mensal **/
    public static double calcularValorMensal(double quant, double preco, ArrayList<Double> descontos, ArrayList<Double> impostos) {
        if(descontos != null) {
            if (!descontos.isEmpty()) {
                return quant * preco - (descontos.get(0));
            }
        }
        if(impostos != null) {
            if (!impostos.isEmpty()) {
                return quant * preco + (impostos.get(0));
            }
        }
        return round(quant * preco, 2);
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
