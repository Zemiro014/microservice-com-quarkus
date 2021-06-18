package com.github.jeronimo.ifood.mp.entities;

public class Localizacao {
    private Long id;
    private Double latitude;
    private Double longitude;

    public Long getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }
}