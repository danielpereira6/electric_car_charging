package Classes;

import java.io.Serializable;
import java.util.HashMap;

public class Cliente implements Serializable {
    public static HashMap<Integer, Cliente> clientes = new HashMap<>();
    private int contribuinte;
    private String name;
    private String birthday;

    public Cliente() {
        // Add clients
        clientes.put(1, new Cliente(999999999, "Daniel", "1997-12-06"));
        clientes.put(2, new Cliente(123456789, "Andre", "2000-12-22"));
        clientes.put(3, new Cliente(987654321, "Gabo", "1998-05-11"));
        clientes.put(4, new Cliente(666666666, "Pedro", "1996-06-06"));
    }

    public Cliente(int contribuinte, String name, String birthday) {
        this.contribuinte = contribuinte;
        this.name = name;
        this.birthday = birthday;
    }

    public static HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(HashMap<Integer, Cliente> clientes) {
        Cliente.clientes = clientes;
    }

    public int getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(int contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
