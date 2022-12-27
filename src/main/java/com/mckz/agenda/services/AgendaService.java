package com.mckz.agenda.services;

import com.mckz.agenda.models.AgendaModel;
import com.mckz.agenda.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendaService {
    @Autowired
    public AgendaRepository agendaRepository;


    public AgendaModel save(AgendaModel agendaModel) {
        return agendaRepository.save(agendaModel);
    }

    public List<AgendaModel> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<AgendaModel> findById(UUID id) {
        return agendaRepository.findById(id);
    }

    public void delete(UUID id) {
        agendaRepository.deleteById(id);
    }
}
