package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name="posto")
public class Posto implements Serializable {

    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="nome")
    private String nome;

    @XmlElement(name="descricao")
    private String descricao;

    @XmlElement(name="tipo_posto")
    private String tipo_posto; // normal (<22kW); rápido (>50kW)

    @XmlElement(name="localizacao")
    private ArrayList<Localizacao> localizacao; // lat + lon


    public Posto() {}
    public Posto(String id, String nome, String descricao, String tipo_posto, ArrayList<Localizacao> localizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo_posto = tipo_posto;
        this.localizacao = localizacao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipoPosto() {
        return tipo_posto;
    }

    public ArrayList<Localizacao> getLocalizacao() {
        return localizacao;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo_posto='" + tipo_posto + '\'' +
                ", localizacao=" + localizacao +
                '}';
    }
}
