package br.org.serratec.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

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

    protected String nome;

    protected String email;

    protected Double salario;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendedor")
    protected List<LancamentoVendas> lancamentoVendas;

}
