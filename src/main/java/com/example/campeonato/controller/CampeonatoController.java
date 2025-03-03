package com.example.campeonato.controller;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @PostMapping
    public ResponseEntity<Campeonato> criarCampeonato(@RequestBody Campeonato campeonato) {
        Campeonato novoCampeonato = campeonatoService.salvar(campeonato);
        return ResponseEntity.status(201).body(novoCampeonato);
    }

    @GetMapping
    public List<Campeonato> listarTodos() {
        return campeonatoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> buscarPorId(@PathVariable Long id) {
        Optional<Campeonato> campeonato = campeonatoService.buscarPorId(id);
        return campeonato.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        campeonatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
