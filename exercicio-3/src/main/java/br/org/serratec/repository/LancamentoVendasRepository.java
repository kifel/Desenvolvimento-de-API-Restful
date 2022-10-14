package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.LancamentoVendas;

public interface LancamentoVendasRepository  extends JpaRepository<LancamentoVendas, Long>{
    
}
