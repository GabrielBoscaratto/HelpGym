package com.helpgym.academiaapi.controller;

import com.helpgym.academiaapi.model.Academia;
import com.helpgym.academiaapi.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academia")
public class AcademiaController {

    private final AcademiaService academiaService;

    @Autowired
    public AcademiaController(AcademiaService academiaService) {
        this.academiaService = academiaService;
    }

    @GetMapping
    public ResponseEntity<List<Academia>> buscarTodos() {
        List<Academia> academias = academiaService.buscarTodos();
        return ResponseEntity.ok(academias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Academia> buscarPorId(@PathVariable Long id) {
        Optional<Academia> academia = academiaService.buscarPorId(id);
        return academia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Academia> criar(@Valid @RequestBody Academia academia) {
        Academia novaAcademia = academiaService.salvar(academia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAcademia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Academia> atualizar(@PathVariable Long id, @Valid @RequestBody Academia academia) {
        Academia academiaAtualizada = academiaService.atualizar(id, academia);
        if (academiaAtualizada != null) {
            return ResponseEntity.ok(academiaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Academia> academia = academiaService.buscarPorId(id);
        if (academia.isPresent()) {
            academiaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
