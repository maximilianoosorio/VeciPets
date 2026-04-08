package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un perro en el sistema VeciPets.
 * Implementa IInmunizable para gestionar su esquema de vacunación.
 */
public class Perro extends Mascota implements IInmunizable {
    
    private String raza;
    private List<String> historialVacunas = new ArrayList<>();

    // Constructor completo (Criterio 8)
    public Perro(int id, String nombre, int edadMeses, double peso, String raza) {
        super(id, nombre, edadMeses, (peso > 0 ? peso : 1.0));
        this.raza = raza;
    }

    // Constructor sobrecargado para casos rápidos
    public Perro(int id, String nombre, double peso) {
        super(id, nombre, 0, (peso > 0 ? peso : 1.0));
        this.raza = "Mestizo";
    }

    @Override
    public int getNumeroVacunas() {

    return historialVacunas.size();
}

    /**
     * Implementación de polimorfismo para cuidados específicos (Criterio 2).
     */
    @Override
    public String obtenerCuidadosEspeciales() {
        String base = "Requiere paseos diarios y socialización.";
        return (getPeso() > 30) ? base + " Cuidado con articulaciones por peso elevado." : base;
    }

    /**
     * Registra una nueva vacuna en la lista interna (Criterio 7).
     */
    @Override
    public void registrarVacuna(String nombreVacuna, LocalDateTime fecha) {
        // Formateamos el registro para que se vea limpio en el modal
        String registro = nombreVacuna + " (" + fecha.toLocalDate() + ")";
        historialVacunas.add(registro);
        System.out.println("Historial de " + getNombre() + " actualizado: " + registro);
    }

    /**
     * Retorna el estado de salud detallado para el cuadro verde del modal.
     */
    @Override
    public String obtenerEstadoSalud() {
        if (historialVacunas.isEmpty()) {
            return "Esquema pendiente (Requiere vacunación inicial)";
        }
        
        // Une todas las vacunas registradas separadas por un punto medio (•)
        return String.join(" • ", historialVacunas);
    }

    // --- Getters y Setters (Criterio 10) ---

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public List<String> getHistorialVacunas() {
        return historialVacunas;
    }
}