package com.senai.eventsmanager.service;

import com.senai.eventsmanager.dto.EventoCreateDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public EventoCreateDTO findById(UUID id) {
        //retorna uma entidade evento
        Evento evento = eventoRepository.findById(id).orElseThrow();
        //metodo para converter um evento entity em eventoCreateDTO
        EventoCreateDTO eventoCreateDTO = convertToDTO(evento);
        return eventoCreateDTO;
    }

    //metodo para salvar um evento
    public EventoCreateDTO save(EventoCreateDTO eventoCreateDTO) {
        Evento evento = convertToEntity(eventoCreateDTO);
        evento = eventoRepository.save(evento);
        return convertToDTO(evento);
    }

    //metodo para atualizar um evento
    public EventoCreateDTO update(UUID id, EventoCreateDTO eventoCreateDTO) {
        Evento evento = convertToEntity(eventoCreateDTO);
        evento.setId(id);
        evento = eventoRepository.save(evento);
        return convertToDTO(evento);
    }

    //metodo para deletar um evento
    public void deleteById(UUID id) {
        eventoRepository.deleteById(id);
    }

    //metodo para listar todos os eventos
    public List<EventoCreateDTO> findAll() {
        List<Evento> eventos = eventoRepository.findAll();
        //criar lista de eventoCreateDTO
        List<EventoCreateDTO> eventoCreateDTOs = new ArrayList<>();
        //para cada evento na lista de eventos, converter para DTO e add
        for (Evento evento : eventos) {
            eventoCreateDTOs.add(convertToDTO(evento));
        }
        return eventoCreateDTOs;
    }

    public EventoCreateDTO convertToDTO(Evento evento){
        EventoCreateDTO eventoCreateDTO = new EventoCreateDTO();
        //pegar os dados de evento e passar para o eventoCreateDTO
        eventoCreateDTO.setNome(evento.getNome());
        eventoCreateDTO.setDescricao(evento.getDescricao());
        eventoCreateDTO.setTipo(evento.getTipo());
        eventoCreateDTO.setLocal(evento.getLocal());
        eventoCreateDTO.setData_inicio(evento.getData_inicio());
        eventoCreateDTO.setData_final(evento.getData_final());
        evento.setLinkEvento(evento.getLinkEvento());
        evento.setLinkImagem(evento.getLinkImagem());
        return eventoCreateDTO;
    }
    public Evento convertToEntity(EventoCreateDTO eventoCreateDTO){
        Evento evento = new Evento();
        evento.setNome(eventoCreateDTO.getNome());
        evento.setDescricao(eventoCreateDTO.getDescricao());
        evento.setTipo(eventoCreateDTO.getTipo());
        evento.setLocal(eventoCreateDTO.getLocal());
        evento.setData_inicio(eventoCreateDTO.getData_inicio());
        evento.setData_final(eventoCreateDTO.getData_final());
        evento.setLinkEvento(eventoCreateDTO.getLinkEvento());
        evento.setLinkImagem(eventoCreateDTO.getLinkImagem());
        return evento;
    }

}
