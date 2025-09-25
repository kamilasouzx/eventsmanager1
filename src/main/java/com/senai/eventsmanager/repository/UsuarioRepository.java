package com.senai.eventsmanager.repository;

import com.senai.eventsmanager.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long> {
    //save, delete, update, findAll , findById

}
