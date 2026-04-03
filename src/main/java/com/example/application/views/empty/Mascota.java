package com.example.application.views.empty;

/**
 * Superclase abstracta que representa a cualquier animal del refugio.
 * Cumple con los Criterios 2, 7 y 10 de la lista de evaluación.
 */
public abstract class Mascota {
    
    // Criterio 10: Atributos privados para proteger el estado interno
    private int id;
    private String nombre;
    private int edadMeses;
    private double peso;

    // Constructor que inicializa el estado del objeto (Criterio 8 - Base)
    public Mascota(int id, String nombre, int edadMeses, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.edadMeses = edadMeses;
        this.peso = peso;
    }

    // Método abstracto: Obliga a las subclases a definir cuidados según la especie
    public abstract String obtenerCuidadosEspeciales();

    // --- Getters y Setters para cumplir el Encapsulamiento (Criterio 10) ---
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}