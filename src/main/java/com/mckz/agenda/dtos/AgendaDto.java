package com.mckz.agenda.dtos;

import com.mckz.agenda.models.PacienteModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class AgendaDto {

    @NotBlank
    private String descricao;

    @NotNull
    private PacienteModel pacienteModel;
}
