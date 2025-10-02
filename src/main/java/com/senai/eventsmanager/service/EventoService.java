package com.senai.eventsmanager.service;

import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public EventoDTO findById(Long id) {
        //retorna uma entidade evento
        Evento evento = eventoRepository.findById(id).orElseThrow();
        //metodo para converter um evento entity em eventoDTO
        EventoDTO eventoDTO = toDTO(evento);
        return eventoDTO;
    }

    //metodo para salvar um evento
    public EventoDTO save(EventoDTO eventoDTO) {
        Evento evento = toEntity(eventoDTO);
        evento = eventoRepository.save(evento);
        return toDTO(evento);
    }

    //metodo para atualizar um evento
    public EventoDTO update(Long id, EventoDTO eventoDTO) {
        Evento evento = toEntity(eventoDTO);
        evento.setId(id);
        evento = eventoRepository.save(evento);
        return toDTO(evento);
    }

    //metodo para deletar um evento
    public void deleteById(Long id) {
        eventoRepository.deleteById(id);
    }

    //metodo para listar eventos entre duas datas
    public List<EventoDTO> calendario(String inicio, String dataFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

        LocalDateTime inicioFormatado = LocalDate.parse(inicio,formatter).atStartOfDay();
        LocalDateTime finalFormatado = LocalDate.parse(dataFinal,formatter).atStartOfDay();

        List<Evento> eventos = eventoRepository.calendario(inicioFormatado, finalFormatado);
        List<EventoDTO> eventosDTO = new ArrayList<>();

        for(Evento evento: eventos){
            eventosDTO.add(toDTO(evento));
        }
        return eventosDTO;
    }


    //metodo para listar todos os eventos
    public List<EventoDTO> findAll() {
        List<Evento> eventos = eventoRepository.findAll();
        //criar lista de eventoDTO
        List<EventoDTO> eventoDTOs = new ArrayList<>();
        //para cada evento na lista de eventos, converter para DTO e add
        for (Evento evento : eventos) {
            eventoDTOs.add(toDTO(evento));
        }
        return eventoDTOs;
    }

    public EventoDTO toDTO(Evento evento){
        EventoDTO dto = new EventoDTO();
        BeanUtils.copyProperties(evento, dto);
        return dto;
        
    }
    public Evento toEntity(EventoDTO dto){
        Evento evento = new Evento();
        BeanUtils.copyProperties(dto, evento);
        return evento;
    }

}
