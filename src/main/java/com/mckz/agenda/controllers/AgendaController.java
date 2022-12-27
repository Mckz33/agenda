package com.mckz.agenda.controllers;

import com.mckz.agenda.repositories.AgendaRepository;
import com.mckz.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

}
