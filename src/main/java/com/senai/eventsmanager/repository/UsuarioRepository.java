package com.senai.eventsmanager.repository;
import com.senai.eventsmanager.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long> {
    
            @Query("SELECT Usuario FROM Usuario WHERE tipo = 'CLIENTE")
            List<Usuario> clientes();
}