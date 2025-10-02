package com.senai.eventsmanager.controller;


import com.senai.eventsmanager.dto.InscricaoDTO;
import com.senai.eventsmanager.service.InscricaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscricao") //  http://localhost:8080/api/v1/inscricao/1
public class InscricaoController {
    InscricaoService service;

    // pegar uma inscricao pelo seu id
    @GetMapping("/{id}")
    public InscricaoDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    // pegar todos as inscricoes
    @GetMapping
    public List<InscricaoDTO> findAll(){
        return service.findAll();
    }
    // salvar uma inscricao
    @PostMapping
    public InscricaoDTO save(
            @RequestBody InscricaoDTO inscricaoCreateDTO ){
        return service.save(inscricaoCreateDTO);
    }
    // atualizar uma inscricao
    @PutMapping("/{id}")
    public InscricaoDTO update(
            @PathVariable("id")Long id,
            @RequestBody InscricaoDTO inscricaoCreateDTO){
        return service.update(id,inscricaoCreateDTO);
    }
    // deletar uma inscricao pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }


}
