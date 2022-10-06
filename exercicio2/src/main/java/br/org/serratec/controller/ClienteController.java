package br.org.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Cliente;
import br.org.serratec.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PostMapping(value = "/createAll")
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<Cliente> createTodos(@RequestBody List<Cliente> clientes) {
        return clienteRepository.saveAll(clientes);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping(value = "/patch/{id}")
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteAtual = clienteRepository.findById(id).get();
        BeanUtils.copyProperties(cliente, clienteAtual, "id");
        return clienteRepository.save(clienteAtual);
    }
}
