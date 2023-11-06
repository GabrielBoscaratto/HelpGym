package com.helpgym.academiaapi.controller;

import com.helpgym.academiaapi.model.Treinamento;
import com.helpgym.academiaapi.service.TreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/treinamentos")
public class TreinamentoController {

    private final TreinamentoService treinamentoService;

    @Autowired
    public TreinamentoController(TreinamentoService treinamentoService) {
        this.treinamentoService = treinamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Treinamento>> buscarTodos() {
        List<Treinamento> treinamentos = treinamentoService.buscarTodos();
        return ResponseEntity.ok(treinamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treinamento> buscarPorId(@PathVariable Long id) {
        Optional<Treinamento> treinamento = treinamentoService.buscarPorId(id);
        return treinamento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Treinamento> criar(@Valid @RequestBody Treinamento treinamento) {
        Treinamento novoTreinamento = treinamentoService.salvar(treinamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTreinamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treinamento> atualizar(@PathVariable Long id, @Valid @RequestBody Treinamento treinamento) {
        Treinamento treinamentoAtualizado = treinamentoService.atualizar(id, treinamento);
        if (treinamentoAtualizado != null) {
            return ResponseEntity.ok(treinamentoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Treinamento> treinamento = treinamentoService.buscarPorId(id);
        if (treinamento.isPresent()) {
            treinamentoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
