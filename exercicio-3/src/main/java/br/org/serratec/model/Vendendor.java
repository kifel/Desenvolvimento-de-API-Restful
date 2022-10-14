package br.org.serratec.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class Vendendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long codigo;

    @NotBlank(message = "Você deve colocar um nome")
    @Size(max = 60, min = 2, message = "Tamanho do campo invalido")
    protected String nome;

    @Email(message = "Você inseriu um email não valido")
    protected String email;

    @NotNull(message = "Você deve inserir um salario valido")
    protected Double salario;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendedor")
    protected List<LancamentoVendas> lancamentoVendas;

}
