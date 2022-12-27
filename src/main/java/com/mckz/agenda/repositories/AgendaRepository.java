package com.mckz.agenda.repositories;

import com.mckz.agenda.models.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaModel, UUID> {
}
