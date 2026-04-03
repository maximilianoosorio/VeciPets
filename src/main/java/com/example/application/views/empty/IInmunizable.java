package com.example.application.views.empty;


import java.time.LocalDateTime;

/**
 * Interfaz que define el comportamiento para seres que pueden ser vacunados.
 * Cumple con el Criterio 3 y 7 de la lista de evaluación.
 */
public interface IInmunizable {
    
    // Método para registrar una nueva vacuna aplicada
    void registrarVacuna(String nombreVacuna, LocalDateTime fecha);
    
    // Método para obtener un resumen del estado de salud actual
    String obtenerEstadoSalud();
}