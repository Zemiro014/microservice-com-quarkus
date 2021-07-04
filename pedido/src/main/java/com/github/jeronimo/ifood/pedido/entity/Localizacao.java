package com.github.jeronimo.ifood.pedido.entity;

public class Localizacao {
    private Double latitude;
    private Double longitude;
    
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}