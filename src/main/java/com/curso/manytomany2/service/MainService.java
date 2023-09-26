package com.curso.manytomany2.service;

import com.curso.manytomany2.entity.Canal;
import com.curso.manytomany2.entity.Suscripcion;
import com.curso.manytomany2.entity.Usuario;
import com.curso.manytomany2.repository.CanalRepository;
import com.curso.manytomany2.repository.SuscripcionRepository;
import com.curso.manytomany2.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MainService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CanalRepository canalRepository;

    @Autowired
    SuscripcionRepository suscripcionRepository;

    public void createSubscription(int idUser, int idCanal){
        Usuario usuario = usuarioRepository.findById(idUser).get();
        Canal canal = canalRepository.findById(idCanal).get();
        Suscripcion suscripcion = new Suscripcion(usuario, canal);
        suscripcionRepository.save(suscripcion);
    }

    public void deleteUser(int id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.getSuscripciones().stream().forEach(s-> suscripcionRepository.delete(s));
        usuarioRepository.delete(usuario);
    }
}
