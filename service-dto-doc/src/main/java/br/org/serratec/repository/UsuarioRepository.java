package br.org.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findByEmail(String email);

    Optional<Usuario> findByNome(String nome);
    
}
