package br.org.serratec.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.config.MailConfig;
import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.dto.UsuarioInserirDTO;
import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;
import br.org.serratec.repository.UsuarioPerfilRepository;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioPerfilRepository usuarioPerfilRepository;

    @Autowired
    private PerfilService perfilService;
    
    @Autowired
    private FotoService fotoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MailConfig mailConfig;

    private UsuarioDTO inserirUriImagem(Usuario usuario) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/{id}/foto")
                .buildAndExpand(usuario.getId()).toUri();

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setUri(uri.toString());

        return dto;
    }

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosDTO.add(inserirUriImagem(usuario));
        }

        return usuariosDTO;

        // return usuarios.stream().map(usuario -> new
        // UsuarioDTO(usuario)).collect(Collectors.toList());
    }

    public UsuarioDTO inserir(UsuarioInserirDTO u, MultipartFile file) throws IOException {
        if (usuarioRepository.findByEmail(u.getEmail()) != null) {
            throw new EmailException("Email já Existe na base");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(u.getSenha()));
        fotoService.inserir(usuarioRepository.save(usuario), file);

        for (UsuarioPerfil up : u.getUsuariosPerfil()) {
            up.setUsuario(usuario);
            up.setPerfil(perfilService.buscar(up.getPerfil().getId()));
            up.setDataCriacao(LocalDate.now());
        }

        usuarioPerfilRepository.saveAll(u.getUsuariosPerfil());

        // mailConfig.sendEmail(u.getEmail(), "Cadastro de Usuário", usuario.toString());

        return inserirUriImagem(usuario);
    }
}
