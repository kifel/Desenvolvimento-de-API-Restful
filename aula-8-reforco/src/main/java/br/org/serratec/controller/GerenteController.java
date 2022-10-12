package br.org.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Gerente;
import br.org.serratec.repository.GerenteRepository;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteRepository gerenteRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Gerente create(@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @GetMapping
    public List<Gerente> getGerente() {
        return gerenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> getGerente(@PathVariable Long id) {
        Optional<Gerente> gerente = gerenteRepository.findById(id);
        if (gerente.isPresent()) {
            return ResponseEntity.ok(gerente.get());
        }
        return ResponseEntity.notFound().build();
    }
}
