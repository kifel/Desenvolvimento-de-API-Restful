package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("{matricula}")
    public Aluno buscar(@PathVariable String matricula) {
        return alunos.stream().filter(aluno -> aluno.getMatricula().equals(matricula)).findFirst().orElse(null);
    }

    @PostMapping(value = "/cadastro")
    public Aluno inserir(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    @DeleteMapping("/delete/{matricula}")
    public Aluno delete(@PathVariable String matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matricula)) {
                return alunos.remove(i);
            }
        }
        return null;
    }

}
