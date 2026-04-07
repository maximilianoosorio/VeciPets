package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gato extends Mascota implements IInmunizable {
    private boolean esIndoor;
    private List<String> historialVacunas = new ArrayList<>();
    
    private static final double FACTOR_CACHORRO = 0.08;
    private static final double FACTOR_ADULTO = 0.05;

    public Gato(int id, String nombre, int edadMeses, double peso, boolean esIndoor) {
        super(id, nombre, edadMeses, (peso > 0 ? peso : 0.5));
        this.esIndoor = esIndoor;
    }

    // QUITAMOS EL @Override porque Mascota no tiene este método
    public double calcularRacion() {
        double factor = (getEdadMeses() < 6) ? FACTOR_CACHORRO : FACTOR_ADULTO;
        return getPeso() * factor;
    }

    public double calcularRacion(double suplemento) {
        return calcularRacion() + suplemento;
    }

    @Override
    public String obtenerCuidadosEspeciales() {
        String base = esIndoor ? "Gato de casa: Necesita rascadores." : "Gato activo: Control de parásitos.";
        return (getPeso() > 7.0) ? base + " ¡ALERTA! Controlar por sobrepeso." : base;
    }

    @Override
    public void registrarVacuna(String nombreVacuna, LocalDateTime fecha) {
        historialVacunas.add(nombreVacuna + " (" + fecha.toLocalDate() + ")");
    }

    @Override
    public String obtenerEstadoSalud() {
        if (getPeso() > 7.0) return "Estado felino: Riesgo de obesidad.";
        if (getEdadMeses() < 3) return "Estado felino: Cachorro.";
        return "Estado felino: Estable";
    }

    public List<String> getHistorialVacunas() { return historialVacunas; }
}