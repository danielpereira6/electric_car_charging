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
}