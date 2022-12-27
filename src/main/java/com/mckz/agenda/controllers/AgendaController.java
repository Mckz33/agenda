package com.mckz.agenda.controllers;

import com.mckz.agenda.dtos.AgendaDto;
import com.mckz.agenda.models.AgendaModel;
import com.mckz.agenda.services.AgendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgendaController {
    @Autowired
    public AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AgendaDto agendaDto) {
        AgendaModel agendaModel = new AgendaModel();
        BeanUtils.copyProperties(agendaDto, agendaModel);
        agendaModel.setHorario(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.save(agendaModel));
    }

    @GetMapping
    public ResponseEntity<List<AgendaModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        Optional<AgendaModel> agendaModelOptional = agendaService.findById(id);
        if (!agendaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<AgendaModel> agendaModelOptional = agendaService.findById(id);
        if (!agendaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda não encontrada!");
        }
        agendaService.delete(agendaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Agenda deletada com sucesso!");
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid AgendaDto agendaDto) {
        Optional<AgendaModel> agendaModelOptional = agendaService.findById(id);
        if (!agendaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
        }
        var agendaModel = agendaModelOptional.get();
        BeanUtils.copyProperties(agendaDto, agendaModel);
        agendaModel.setId(agendaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.save(agendaModel));
    }

}
