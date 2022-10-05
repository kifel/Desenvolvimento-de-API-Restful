package br.org.serratec.model;

import org.springframework.stereotype.Component;

@Component
public class Pagamento {

    private Consulta consulta;
    private Exame exame;

    public Pagamento(Consulta consulta, Exame exame) {
        this.consulta = consulta;
        this.exame = exame;
    }

    public Double calcularProcedimentos(Double valorConsulta, Double valorExame) {
        return consulta.calcularValorConsulta(valorConsulta) + exame.calcularValorExame(valorExame);
    }
}
