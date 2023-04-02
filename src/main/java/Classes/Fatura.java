package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.HashMap;

@XmlRootElement(name="fatura")
public class Fatura implements Serializable {

    @XmlAttribute(name="n_fatura")
    private int numero_fatura; // id da fatura
    @XmlElement(name="data_fatura")
    private String data_fatura;
    @XmlElement(name="preco")
    private double preco; // €
    @XmlElement(name="iva")
    private double iva; // 23%
    @XmlElement(name="descontos")
    private HashMap<Integer, Descontos> descontos; // %
    @XmlElement(name="impostos")
    private HashMap<Integer, Impostos> impostos; // %
    @XmlElement(name="carregamentos")
    private HashMap<Integer, Carregamento> carregamentos;

    public Fatura(){}

    public Fatura(int numero_fatura,
                  String data_fatura,
                  double preco,
                  double iva,
                  HashMap<Integer, Descontos> descontos,
                  HashMap<Integer, Impostos> impostos,
                  HashMap<Integer, Carregamento> carregamentos
    ) {
        this.numero_fatura = numero_fatura;
        this.data_fatura = data_fatura;
        this.preco = preco;
        this.iva = iva;
        this.descontos = descontos;
        this.impostos = impostos;
        this.carregamentos = carregamentos;
    }

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


    public int getNumeroFatura() {
        return numero_fatura;
    }

    public String getDataFatura() {
        return data_fatura;
    }

    public double getPreco() {
        return preco;
    }

    public double getIva() {
        return iva;
    }

    public HashMap<Integer, Descontos> getDescontos() {
        return descontos;
    }

    public HashMap<Integer, Impostos> getImpostos() {
        return impostos;
    }

    public HashMap<Integer, Carregamento> getCarregamentos() {
        return carregamentos;
    }
}
