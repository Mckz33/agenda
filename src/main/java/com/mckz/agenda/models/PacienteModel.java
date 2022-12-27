package com.mckz.agenda.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "paciente")
public class PacienteModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String sobrenome;

    @Column(length = 255)
    private String cpf;

    @Column(length = 255, nullable = false)
    private String email;
}
