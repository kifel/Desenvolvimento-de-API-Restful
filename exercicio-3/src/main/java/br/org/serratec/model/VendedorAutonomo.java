package br.org.serratec.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class VendedorAutonomo extends Vendendor {
    
    @NotNull(message = "Você deve inserir um salario valido")
    private Double comissao;
}
