package com.mckz.agenda.services;

import com.mckz.agenda.models.PacienteModel;
import com.mckz.agenda.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    public PacienteModel save(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    public List<PacienteModel> findAll(PacienteModel pacienteModel) {
        return pacienteRepository.findAll();
    }

    public Optional<PacienteModel> findById(UUID id) {
        return pacienteRepository.findById(id);
    }

    public void delete(UUID id) {
        pacienteRepository.deleteById(id);
    }

    public boolean existsByCpf(String cpf) {
        return pacienteRepository.existsByCpf(cpf);
    }

    public boolean existsByEmail(String email) {
        return pacienteRepository.existsByEmail(email);
    }

}
