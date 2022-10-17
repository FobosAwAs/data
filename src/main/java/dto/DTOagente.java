package dto;

public class DTOagente {

    private int id_agente;
    private String name_agente;
    private String area_trabajo;
    private String telefono;
    private String pais;

    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) {
        this.id_agente = id_agente;
    }

    public String getName_agente() {
        return name_agente;
    }

    public void setName_agente(String name_agente) {
        this.name_agente = name_agente;
    }

    public String getArea_trabajo() {
        return area_trabajo;
    }

    public void setArea_trabajo(String area_trabajo) {
        this.area_trabajo = area_trabajo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
