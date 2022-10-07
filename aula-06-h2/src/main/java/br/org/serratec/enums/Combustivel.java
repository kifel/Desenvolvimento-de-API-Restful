package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

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

    @JsonCreator
    public static Combustivel verifica(String valor) throws EnumValidationException {
        for (Combustivel combustivel : Combustivel.values()) {
            if (valor.equals(combustivel.name())) {
                return combustivel;
            }
        }
        throw new EnumValidationException("Preencha o combustivel corretamente");
    }

}
