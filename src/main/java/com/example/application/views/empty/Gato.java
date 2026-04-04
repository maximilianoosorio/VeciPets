package com.example.application.views.empty;

public class Gato extends Mascota {

    private boolean esCazador;

    public Gato(int id, String nombre, int edadMeses, double peso, boolean esCazador) {
        super(id, nombre, edadMeses, peso);
        this.esCazador = esCazador;
    }

    public boolean isEsCazador() {
        return esCazador;
    }

    @Override
    public String obtenerCuidadosEspeciales() {
        return "Necesita un ambiente tranquilo y limpio.";
    }
}