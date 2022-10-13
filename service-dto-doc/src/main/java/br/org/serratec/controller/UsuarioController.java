package br.org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> inserir(@RequestBody Usuario u) {
        try {
            usuarioService.inserir(u);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.created(uri).body(u);
        }catch (EmailException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
