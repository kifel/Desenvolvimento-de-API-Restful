package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "Você deve inserir uma data correta")
    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @NotNull(message = "Você deve inserir um valor valido")
    private Double valor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "codigo_vendedor")
    private VendedorAutonomo vendedor;

}
