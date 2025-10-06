package com.senai.eventsmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    @NotBlank(message = "A senha deve ser preenchida")
    private String senha;

    @NotBlank(message = "O email deve ser preenchido")
    private String email;
    
}
