package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Estados {
    ACRE("AC"), AlAGOAS("AL"), AMAPÁ("AP"), AMAZONAS("AM"), BAHIA("BA"), CEARÁ("CE"), ESPÍRITO_SANTO("ES"), GOIÁS("GO"),
    MARANHÃO("MA"), MATO_GROSSO("MT"), MATO_GROSSO_DO_SUL("MS"), MINAS_GERAIS("MG"), PARÁ("PA"), PARAÍBA("PB"),
    PARANÁ("PR"), PERNAMBUCO("PE"), PIAUÍ("PI"), RIO_DE_JANEIRO("RJ"), RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"), RONDÔNIA("RO"), RORAIMA("RR"), SANTA_CATARINA("SC"), SÃO_PAULO("SP"), SERGIPE("SE"),
    TOCANTINS("TO"), DISTRITO_FEDERAL("DF");

    private String sigla;

    private Estados(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @JsonCreator
    public static Estados verifica(String valor) throws EnumValidationException {
        for (Estados estados : Estados.values()) {
            if (valor.equals(estados.getSigla())) {
                return estados;
            }
        }
        throw new EnumValidationException("Preencha o Estados corretamente");
    }
}
