package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente", schema = "public")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank(message = "Preencha o nome do cliente")
    @Size(max = 60, min = 2, message = "Tamanho do campo invalido")
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "Preencha o cpf do cliente")
    @Size(min = 11, max = 11, message = "Tamanho do campo invalido")
    @Column(nullable = false, length = 11)
    private String cpf;

    @NotBlank(message = "Preencha o email do cliente")
    @Size(max = 50, message = "Tamanho do campo invalido")
    @Column(nullable = false, length = 50)
    private String email;

    @NotBlank(message = "Preencha o data de nascimento do cliente")
    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
                + dataNascimento + "]";
    }

}
