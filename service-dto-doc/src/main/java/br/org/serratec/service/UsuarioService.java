package br.org.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.dto.UsuarioInserirDTO;
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

    public UsuarioDTO inserir(UsuarioInserirDTO u) {
        if (usuarioRepository.findByEmail(u.getEmail()) != null) {
            throw new EmailException("Email já Existe na base");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(u.getSenha()));
        usuario = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario);
    }
}
