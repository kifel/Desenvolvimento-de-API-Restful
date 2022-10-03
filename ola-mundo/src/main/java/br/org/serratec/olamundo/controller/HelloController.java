package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping(value = "/")
    public String GetMetHodName() {
        return "Ola Mundo VsCode";
    }

    @GetMapping(value = "/resposta")
    public String resposta() {
        return "Oque está fazendo aqui meu caro amigo";
    }

    @GetMapping(value = "/converter")
    public String converter(@RequestParam String name) {
        return name.toUpperCase();
    }

    // RECURSO DE SOMA

    @GetMapping(value = "/soma")
    public Double soma(@RequestParam Double num1, @RequestParam Double num2) {
        return num1 + num2;
    }

}
