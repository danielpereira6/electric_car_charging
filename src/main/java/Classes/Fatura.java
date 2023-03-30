package Classes;

import java.util.Date;

public class Fatura {
    private int numero_fatura; // id da fatura
    private Date data_fatura;
    private double preco; // €
    private double descontos; // %
    private double impostos; // %
    private double iva = 0.23; // 23%
    private Carregamento dados_carregamento;

    /** carregamento normal (até 22kW) **/
    //Consumo de energia: 2,60€
    //Tarifa OPC: 3,30€
    //Taxas e Impostos: 1,42€
    //Custo total: 7,32€

    /** posto rápido (50kW) **/
    //Consumo de energia: 2,60€
    //Tarifa OPC: 3,30€
    //Taxas e Impostos: 1,42€
    //Custo total: 7,32€
}
