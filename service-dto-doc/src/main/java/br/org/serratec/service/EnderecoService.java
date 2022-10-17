package br.org.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.dto.EnderecoDTO;
import br.org.serratec.model.Endereco;
import br.org.serratec.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO buscar(String cep) {
        Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));

        if (endereco.isPresent()) {
            return new EnderecoDTO(endereco.get());

        } else {
            RestTemplate rs = new RestTemplate();
            String uri = "http://viacep.com.br/ws/" + cep + "/json";
            Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));

            if(enderecoViaCep.get().getCep() != null) {

                String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
                enderecoViaCep.get().setCep(cepSemTraco);
                return inserir(enderecoViaCep.get());
            } else {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }

    }

    public EnderecoDTO inserir(Endereco endereco) {
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }

}
