package com.helpgym.academiaapi.service;

import com.helpgym.academiaapi.model.Academia;
import com.helpgym.academiaapi.repository.AcademiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademiaService {

    private final AcademiaRepository academiaRepository;

    @Autowired
    public AcademiaService(AcademiaRepository academiaRepository) {
        this.academiaRepository = academiaRepository;
    }

    public List<Academia> buscarTodos() {
        return academiaRepository.findAll();
    }

    public Optional<Academia> buscarPorId(Long id) {
        return academiaRepository.findById(id);
    }

    public Academia salvar(Academia academia) {
        return academiaRepository.save(academia);
    }

    public Academia atualizar(Long id, Academia academia) {
        if (academiaRepository.existsById(id)) {
            academia.setId(id);
            return academiaRepository.save(academia);
        }
        return null;
    }

    public void deletar(Long id) {
        academiaRepository.deleteById(id);
    }
}
