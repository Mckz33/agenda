package com.mckz.agenda.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDto {


    @NotBlank
    private String nome;


    @NotBlank
    private String sobrenome;


    @NotBlank
    private String cpf;


    @NotBlank
    private String email;

}

