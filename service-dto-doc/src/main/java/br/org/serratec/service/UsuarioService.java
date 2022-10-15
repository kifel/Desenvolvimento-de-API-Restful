package br.org.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosDTO.add(new UsuarioDTO(usuario));
        }

        return usuariosDTO;

        // return usuarios.stream().map(usuario -> new
        // UsuarioDTO(usuario)).collect(Collectors.toList());
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
