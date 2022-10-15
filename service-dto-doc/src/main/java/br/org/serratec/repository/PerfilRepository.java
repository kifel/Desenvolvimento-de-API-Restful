package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
}
