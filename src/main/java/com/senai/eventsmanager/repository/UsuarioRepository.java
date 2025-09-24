package com.senai.eventsmanager.repository;

import com.senai.eventsmanager.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends
        JpaRepository<Usuario, UUID> {
    //save, delete, update, findAll , findById

}
