package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa a un felino. 
 * Demuestra el uso de Herencia (Criterio 2) e Interfaces (Criterio 4).
 */
public class Gato extends Mascota implements IInmunizable {
    
    // Criterio 10: Atributos privados para asegurar el encapsulamiento
    private boolean esDeCasa;
    private List<String> historialVacunas = new ArrayList<>();

    // Criterio 8: Constructor que inicializa el estado y delega a la superclase
    public Gato(int id, String nombre, int edad, double peso, boolean esDeCasa) {
        super(id, nombre, edad, peso); // Invoca al constructor de Mascota
        this.esDeCasa = esDeCasa;
    }

    /**
     * Criterio 2: Polimorfismo mediante sobrescritura de método abstracto.
     * Retorna cuidados específicos basados en el comportamiento del gato.
     */
    @Override
    public String obtenerCuidadosEspeciales() {
        return "Este gatito " + (esDeCasa ? "es totalmente hogareño. " : "le gusta explorar. ") +
               "Requiere enriquecimiento ambiental con rascadores y juegos de caza.";
    }

    /**
     * Criterio 7: Implementación de método definido en la interfaz IInmunizable.
     */
    @Override
    public int getNumeroVacunas() {
        return historialVacunas.size();
    }

    /**
     * Criterio 4: Implementación de lógica de interfaz para registro de salud.
     */
    @Override
    public void registrarVacuna(String nombre, LocalDateTime fecha) {
        // Almacena la vacuna formateando el objeto LocalDateTime a solo fecha
        historialVacunas.add(nombre + " (" + fecha.toLocalDate() + ")");
    }

    /**
     * Criterio 9: Lógica de negocio para visualizar el estado de salud.
     */
    @Override
    public String obtenerEstadoSalud() {
        // Uso de operador ternario para manejar estados nulos o vacíos
        return historialVacunas.isEmpty() ? "Esquema pendiente" : String.join(" • ", historialVacunas);
    }

    public List<String> getHistorialVacunas() { return historialVacunas; }
}