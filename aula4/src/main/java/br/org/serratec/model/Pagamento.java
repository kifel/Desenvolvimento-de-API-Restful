package br.org.serratec.model;

public class Pagamento {

    private Consulta consulta = new Consulta();
    private Exame exame = new Exame();

    public Double calcularProcedimentos(Double valorConsulta, Double valorExame) {
        return consulta.calcularValorConsulta(valorConsulta) + exame.calcularValorExame(valorExame);
    }
}
