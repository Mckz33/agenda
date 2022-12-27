package com.mckz.agenda.dtos;

import com.mckz.agenda.models.PacienteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaDto {

    @NotBlank
    private String descricao;

    @NotNull
    private PacienteModel pacienteModel;
}
