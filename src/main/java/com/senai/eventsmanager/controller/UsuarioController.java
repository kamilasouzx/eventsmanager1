package com.senai.eventsmanager.controller;

import com.senai.eventsmanager.dto.UsuarioDTO;
import com.senai.eventsmanager.enums.UsuarioEnum;
import com.senai.eventsmanager.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario") //  http://localhost:8080/api/v1/usuario/1
public class UsuarioController {
    @Autowired
    UsuarioService service;

    // pegar um usuario pelo seu id
    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
////////////////////////////
    // pegar um usuario por tipo 
    @GetMapping("/filtro/{tipo}")
    public List<UsuarioDTO> filtro(@PathVariable("tipo") UsuarioEnum tipo){ //-> parametros de entrada, qnd enum é numero : int
        return service.findByTipo(tipo);
    }

    // pegar todos um usuarios
    @GetMapping
    public List<UsuarioDTO> findAll(){
        return service.findAll();
    }
    // salvar um usuario
    @PostMapping
    public UsuarioDTO save(
            @RequestBody @Valid UsuarioDTO usuarioCreateDTO ){
        return service.save(usuarioCreateDTO);
    }
    // atualizar um usuario
    @PutMapping("/{id}")
    public UsuarioDTO update(
            @PathVariable("id")Long id,
            @RequestBody UsuarioDTO usuarioCreateDTO){
        return service.update(id,usuarioCreateDTO);
    }
    // deletar um usuario pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }

}
