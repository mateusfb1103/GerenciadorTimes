package com.example.campeonato.service;

import com.example.campeonato.model.Time;
import com.example.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    public Optional<Time> buscarPorId(Long id) {
        return timeRepository.findById(id);
    }

    public Time atualizar(Long id, Time timeAtualizado) {
        return timeRepository.findById(id).map(time -> {
            time.setNome(timeAtualizado.getNome());
            time.setPontos(timeAtualizado.getPontos());
            return timeRepository.save(time);
        }).orElseThrow(() -> new RuntimeException("Time não encontrado!"));
    }

    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }
}
