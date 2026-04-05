package com.example.application.views.empty;

import java.util.ArrayList;
import java.util.List;

public class MascotasService {

    public static List<Mascota> obtenerMascotas() {

        List<Mascota> lista = new ArrayList<>();

        lista.add(new Perro(1, "maxc", 12, 28.5, "Golden Retriever"));
        lista.add(new Gato(2, "mami", 4, 3.2, true));
        lista.add(new Perro(3, "Toby", 24, 5.0, "Pug"));
        lista.add(new Gato(4, "linda", 36, 4.8, false));

        return lista;
    }
}