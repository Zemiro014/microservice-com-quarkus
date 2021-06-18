package com.github.jeronimo.ifood.mp.dto;

import java.math.BigDecimal;

import io.vertx.mutiny.sqlclient.Row;

public class PratoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public static PratoDTO from(Row row) {
        PratoDTO dto = new PratoDTO();
        dto.descricao = row.getString("descricao");
        dto.nome = row.getString("nome");
        dto.id = row.getLong("id");
        dto.preco = row.getBigDecimal("preco");
        return dto;
    }
}
