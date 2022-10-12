package br.org.serratec.model;

import javax.persistence.Entity;

@Entity
public class Gerente extends Funcionario{
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
