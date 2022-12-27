package com.mckz.agenda.controllers;

import com.mckz.agenda.dtos.PacienteDto;
import com.mckz.agenda.models.PacienteModel;
import com.mckz.agenda.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PacienteDto pacienteDto) {

        if (pacienteService.existsByCpf(pacienteDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF já está cadastrado.");
        }
        if (pacienteService.existsByEmail(pacienteDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este Email já foi cadastrado");
        }
        PacienteModel pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteModel));
    }

    @GetMapping
    public ResponseEntity<List<PacienteModel>> findAll(PacienteModel pacienteModel) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll(pacienteModel));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        pacienteService.delete(pacienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid PacienteDto pacienteDto) {
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        var pacienteModel = pacienteModelOptional.get();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        pacienteModel.setId(pacienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(pacienteModel));
    }
}
