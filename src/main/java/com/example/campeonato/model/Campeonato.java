package com.example.campeonato.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Long getId() {
        return id;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(
            name = "campeonato_time",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private List<Time> times;


    public Campeonato() {}

    public Campeonato(String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }


}
