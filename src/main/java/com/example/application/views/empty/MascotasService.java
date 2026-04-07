package com.example.application.views.empty;

import java.util.ArrayList;
import java.util.List;

public class MascotasService {

    public static List<Mascota> obtenerMascotas() {
        List<Mascota> lista = new ArrayList<>();

        // --- 10 PERROS ---
        lista.add(new Perro(1, "Maxc", 12, 28.5, "Golden Retriever"));
        lista.add(new Perro(2, "Toby", 24, 5.0, "Pug"));
        lista.add(new Perro(3, "Rocky", 48, 32.0, "Pastor Alemán"));
        lista.add(new Perro(4, "Luna", 6, 12.0, "Beagle"));
        lista.add(new Perro(5, "Coco", 36, 8.5, "Caniche"));
        lista.add(new Perro(6, "Thor", 18, 40.0, "Rottweiler"));
        lista.add(new Perro(7, "Daisy", 60, 25.0, "Labrador"));
        lista.add(new Perro(8, "Simba", 2, 4.0, "Pomerania"));
        lista.add(new Perro(9, "Bruno", 72, 35.0, "Boxer"));
        lista.add(new Perro(10, "Mora", 10, 15.0, "Cocker Spaniel"));

        // --- 10 GATOS ---
        lista.add(new Gato(11, "Mami", 4, 3.2, true));
        lista.add(new Gato(12, "Linda", 36, 4.8, false));
        lista.add(new Gato(13, "Oliver", 12, 5.5, true));
        lista.add(new Gato(14, "Bella", 24, 4.0, true));
        lista.add(new Gato(15, "Max", 8, 3.5, false));
        lista.add(new Gato(16, "Chloe", 48, 4.2, true));
        lista.add(new Gato(17, "Milo", 60, 6.0, false));
        lista.add(new Gato(18, "Kitty", 3, 1.5, true));
        lista.add(new Gato(19, "Felix", 120, 5.8, true));
        lista.add(new Gato(20, "Nala", 18, 3.9, false));

        return lista;
    }
}