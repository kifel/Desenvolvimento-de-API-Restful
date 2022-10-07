package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Categoria {
    HATCH, SEDAN, PICAPE, SUV, MINIVAN, CONVERSIVEL;

    @JsonCreator
    public static Categoria verifica(String valor) throws EnumValidationException {
        for (Categoria categoria : Categoria.values()) {
            if (valor.equals(categoria.name())) {
                return categoria;
            }
        }
        throw new EnumValidationException("Preencha a categoria corretamente");
    }
}
