package com.afortuna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afortuna.domains.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
