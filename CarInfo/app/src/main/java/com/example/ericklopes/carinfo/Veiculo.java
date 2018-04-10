package com.example.ericklopes.carinfo;

/**
 * Created by ericklopes on 08/04/18.
 */

public class Veiculo {
    private String modelo;
    private String foto;
    private float valor;

    public Veiculo(String modelo, String foto, int i, float valor) {
        this.modelo = modelo;
        this.foto = foto;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
