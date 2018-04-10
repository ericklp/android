package com.example.ericklopes.carinfo;

import java.util.ArrayList;

/**
 * Created by ericklopes on 08/04/18.
 */

public class Montadora {
    private String montadora;
    private ArrayList<Veiculo> modelo = new ArrayList<Veiculo>();
    //private ArrayList<String> modelos = new ArrayList<String>();

    public Montadora(String montadora, ArrayList<Veiculo> modelo/*, ArrayList<String> modelos*/) {
        this.montadora = montadora;
        this.modelo = modelo;
        //this.modelos = modelos;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public ArrayList<Veiculo> getModelo() {
        return modelo;
    }

    public void setModelo(ArrayList<Veiculo> modelo) {
        this.modelo = modelo;
    }
/*
    public ArrayList<String> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<String> modelos) {
        this.modelos = modelos;
    }*/
}
