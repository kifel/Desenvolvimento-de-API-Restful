package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long>{
    
}
