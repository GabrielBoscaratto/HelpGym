package com.helpgym.academiaapi.service;

import com.helpgym.academiaapi.model.Treinamento;
import com.helpgym.academiaapi.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TreinamentoService {

    private final TreinamentoRepository treinamentoRepository;

    @Autowired
    public TreinamentoService(TreinamentoRepository treinamentoRepository) {
        this.treinamentoRepository = treinamentoRepository;
    }

    public List<Treinamento> buscarTodos() {
        return treinamentoRepository.findAll();
    }

    public Optional<Treinamento> buscarPorId(Long id) {
        return treinamentoRepository.findById(id);
    }

    public Treinamento salvar(Treinamento treinamento) {
        if (treinamento.getDataCriacao() == null) {
            treinamento.setDataCriacao(LocalDateTime.now());
        }
        return treinamentoRepository.save(treinamento);
    }

    public Treinamento atualizar(Long id, Treinamento treinamento) {
        if (treinamentoRepository.existsById(id)) {
            Optional<Treinamento> treinamentoExistente = treinamentoRepository.findById(id);
            if (treinamentoExistente.isPresent()) {
                treinamento.setId(id);
                treinamento.setDataCriacao(treinamentoExistente.get().getDataCriacao());
                return treinamentoRepository.save(treinamento);
            }
        }
        return null;
    }

    public void deletar(Long id) {
        treinamentoRepository.deleteById(id);
    }
}
