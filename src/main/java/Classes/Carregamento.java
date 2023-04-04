package Classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name="carregamento")
public class Carregamento implements Serializable {

    @XmlAttribute(name="id")
    private int id;

    @XmlElement(name="data_carregamento")
    private String data_carregamento; // Dia do carregamento

    @XmlElement(name="hora_inicio")
    private String hora_inicio;

    @XmlElement(name="duracao")
    private String duracao;

    @XmlElement(name="quantidade")
    private double quantidade; // kWh

    @XmlElement(name="preco")
    private double preco; // €

    @XmlElement(name="posto")
    private Posto dados_posto;

    @XmlElement(name="carro")
    private Veiculo veiculo;

    /*tipo de posto já indica o tipo de carregamento*/  // private String tipo_carregamento; // normal (<22kW); rápido (>50kW)

    public Carregamento() {}

    public Carregamento(int id, String data_carregamento, String hora_inicio, String duracao, double quantidade, double preco, Posto dados_posto, Veiculo veiculo) {
        this.id = id;
        this.data_carregamento = data_carregamento;
        this.hora_inicio = hora_inicio;
        this.duracao = duracao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dados_posto = dados_posto;
        this.veiculo = veiculo;
    }

    public int getId() {
        return id;
    }

    public String getDataCarregamento() {
        return data_carregamento;
    }

    public String getHoraInicio() {
        return hora_inicio;
    }

    public String getDuracao() {
        return duracao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public Posto getDadosPosto() {
        return dados_posto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Carregamento: {" +
                "id=" + id +
                ", data_carregamento='" + data_carregamento + '\'' +
                ", hora_inicio='" + hora_inicio + '\'' +
                ", duracao='" + duracao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", dados_posto=" + dados_posto +
                ", veiculo=" + veiculo +
            '}';
    }
}
