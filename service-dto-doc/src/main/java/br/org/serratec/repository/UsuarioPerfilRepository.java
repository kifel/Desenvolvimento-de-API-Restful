package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.UsuarioPerfil;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long>{
    
}
