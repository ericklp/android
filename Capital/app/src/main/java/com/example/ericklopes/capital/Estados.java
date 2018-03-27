package com.example.ericklopes.capital;

/**
 * Created by ericklopes on 03/03/18.
 */

public class Estados {

    private String estado;
    private String capital;


    public Estados(String estado, String capital) {
        this.estado = estado;
        this.capital = capital;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
