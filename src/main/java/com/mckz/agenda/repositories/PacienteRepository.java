package com.mckz.agenda.repositories;

import com.mckz.agenda.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<PacienteModel, UUID> {

    public Boolean existsByCpf(String cpf);

    public Boolean existsByEmail(String email);
}
