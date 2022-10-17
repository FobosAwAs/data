package dto;

public class DTOorden {

    private double id_orden;
    private double cantidad;
    private int cliente;
    private int agente;

    public double getId_orden() {
        return id_orden;
    }

    public void setId_orden(double id_orden) {
        this.id_orden = id_orden;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getAgente() {
        return agente;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    
}
