package com.mckz.agenda.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "agenda")
public class AgendaModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String descricao;


    @Column(name = "data_hora")
    private LocalDateTime horario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel pacienteModel;
}
