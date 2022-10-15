package br.org.serratec.dto;

import br.org.serratec.model.Usuario;
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

    public UsuarioInserirDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

}
