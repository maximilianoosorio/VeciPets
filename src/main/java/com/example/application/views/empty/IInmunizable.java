package com.example.application.views.empty;

import java.time.LocalDateTime;

/**
 *  INTERFAZ 
 * Define comportamientos que deben implementar las clases que la usen.
 * En este caso: mascotas que pueden ser vacunadas.
 */
public interface IInmunizable {
    
    /**
     * 💉 MÉTODO ABSTRACTO
     * Registra una vacuna con su nombre y fecha.
     * No tiene implementación aquí (la hacen las clases como Perro o Gato).
     */
    void registrarVacuna(String nombreVacuna, LocalDateTime fecha);
    
    /**
     * 🩺 MÉTODO ABSTRACTO
     * Devuelve el estado de salud de la mascota.
     */
    String obtenerEstadoSalud();

    /**
     * 🔢 MÉTODO ABSTRACTO
     * Devuelve el número total de vacunas aplicadas.
     */
    int getNumeroVacunas();
}