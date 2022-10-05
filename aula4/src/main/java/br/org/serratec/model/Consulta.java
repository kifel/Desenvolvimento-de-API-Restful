package br.org.serratec.model;

import org.springframework.stereotype.Component;

@Component
public class Consulta {

    public Double calcularValorConsulta(Double valor) {
        return valor = valor * 1.10;
    }
}
