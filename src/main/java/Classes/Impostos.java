package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="impostos")
public class Impostos {
    @XmlAttribute(name="id")
    private int id;

    @XmlElement(name="nome")
    private String nome; // tipo de imposto

    @XmlElement(name="taxa")
    private double taxa; // valor a acrescentar

    @XmlElement(name="unidade")
    private String unidade; // % ou €

    public Impostos(){}
    public Impostos(int id, String nome, double taxa, String unidade) {
        this.id = id;
        this.nome = nome;
        this.taxa = taxa;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getUnidade() {
        return unidade;
    }

    @Override
    public String toString() {
        return nome + ": " + taxa + " " + unidade;
    }
}