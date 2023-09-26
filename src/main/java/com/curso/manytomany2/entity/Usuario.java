package com.curso.manytomany2.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "usuario")
    private Set<Suscripcion> suscripciones = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Suscripcion> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(Set<Suscripcion> suscripciones) {
        this.suscripciones = suscripciones;
    }
}
