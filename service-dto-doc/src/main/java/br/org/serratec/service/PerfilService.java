package br.org.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.model.Perfil;
import br.org.serratec.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil buscar(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.get();
    }
}
