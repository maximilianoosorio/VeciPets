package com.example.application.views.empty;

/**
 * Clase abstracta que representa una mascota.
 * Sirve como base para otras clases (HERENCIA).
 */
public abstract class Mascota {
    
    // 🔒 Atributos privados → Encapsulamiento
    private int id;
    private String nombre;
    private int edadMeses;
    private double peso;

    /**
     * 🧱 CONSTRUCTOR
     * Inicializa los atributos de la clase.
     * Usa setters para aplicar validaciones.
     */
    public Mascota(int id, String nombre, int edadMeses, double peso) {
        this.id = id;
        setNombre(nombre);
        setEdadMeses(edadMeses);
        setPeso(peso);
    }

    /**
     * 🧠 MÉTODO ABSTRACTO (POLIMORFISMO)
     * No tiene implementación aquí.
     * Las clases hijas (Perro, Gato) deben implementarlo.
     */
    public abstract String obtenerCuidadosEspeciales();

    // 🔹 MÉTODOS GET Y SET → Encapsulamiento

    public int getId() {
        return id;
    }

    /**
     * Validación del ID
     */
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Validación del nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    /**
     * Validación de edad
     */
    public void setEdadMeses(int edadMeses) {
        if (edadMeses < 0) {
            throw new IllegalArgumentException("Edad inválida");
        }
        this.edadMeses = edadMeses;
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Validación de peso
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso inválido");
        }
        this.peso = peso;
    }

    /**
     * ⚠️ NOTA IMPORTANTE:
     * Esta clase NO tiene sobrecarga de métodos ni constructores.
     * Solo existe un constructor.
     */
}