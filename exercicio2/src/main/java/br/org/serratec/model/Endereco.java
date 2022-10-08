package br.org.serratec.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.org.serratec.enums.Estados;
import br.org.serratec.enums.Logradouro;

@Embeddable
public class Endereco {

    @Enumerated(EnumType.STRING)
    private Logradouro logradouro;
    
    @Enumerated(EnumType.STRING)
    private Estados estado;
    
    private String numero;
    private String bairro;
    private String cidade;
    
    public Logradouro getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
    public Estados getEstado() {
        return estado;
    }
    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


}
