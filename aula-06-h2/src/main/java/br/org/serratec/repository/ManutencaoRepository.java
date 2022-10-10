package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{
    
}
