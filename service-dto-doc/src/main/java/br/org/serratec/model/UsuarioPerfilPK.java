package br.org.serratec.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class UsuarioPerfilPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_perfil")
    private Perfil perfil;
    
}
