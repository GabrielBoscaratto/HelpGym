package com.helpgym.academiaapi.repository;

import com.helpgym.academiaapi.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
}
