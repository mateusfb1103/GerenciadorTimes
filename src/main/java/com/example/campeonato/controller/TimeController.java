package com.example.campeonato.controller;

import com.example.campeonato.model.Time;
import com.example.campeonato.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping
    public ResponseEntity<Time> criarTime(@RequestBody Time time) {
        Time novoTime = timeService.salvar(time);
        return ResponseEntity.status(201).body(novoTime);
    }

    @GetMapping
    public List<Time> listarTodos() {
        return timeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        Optional<Time> time = timeService.buscarPorId(id);
        return time.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Long id, @RequestBody Time time) {
        Time timeAtualizado = timeService.atualizar(id, time);
        return ResponseEntity.ok(timeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        timeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
