package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class LancamentoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venda")
    private Long codigoVenda;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "codigo_vendedor")
    private VendedorAutonomo vendedor;

}
