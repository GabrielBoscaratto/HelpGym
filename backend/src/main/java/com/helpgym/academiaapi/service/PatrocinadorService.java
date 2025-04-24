package com.helpgym.academiaapi.service;

import com.helpgym.academiaapi.model.Patrocinador;
import com.helpgym.academiaapi.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {

    private final PatrocinadorRepository patrocinadorRepository;

    @Autowired
    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    public List<Patrocinador> buscarTodos() {
        return patrocinadorRepository.findAll();
    }

    public Optional<Patrocinador> buscarPorId(Long id) {
        return patrocinadorRepository.findById(id);
    }

    public Patrocinador salvar(Patrocinador patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    public Patrocinador atualizar(Long id, Patrocinador patrocinador) {
        if (patrocinadorRepository.existsById(id)) {
            patrocinador.setId(id);
            return patrocinadorRepository.save(patrocinador);
        }
        return null;
    }

    public void deletar(Long id) {
        patrocinadorRepository.deleteById(id);
    }
}
