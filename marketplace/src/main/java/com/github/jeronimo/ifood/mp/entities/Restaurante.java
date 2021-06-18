package com.github.jeronimo.ifood.mp.entities;

public class Restaurante {
    private Long id;
    private String nome;
    private Localizacao localizacao;

    public Long getId() {
        return id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }
}