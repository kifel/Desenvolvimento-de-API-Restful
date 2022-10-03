package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.olamundo.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private static List<Aluno> alunos = new ArrayList<>();

    static {
        alunos.add(new Aluno("123", "Kifel", "k@gmail.com"));
        alunos.add(new Aluno("321", "Maria", "a@gmail.com"));
        alunos.add(new Aluno("124", "Jose", "j@gmail.com"));
        alunos.add(new Aluno("126", "Carlos", "c@gmail.com"));
    }

    @GetMapping
    public List<Aluno> getAlunos() {
        return alunos;
    }

}
