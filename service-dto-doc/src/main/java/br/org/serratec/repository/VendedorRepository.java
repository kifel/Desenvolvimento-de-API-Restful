package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
