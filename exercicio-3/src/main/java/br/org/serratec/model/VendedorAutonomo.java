package br.org.serratec.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class VendedorAutonomo extends Vendendor {
    private Double comissao;
}
