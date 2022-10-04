package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.olamundo.model.Veiculo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private static List<Veiculo> veiculo = new ArrayList<>();

    static {
        veiculo.add(new Veiculo(1, "Nissan", "GTR-R34"));
        veiculo.add(new Veiculo(2, "Silvia", "S15"));
        veiculo.add(new Veiculo(3, "Mazda", "RX-7"));
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculo;
    }

    @GetMapping("{id}")
    public Veiculo buscar(@PathVariable Integer id) {
        return veiculo.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

}
