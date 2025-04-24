package com.helpgym.academiaapi.controller;

import com.helpgym.academiaapi.model.Patrocinador;
import com.helpgym.academiaapi.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    @Autowired
    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public ResponseEntity<List<Patrocinador>> buscarTodos() {
        List<Patrocinador> patrocinadores = patrocinadorService.buscarTodos();
        return ResponseEntity.ok(patrocinadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrocinador> buscarPorId(@PathVariable Long id) {
        Optional<Patrocinador> patrocinador = patrocinadorService.buscarPorId(id);
        return patrocinador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patrocinador> criar(@Valid @RequestBody Patrocinador patrocinador) {
        Patrocinador novoPatrocinador = patrocinadorService.salvar(patrocinador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPatrocinador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrocinador> atualizar(@PathVariable Long id, @Valid @RequestBody Patrocinador patrocinador) {
        Patrocinador patrocinadorAtualizado = patrocinadorService.atualizar(id, patrocinador);
        if (patrocinadorAtualizado != null) {
            return ResponseEntity.ok(patrocinadorAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Patrocinador> patrocinador = patrocinadorService.buscarPorId(id);
        if (patrocinador.isPresent()) {
            patrocinadorService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
