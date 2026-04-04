package com.example.application.views.empty;

public class Perro extends Mascota {

    private String raza;

    public Perro(int id, String nombre, int edadMeses, double peso, String raza) {
        super(id, nombre, edadMeses, peso);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public String obtenerCuidadosEspeciales() {
        return "Requiere paseos diarios y mucha actividad.";
    }
}