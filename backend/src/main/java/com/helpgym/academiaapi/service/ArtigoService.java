package com.helpgym.academiaapi.service;

import com.helpgym.academiaapi.model.Artigo;
import com.helpgym.academiaapi.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    private final ArtigoRepository artigoRepository;

    @Autowired
    public ArtigoService(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }

    public List<Artigo> buscarTodos() {
        return artigoRepository.findAll();
    }

    public Optional<Artigo> buscarPorId(Long id) {
        return artigoRepository.findById(id);
    }

    public Artigo salvar(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public Artigo atualizar(Long id, Artigo artigo) {
        if (artigoRepository.existsById(id)) {
            artigo.setId(id);
            return artigoRepository.save(artigo);
        }
        return null;
    }

    public void deletar(Long id) {
        artigoRepository.deleteById(id);
    }
}
