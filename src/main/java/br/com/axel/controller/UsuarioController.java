package br.com.axel.controller;

import br.com.axel.entity.Usuario;
import br.com.axel.entity.dto.UsuarioDTO;
import br.com.axel.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(usuarioService.getById(idUsuario));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioDTO> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(usuarioService.getByNome(nome));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) {
        UsuarioDTO usuarioBanco = usuarioService.getById(idUsuario);
        usuarioService.delete(idUsuario);
    }
}
