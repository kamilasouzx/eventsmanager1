package com.senai.eventsmanager.repository;

import com.senai.eventsmanager.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends
        JpaRepository<Inscricao, Long> {
    //save, delete, update, findAll , findById

}

