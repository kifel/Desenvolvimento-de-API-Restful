package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.olamundo.model.Veiculo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private static List<Veiculo> veiculos = new ArrayList<>();

    static {
        veiculos.add(new Veiculo(1, "Nissan", "GTR-R34"));
        veiculos.add(new Veiculo(2, "Silvia", "S15"));
        veiculos.add(new Veiculo(3, "Mazda", "RX-7"));
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    @GetMapping("{id}")
    public Veiculo buscar(@PathVariable Integer id) {
        return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping(value = "cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Veiculo create(@RequestBody Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    @DeleteMapping(value= "/delete/{id}")
    public Veiculo delete(@PathVariable Integer id) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getId().equals(id)) {
                return veiculos.remove(i);
            }
        }
        return null;
    }

    @PatchMapping(value = "/patch/{id}")
    public Veiculo update(@RequestBody Veiculo veiculo, @PathVariable Integer id) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getId().equals(id)) {
                veiculos.set(i, veiculo);
                return veiculo;
            }
        }
        return null;
    }

}
