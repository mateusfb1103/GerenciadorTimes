package com.example.campeonato.service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public Campeonato salvar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> buscarPorId(Long id) {
        return campeonatoRepository.findById(id);
    }

    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }
}
