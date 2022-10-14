package br.org.serratec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.model.LancamentoVendas;
import br.org.serratec.service.LancamentoVendasService;

@RestController
@RequestMapping("/lancamentovendas")
public class LancamentoVendasController {
    
    @Autowired
    private LancamentoVendasService lancamentoVendasService;

    @GetMapping
    public ResponseEntity<List<LancamentoVendas>> listar() {
        return ResponseEntity.ok(lancamentoVendasService.getLancamentoVendasList());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> inserir(@Valid @RequestBody LancamentoVendas l) {
        lancamentoVendasService.inserir(l);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(l.getCodigoVenda()).toUri();
        return ResponseEntity.created(uri).body(l);
    }
}
