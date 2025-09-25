package com.senai.eventsmanager.repository;

import com.senai.eventsmanager.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends
        JpaRepository<Evento, Long> {
    //save, delete, update, findAll , findById

}
