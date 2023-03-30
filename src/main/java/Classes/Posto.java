package Classes;

import java.util.ArrayList;

public class Posto {
    private String id;
    private String nome;
    private String descricao;
    private String tipo_posto; // normal (<22kW); rápido (>50kW)
    private ArrayList<Double> coords; // lat + long
}
