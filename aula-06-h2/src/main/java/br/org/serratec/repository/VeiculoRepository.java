package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
}
