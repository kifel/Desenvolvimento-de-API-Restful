package br.org.serratec.enums;

public enum Combustivel {
    ALCOOL(1, "ALCOOL"), GASOLINA(2, "GASOLINA"), DIESEL(3, "DIESEL"), FLEX(4, "FLEX");

    private Integer codigo;
    private String tipo;

    private Combustivel(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
