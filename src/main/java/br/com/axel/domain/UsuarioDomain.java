package br.com.axel.domain;

import br.com.axel.entity.Usuario;
import br.com.axel.entity.dto.UsuarioDTO;

public class UsuarioDomain {

    private static UsuarioDomain usuarioDomain;

    public static UsuarioDomain getInstance() {
        if (usuarioDomain == null) {
            usuarioDomain = new UsuarioDomain();
        }
        return usuarioDomain;
    }

    //Criar um Usuario a partir de um UsuarioDTO
    public Usuario criarEntidade(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
    }
}
