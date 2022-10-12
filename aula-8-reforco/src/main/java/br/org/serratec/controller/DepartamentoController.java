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

import br.org.serratec.model.Departamento;
import br.org.serratec.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping(value= "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento create(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @GetMapping
    public List<Departamento> getDepartamentos() {
        return departamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if (departamento.isPresent()) {
            return ResponseEntity.ok(departamento.get());
        }
        return ResponseEntity.notFound().build();
    }


    
}
