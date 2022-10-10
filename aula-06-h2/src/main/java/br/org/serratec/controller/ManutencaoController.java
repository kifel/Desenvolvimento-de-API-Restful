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

import br.org.serratec.model.Manutencao;
import br.org.serratec.repository.ManutencaoRepository;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Manutencao inserir(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    @GetMapping
    public List<Manutencao> getManutencaoList() {
        return manutencaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencao = manutencaoRepository.findById(id);
        if (manutencao.isPresent()) {
            return ResponseEntity.ok(manutencao.get());
        }
        return ResponseEntity.notFound().build();
    }
}
