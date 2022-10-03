package br.org.serratec.olamundo.model;

public class Aluno {
    private String matricula;
    private String name;
    private String email;

    public Aluno(String matricula, String name, String email) {
        this.matricula = matricula;
        this.name = name;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome= " + name + ", email=" + email + "]";
    }
}
