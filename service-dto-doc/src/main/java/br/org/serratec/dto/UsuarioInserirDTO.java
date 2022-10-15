package br.org.serratec.dto;

import java.util.HashSet;
import java.util.Set;

import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsuarioInserirDTO {
    
    private String nome;
    private String email;
    private String senha;

    private Set<UsuarioPerfil> usuariosPerfil = new HashSet<>();

    public UsuarioInserirDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

}
