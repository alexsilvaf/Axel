package br.com.axel.service;

import br.com.axel.entity.Usuario;
import br.com.axel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public Usuario getByNome(String nome){
        return usuarioRepository.findByNome(nome);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public  Usuario update(Usuario usuario)
    {
        //Verificar se o usuário possui ID
        if(usuario.getIdUsuario() == null)
        {
            throw new RuntimeException("O usuário não possui ID");
        }

        //Verificar que o email e único
        Usuario usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioBanco != null && !usuarioBanco.getIdUsuario().equals(usuario.getIdUsuario()))
        {
            throw new RuntimeException("O email informado já está cadastrado");
        }


        return usuarioRepository.save(usuario);
    }

    public void delete(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
