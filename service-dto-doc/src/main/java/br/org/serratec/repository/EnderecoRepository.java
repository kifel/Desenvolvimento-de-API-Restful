package br.org.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    public Optional<Endereco> findByCep(String cep);

}
