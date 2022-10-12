package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
    
}
