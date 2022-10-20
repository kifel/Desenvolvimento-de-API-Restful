package br.org.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Vendedor;
import br.org.serratec.repository.VendedorRepository;
import br.org.serratec.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    VendedorRepository vendedorRepository;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar() {
        return ResponseEntity.ok(vendedorService.listar());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Vendedor>> listarPorPagina(
            @PageableDefault(sort = "nome", direction = Direction.DESC, size = 8) Pageable pageable) {
        return ResponseEntity.ok(vendedorService.listarPorPagina(pageable));
    }

    @GetMapping("/salario")
    public ResponseEntity<Page<Vendedor>> buscarPorFaixaSalarial(@RequestParam Double valorMinimo,
            @RequestParam Double valorMaximo, Pageable pageable) {
        return ResponseEntity.ok(vendedorRepository.buscarPorFaixaSalarial(valorMinimo, valorMaximo, pageable));
    }

}
