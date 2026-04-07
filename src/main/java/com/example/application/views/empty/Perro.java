package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Perro extends Mascota implements IInmunizable {
    private String raza;
    // MEJORA: Colección para guardar el historial real
    private List<String> historialVacunas = new ArrayList<>();

    public Perro(int id, String nombre, int edadMeses, double peso, String raza) {
        super(id, nombre, edadMeses, (peso > 0 ? peso : 1.0));
        this.raza = raza;
    }

    public Perro(int id, String nombre, double peso) {
        super(id, nombre, 0, (peso > 0 ? peso : 1.0));
        this.raza = "Mestizo";
    }

    @Override
    public String obtenerCuidadosEspeciales() {
        return "Requiere paseos diarios. " + (getPeso() > 30 ? "Cuidado con articulaciones por peso elevado." : "Peso ideal para ejercicio.");
    }

    @Override
    public void registrarVacuna(String nombreVacuna, LocalDateTime fecha) {
        // MEJORA: Guardamos el dato en la lista
        String registro = nombreVacuna + " el " + fecha.toLocalDate();
        historialVacunas.add(registro);
        System.out.println("Historial de " + getNombre() + " actualizado: " + registro);
    }

    @Override
    public String obtenerEstadoSalud() {
        // MEJORA: Lógica dinámica
        if (getEdadMeses() > 120) return "Estado canino: Senior (Requiere chequeo geriátrico)";
        return "Estado canino: Saludable";
    }

    public List<String> getHistorialVacunas() { return historialVacunas; }
    public String getRaza() { return raza; }
}