package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

    @EmbeddedId
    private UsuarioPerfilPK id = new UsuarioPerfilPK();

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataCriacao) {
        id.setUsuario(usuario);
        id.setPerfil(perfil);
        this.dataCriacao = dataCriacao;
    }

    public void setUsuario(Usuario usuario) {
        id.setUsuario(usuario);
    }

    public void setPerfil(Perfil perfil) {
        id.setPerfil(perfil);
    }

    public Usuario getUsuario() {
        return id.getUsuario();
    }

    public Perfil getPerfil() {
        return id.getPerfil();
    }

}
