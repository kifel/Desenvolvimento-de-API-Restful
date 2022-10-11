package br.org.serratec.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Documento {
   
    @Id
    @OneToOne
    @JoinColumn(name="id")
    private Pessoa pessoa;
    
    private String cpf;
    private String ci;
    private String orgaoExpedidor;
    private String tituloEleitor;
    private String certificadoReservista;
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }
    public String getTituloEleitor() {
        return tituloEleitor;
    }
    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }
    public String getCertificadoReservista() {
        return certificadoReservista;
    }
    public void setCertificadoReservista(String certificadoReservista) {
        this.certificadoReservista = certificadoReservista;
    }
}
