package br.org.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.org.serratec.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    // @Query("SELECT v FROM Vendedor v WHERE v.salario >=:valorMinimo AND v.salario<=:valorMaximo ")
    @Query(nativeQuery = true, value = "SELECT * FROM vendedor WHERE salario BETWEEN :valorMinimo AND :valorMaximo")
    public Page<Vendedor> buscarPorFaixaSalarial(Double valorMinimo, Double valorMaximo, Pageable pageable);
    
}
