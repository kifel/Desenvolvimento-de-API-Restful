package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Logradouro {
    RUA, AVENIDA, PARQUE, JARDIM, ESTRADA, SETOR, VILA;

    @JsonCreator
    public static Logradouro verifica(String valor) throws EnumValidationException {
        for (Logradouro logradouro : Logradouro.values()) {
            if (valor.equals(logradouro.name())) {
                return logradouro;
            }
        }
        throw new EnumValidationException("Preencha o logradouro corretamente");
    }
}
