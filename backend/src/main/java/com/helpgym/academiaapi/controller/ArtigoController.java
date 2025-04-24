package com.helpgym.academiaapi.controller;

import com.helpgym.academiaapi.model.Artigo;
import com.helpgym.academiaapi.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {

    private final ArtigoService artigoService;

    @Autowired
    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @GetMapping
    public ResponseEntity<List<Artigo>> buscarTodos() {
        List<Artigo> artigos = artigoService.buscarTodos();
        return ResponseEntity.ok(artigos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarPorId(@PathVariable Long id) {
        Optional<Artigo> artigo = artigoService.buscarPorId(id);
        return artigo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artigo> criar(@Valid @RequestBody Artigo artigo) {
        Artigo novoArtigo = artigoService.salvar(artigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoArtigo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artigo> atualizar(@PathVariable Long id, @Valid @RequestBody Artigo artigo) {
        Artigo artigoAtualizado = artigoService.atualizar(id, artigo);
        if (artigoAtualizado != null) {
            return ResponseEntity.ok(artigoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Artigo> artigo = artigoService.buscarPorId(id);
        if (artigo.isPresent()) {
            artigoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
