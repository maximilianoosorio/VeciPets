package com.example.application.views.empty;

/**
 * Superclase abstracta que representa a cualquier animal del refugio.
 */
public abstract class Mascota {
    
    private int id;
    private String nombre;
    private int edadMeses;
    private double peso;

    public Mascota(int id, String nombre, int edadMeses, double peso) {
        this.id = id;
        setNombre(nombre);
        setEdadMeses(edadMeses);
        setPeso(peso);
    }

    public abstract String obtenerCuidadosEspeciales();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        if (edadMeses < 0) {
            throw new IllegalArgumentException("Edad inválida");
        }
        this.edadMeses = edadMeses;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso inválido");
        }
        this.peso = peso;
    }
}