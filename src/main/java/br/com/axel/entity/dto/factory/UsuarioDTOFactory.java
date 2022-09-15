package br.com.axel.entity.dto.factory;

import br.com.axel.entity.Usuario;
import br.com.axel.entity.dto.UsuarioDTO;

public class UsuarioDTOFactory {

    private static UsuarioDTOFactory usuarioDTOFactory;

    //getInstance
    public static UsuarioDTOFactory getInstance() {
        if (usuarioDTOFactory == null) {
            usuarioDTOFactory = new UsuarioDTOFactory();
        }
        return usuarioDTOFactory;
    }

    //Criar um UsuarioDTO a partir de um Usuario
    public UsuarioDTO entidadeParaDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setSobrenome(usuario.getSobrenome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioDTO.setEndereco(usuario.getEndereco());
        usuarioDTO.setUsuario(usuario.getUsuario());
        usuarioDTO.setSenha(usuario.getSenha());
        return usuarioDTO;
    }
}
