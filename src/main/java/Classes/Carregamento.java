package Classes;

import java.util.Date;

public class Carregamento {
    private int id;
    private Date data_carregamento; // Dia do carregamento
    private String hora_inicio;
    private String hora_fim;
    private double quantidade; // kWh
    private double consumido; // €
    private Posto dados_posto;
    private Veiculo veiculo;
    /*tipo de posto já indica o tipo de carregamento*/  // private String tipo_carregamento; // normal (<22kW); rápido (>50kW)
}
