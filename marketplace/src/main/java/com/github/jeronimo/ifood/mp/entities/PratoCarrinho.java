package com.github.jeronimo.ifood.mp.entities;

public class PratoCarrinho {

    private String usuario;
    private Long prato;

    public Long getIdPrato() {
        return prato;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setIdPrato(Long prato) {
        this.prato = prato;
    }
}
