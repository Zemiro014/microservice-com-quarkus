package com.github.jeronimo.ifood.mp.entities;

import java.util.Date;

public class Restaurante {

    public Long id;
    private String proprietario;
    private String cnpj;
    private String nome;
    private Localizacao localizacao;
    private Date dataCriacao;
    private Date dataAtualizacao;

    public Long getId() {
        return id;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
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

    @Override
    public String toString() {
        return "Restaurante [cnpj=" + cnpj + ", dataAtualizacao=" + dataAtualizacao + ", dataCriacao=" + dataCriacao
                + ", id=" + id + ", localizacao=" + localizacao + ", nome=" + nome + ", proprietario=" + proprietario
                + "]";
    }
}