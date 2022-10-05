package br.org.serratec.model;

import org.springframework.stereotype.Component;

@Component
public class Exame {

    public Double calcularValorExame(Double valor) {
        return valor = valor * 1.05;
    }
}
