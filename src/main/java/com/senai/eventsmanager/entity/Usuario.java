package com.senai.eventsmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.senai.eventsmanager.enums.UsuarioEnum;

@Entity
@Getter
@Setter
@AllArgsConstructor//cria o construtor (lombok)
@NoArgsConstructor//cria o construtor vazio
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 35)
    private String senha;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private UsuarioEnum tipo;

    @Column(nullable = false, length = 8)
    private Date dataNascimento;

    @CreatedDate
    @Column(updatable = false, nullable = false)//não pode ser atualizado nem nulo
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "usuario")
    private List<Inscricao> inscricoes;

}
