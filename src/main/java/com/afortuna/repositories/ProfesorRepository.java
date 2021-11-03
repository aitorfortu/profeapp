package com.afortuna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afortuna.domains.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
