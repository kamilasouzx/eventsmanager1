package com.senai.eventsmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "O evento deve ser preenchido")
    private Evento evento;

    @NotBlank(message = "O usuario deve ser preenchido")
    private Usuario usuario;    

}
