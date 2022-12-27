package com.mckz.agenda.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;


@Data
@Entity
@CrossOrigin(origins = "*", maxAge = 3600)
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String usuario;

    @NotBlank
    private String senha;
}
