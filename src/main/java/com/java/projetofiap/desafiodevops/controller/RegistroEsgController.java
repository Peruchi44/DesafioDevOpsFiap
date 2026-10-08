package com.java.projetofiap.desafiodevops.controller;

import com.java.projetofiap.desafiodevops.model.RegistroEsg;
import com.java.projetofiap.desafiodevops.service.RegistroEsgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/esg")
public class RegistroEsgController {

    private final RegistroEsgService service;

    public RegistroEsgController(RegistroEsgService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegistroEsg> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroEsg> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegistroEsg> criar(@RequestBody RegistroEsg registro) {
        RegistroEsg salvo = service.salvar(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}