package br.com.axel.repository;

import br.com.axel.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByNome(String nome);
    public Usuario findByEmail(String email);
}
