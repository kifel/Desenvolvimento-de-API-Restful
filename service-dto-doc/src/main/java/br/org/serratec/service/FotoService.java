package br.org.serratec.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.org.serratec.model.Foto;
import br.org.serratec.model.Usuario;
import br.org.serratec.repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public Foto inserir(Usuario usuario, MultipartFile file) throws IOException {

        Foto foto = new Foto();

        foto.setNome(file.getName());
        foto.setTipo(file.getContentType());
        foto.setDados(file.getBytes());
        foto.setUsuario(usuario);

        return fotoRepository.save(foto);
    }

}
