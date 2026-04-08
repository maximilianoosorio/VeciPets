package com.example.application.views.empty;

import java.time.LocalDateTime;

public interface IInmunizable {
    
    void registrarVacuna(String nombreVacuna, LocalDateTime fecha);
    
    String obtenerEstadoSalud();

    
    int getNumeroVacunas();
}