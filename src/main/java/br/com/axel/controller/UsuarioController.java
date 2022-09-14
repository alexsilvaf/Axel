package br.com.axel.controller;

import br.com.axel.entity.Usuario;
import br.com.axel.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/id/{idUsuario}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(usuarioService.getById(idUsuario));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Usuario> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(usuarioService.getByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) {
        Usuario usuarioBanco = usuarioService.getById(idUsuario);
        usuarioService.delete(idUsuario);
    }
}
