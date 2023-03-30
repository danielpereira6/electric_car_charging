package Classes;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "carros")
public class Veiculos implements Serializable {
    private List<Veiculo> carros;

    public Veiculos() {}

    public Veiculos(List<Veiculo> carros) {
        this.carros = carros;
    }

    public void adicionaVeiculo(Veiculo veiculo) {
        carros.add(veiculo);
    }

    public List<Veiculo> encontraVeiculo() {
        return carros;
    }

    @XmlElement(name="carro")
    public void setVeiculos(List<Veiculo> carros) {
        this.carros = carros;
    }
}
