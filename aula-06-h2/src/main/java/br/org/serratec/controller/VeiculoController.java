package br.org.serratec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Veiculo;
import br.org.serratec.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
