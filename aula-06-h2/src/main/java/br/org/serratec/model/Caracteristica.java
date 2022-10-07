package br.org.serratec.model;

import br.org.serratec.enums.Categoria;
import br.org.serratec.enums.Combustivel;

public class Caracteristica {
    private String renavam;
    private String chassi;
    private Integer ano;

    private Categoria categoria;
    private Combustivel Combustivel;
    
    public String getRenavam() {
        return renavam;
    }
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }
    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Combustivel getCombustivel() {
        return Combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        Combustivel = combustivel;
    }
}
