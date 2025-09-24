package com.senai.eventsmanager.repository;

import com.senai.eventsmanager.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscricaoRepository extends
        JpaRepository<Inscricao, UUID> {
    //save, delete, update, findAll , findById

}

