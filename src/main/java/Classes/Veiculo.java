package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.HashMap;


@XmlRootElement(name="carro")
public class Veiculo implements Serializable {
    public static HashMap<Integer, Veiculo> carros = new HashMap<>();

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name="matricula")
    private String matricula;
    @XmlElement(name="marca")
    private String marca;
    @XmlElement(name="modelo")
    private String modelo;
    @XmlElement(name="cor")
    private String cor;
    @XmlElement(name="ano")
    private int ano;

    public Veiculo() {
        // Add cars
        carros.put(1, new Veiculo("66-66-66", "Opel", "Corsa", "preto", 1998));
    }

    public Veiculo(String matricula, String marca, String modelo, String cor, int ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                '}';
    }

    public static HashMap<Integer, Veiculo> getCarros() {
        return carros;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }
}
