package com.mckz.agenda.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


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

