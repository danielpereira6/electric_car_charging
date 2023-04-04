package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="descontos")
public class Descontos {
    @XmlAttribute(name="id")
    private int id;

    @XmlElement(name="nome")
    private String nome; // tipo de desconto

    @XmlElement(name="valor")
    private double valor;

    @XmlElement(name="unidade")
    private String unidade; // % ou €

    public Descontos(){}

    public Descontos(int id, String nome, double valor, String unidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    @Override
    public String toString() {
        return nome + ": " + valor + " " + unidade;
    }
}
