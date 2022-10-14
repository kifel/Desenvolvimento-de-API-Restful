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

import br.org.serratec.service.VendedorService;
import br.org.serratec.model.VendedorAutonomo;

@RestController
@RequestMapping("/vendedores")
public class VendedorAutonomoController {
    
    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorAutonomo>> listar() {
        return ResponseEntity.ok(vendedorService.listar());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> inserir(@Valid @RequestBody VendedorAutonomo v){
        vendedorService.inserir(v);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getCodigo()).toUri();
            return ResponseEntity.created(uri).body(v);
    }
}
