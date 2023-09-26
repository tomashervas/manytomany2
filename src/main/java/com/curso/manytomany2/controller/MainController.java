package com.curso.manytomany2.controller;

import com.curso.manytomany2.dto.SubDTO;
import com.curso.manytomany2.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

    @PostMapping("/createsub")
    public ResponseEntity createSubscription(@RequestBody SubDTO dto){
        mainService.createSubscription(dto.getIdUser(), dto.getIdCanal());
        return new ResponseEntity("Te has suscrito", HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        mainService.deleteUser(id);
        return new ResponseEntity("Usuario eliminado", HttpStatus.OK);
    }


}
