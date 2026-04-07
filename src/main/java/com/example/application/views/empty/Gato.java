package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gato extends Mascota implements IInmunizable {
    private boolean esDeCasa;
    private List<String> historialVacunas = new ArrayList<>();

    public Gato(int id, String nombre, int edad, double peso, boolean esDeCasa) {
        super(id, nombre, edad, peso);
        this.esDeCasa = esDeCasa;
    }

    @Override
    public String obtenerCuidadosEspeciales() {
        return "Este gatito " + (esDeCasa ? "es totalmente hogareño. " : "le gusta explorar. ") +
               "Requiere enriquecimiento ambiental con rascadores y juegos de caza. " +
               "Es muy limpio y ya sabe usar su caja de arena perfectamente.";
    }

    @Override
    public void registrarVacuna(String nombre, LocalDateTime fecha) {
        historialVacunas.add(nombre + " (" + fecha.toLocalDate() + ")");
    }

    @Override
    public String obtenerEstadoSalud() {
        return historialVacunas.isEmpty() ? "Esquema pendiente" : String.join(" • ", historialVacunas);
    }

    public List<String> getHistorialVacunas() { return historialVacunas; }
}