package com.senai.eventsmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor//cria o construtor lombok
@NoArgsConstructor//cria o construtor vazio
@EntityListeners(AuditingEntityListener.class)
@Table(name = "inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    //Campos com chaves estrangeiras
    @ManyToOne
    @JoinColumn(name="evento_id",nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name="usuario_id",nullable = false)
    private Usuario usuario;

}
