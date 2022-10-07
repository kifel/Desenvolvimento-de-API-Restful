package br.org.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long id;

    @NotBlank(message = "Você deve colocar a placa do carro")
    @Size(max = 8)
    @Column(nullable = false, length = 8)
    private String placa;

    @NotBlank(message = "Você deve colocar a marca do carro")
    @Size(max = 30)
    @Column(nullable = false, length = 30)
    private String marca;

    @NotBlank(message = "Você deve colocar a modelo do carro")
    @Size(max = 40)
    @Column(nullable = false, length = 40)
    private String modelo;
}
