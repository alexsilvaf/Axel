package br.com.axel.service;

import br.com.axel.entity.Usuario;
import br.com.axel.domain.UsuarioDomain;
import br.com.axel.entity.dto.UsuarioDTO;
import br.com.axel.entity.dto.factory.UsuarioDTOFactory;
import br.com.axel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        //Para cada usuario na lista, criar um UsuarioDTO e adicionar na lista de UsuarioDTO através do método entidadeParaDTO da classe UsuarioDTOFactory
        return usuarioList.stream().map(usuario -> new UsuarioDTOFactory().getInstance().entidadeParaDTO(usuario)).collect(Collectors.toList());

    }

    public UsuarioDTO getById(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        return UsuarioDTOFactory.getInstance().entidadeParaDTO(usuario);
    }

    public UsuarioDTO getByNome(String nome) {
        Usuario usuario = usuarioRepository.findByNome(nome);
        return UsuarioDTOFactory.getInstance().entidadeParaDTO(usuario);
    }

    public UsuarioDTO save(UsuarioDTO usuario) {
        usuario.setNome(usuario.getNome().toLowerCase());
        //Criar um Usuario a partir de um UsuarioDomain
        Usuario newUsuario = UsuarioDomain.getInstance().criarEntidade(usuario);
        usuarioRepository.save(newUsuario);
        return UsuarioDTOFactory.getInstance().entidadeParaDTO(newUsuario);
    }

    public UsuarioDTO update(UsuarioDTO usuario) {
        //Verificar se o usuário possui ID
        if (usuario.getIdUsuario() == null) {
            throw new RuntimeException("O usuário não possui ID");
        }

        //Verificar que o email e único
        Usuario usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioBanco != null && !usuarioBanco.getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new RuntimeException("O email informado já está cadastrado");
        }

        //Criar um Usuario a partir de um UsuarioDomain
        Usuario newUsuario = UsuarioDomain.getInstance().criarEntidade(usuario);
        usuarioRepository.save(newUsuario);
        return UsuarioDTOFactory.getInstance().entidadeParaDTO(newUsuario);
    }

    public void delete(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
