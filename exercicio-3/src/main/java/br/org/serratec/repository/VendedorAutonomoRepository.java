package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.VendedorAutonomo;

public interface VendedorAutonomoRepository extends JpaRepository<VendedorAutonomo, Long> {
    
}
