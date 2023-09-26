package com.curso.manytomany2.repository;

import com.curso.manytomany2.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer> {
}
