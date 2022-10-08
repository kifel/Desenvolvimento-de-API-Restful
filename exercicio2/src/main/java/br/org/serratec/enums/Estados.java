package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Estados {
    AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE("Ceará"), ES("Espírito Santo"), GO("Goiás"),
    MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG("Minas Gerais"), PA("Pará"), PB("Paraíba"),
    PR("Paraná"), PE("Pernambuco"), PI("Piauí"), RJ("Rio de Janeiro"), RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"), RO("Rondônia"), RR("Roraima"), SC("Santa Catarina"), SP("São Paulo"), SE("Sergipe"),
    TO("Tocantins"), DF("Distrito Federal");

    private String tipo;

    private Estados(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonCreator
    public static Estados verifica(String valor) throws EnumValidationException {
        for (Estados estados : Estados.values()) {
            if (valor.equals(estados.name())) {
                return estados;
            }
        }
        throw new EnumValidationException("Preencha o Estados corretamente");
    }
}
