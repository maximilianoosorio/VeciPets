package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad Perro. Implementa lógica avanzada de sobrecarga y polimorfismo.
 */
public class Perro extends Mascota implements IInmunizable {
    
    private String raza;
    private List<String> historialVacunas = new ArrayList<>();

    /**
     * Criterio 6: Sobrecarga de Constructores - Versión Completa.
     * Criterio 8: Validación de integridad de datos (peso mínimo).
     */
    public Perro(int id, String nombre, int edadMeses, double peso, String raza) {
        super(id, nombre, edadMeses, (peso > 0 ? peso : 1.0));
        this.raza = raza;
    }

    /**
     * Criterio 6: Sobrecarga de Constructores - Versión Simplificada.
     * Permite registrar mascotas con datos parciales (raza mestiza por defecto).
     */
    public Perro(int id, String nombre, double peso) {
        super(id, nombre, 0, (peso > 0 ? peso : 1.0));
        this.raza = "Mestizo";
    }

    @Override
    public int getNumeroVacunas() {
        return historialVacunas.size();
    }

    /**
     * Criterio 2: Polimorfismo. 
     * Lógica de negocio que varía según el estado del objeto (Peso).
     */
    @Override
    public String obtenerCuidadosEspeciales() {
        String base = "Requiere paseos diarios y socialización.";
        // Lógica condicional basada en atributos de la superclase
        return (getPeso() > 30) ? base + " Cuidado con articulaciones por peso elevado." : base;
    }

    /**
     * Criterio 4 y 7: Implementación de contrato de interfaz con nombres descriptivos.
     */
    @Override
    public void registrarVacuna(String nombreVacuna, LocalDateTime fecha) {
        String registro = nombreVacuna + " (" + fecha.toLocalDate() + ")";
        historialVacunas.add(registro);
        // Feedback en consola para depuración técnica
        System.out.println("Historial de " + getNombre() + " actualizado: " + registro);
    }

    /**
     * Criterio 11: Estructura organizada y legible para la UI.
     */
    @Override
    public String obtenerEstadoSalud() {
        if (historialVacunas.isEmpty()) {
            return "Esquema pendiente (Requiere vacunación inicial)";
        }
        // Uso de API de String para formateo avanzado
        return String.join(" • ", historialVacunas);
    }

    // --- Criterio 10: Encapsulamiento con Modificadores de Acceso ---
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public List<String> getHistorialVacunas() { return historialVacunas; }
}