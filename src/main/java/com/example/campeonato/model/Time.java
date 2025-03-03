package com.example.campeonato.model;

import jakarta.persistence.*;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    private String nome;
    private int pontos;

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    public Time() {}

    public Time(String nome, int pontos, Campeonato campeonato) {
        this.nome = nome;
        this.pontos = pontos;
        this.campeonato = campeonato;
    }

    // Getters e Setters
}
