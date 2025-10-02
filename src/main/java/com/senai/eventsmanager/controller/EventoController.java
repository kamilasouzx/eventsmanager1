package com.senai.eventsmanager.controller;

import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evento")
//  http://localhost:8080/api/v1/evento
public class EventoController {
    @Autowired
    EventoService service;

    //listar todos os eventos entre duas datas api/v1/evento/calendario/2025/10/01/2025-10-31
    @GetMapping("/calendario/{dataInicio}/{dataFinal}")
    public List<EventoDTO> calendario(@PathVariable String dataInicio, @PathVariable String dataFinal){
        return service.calendario(dataInicio, dataFinal);
    }

    // pegar um evento pelo seu id
    @GetMapping("/{id}")
    public EventoDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    // pegar todos os eventos
    @GetMapping
    public List<EventoDTO> findAll(){
        return service.findAll();
    }
    // salvar um evento
    @PostMapping
    public EventoDTO save(
            @RequestBody EventoDTO eventoCreateDTO ){
        return service.save(eventoCreateDTO);
    }
    // atualizar um evento
    @PutMapping("/{id}")
    public EventoDTO update(
            @PathVariable("id")Long id,
            @RequestBody EventoDTO eventoCreateDTO){
        return service.update(id,eventoCreateDTO);
    }
    // deletar um evento pelo seu id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){

        service.deleteById(id);
    }


}