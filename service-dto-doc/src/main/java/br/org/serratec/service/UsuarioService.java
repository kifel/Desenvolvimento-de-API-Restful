package br.org.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario inserir(Usuario u) {
        Usuario usuario = usuarioRepository.findByEmail(u.getEmail());
        if (usuario != null) {
            throw new EmailException("Email já Existe na base");
        }
        u.setSenha(bCryptPasswordEncoder.encode(u.getSenha()));
        return usuarioRepository.save(u);
    }
}
