package dto;

public class DTOcliente {

    private int code_cliente;
    private String name_cliente;
    private String ciudad;

    public int getCode_cliente() {
        return code_cliente;
    }

    public void setCode_cliente(int code_cliente) {
        this.code_cliente = code_cliente;
    }

    public String getName_cliente() {
        return name_cliente;
    }

    public void setName_cliente(String name_cliente) {
        this.name_cliente = name_cliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "DTOcliente{" +
                "code_cliente=" + code_cliente +
                ", name_cliente='" + name_cliente + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
