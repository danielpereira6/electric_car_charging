package Classes;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name="localizacao")
public class Localizacao implements Serializable {
    @XmlElement(name="latitude")
    private Double lat;

    @XmlElement(name="longitude")
    private Double lon;

    public Localizacao(){}
    public Localizacao(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "["+lat+", "+lon+"]";
    }
}
