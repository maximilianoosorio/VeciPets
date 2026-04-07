package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MascotasService {

    public static List<Mascota> obtenerMascotas() {
        List<Mascota> lista = new ArrayList<>();
        LocalDateTime hoy = LocalDateTime.now();

        // --- 10 PERROS ---
        
        // 1. Maxc - COMPLETO (Botón Azul)
        Perro p1 = new Perro(1, "Maxc", 12, 28.5, "Golden Retriever");
        p1.registrarVacuna("Rabia", hoy);
        p1.registrarVacuna("Parvo", hoy);
        p1.registrarVacuna("Moquillo", hoy);
        lista.add(p1);

        // 2. Toby - INCOMPLETO (Aviso Rojo)
        Perro p2 = new Perro(2, "Toby", 24, 5.0, "Pug");
        p2.registrarVacuna("Rabia", hoy);
        lista.add(p2);

        // 3. Rocky - COMPLETO (Botón Azul)
        Perro p3 = new Perro(3, "Rocky", 48, 32.0, "Pastor Alemán");
        p3.registrarVacuna("Rabia", hoy);
        p3.registrarVacuna("Parvo", hoy);
        p3.registrarVacuna("Polivalente", hoy);
        lista.add(p3);

        // 4. Luna - INCOMPLETO (Aviso Rojo)
        Perro p4 = new Perro(4, "Luna", 6, 12.0, "Beagle");
        p4.registrarVacuna("Parvo", hoy);
        p4.registrarVacuna("Moquillo", hoy);
        lista.add(p4);

        // 5. Coco - COMPLETO (Botón Azul)
        Perro p5 = new Perro(5, "Coco", 36, 8.5, "Caniche");
        p5.registrarVacuna("Rabia", hoy);
        p5.registrarVacuna("Tos", hoy);
        p5.registrarVacuna("Moquillo", hoy);
        lista.add(p5);

        // 6. Thor - INCOMPLETO (Aviso Rojo)
        Perro p6 = new Perro(6, "Thor", 18, 40.0, "Rottweiler");
        p6.registrarVacuna("Rabia", hoy);
        lista.add(p6);

        // 7. Daisy - COMPLETO (Botón Azul)
        Perro p7 = new Perro(7, "Daisy", 60, 25.0, "Labrador");
        p7.registrarVacuna("Rabia", hoy);
        p7.registrarVacuna("Parvo", hoy);
        p7.registrarVacuna("Refuerzo", hoy);
        lista.add(p7);

        // 8. Simba - INCOMPLETO (Aviso Rojo)
        Perro p8 = new Perro(8, "Simba", 2, 4.0, "Pomerania");
        p8.registrarVacuna("Primovacuna", hoy);
        lista.add(p8);

        // 9. Bruno - COMPLETO (Botón Azul)
        Perro p9 = new Perro(9, "Bruno", 72, 35.0, "Boxer");
        p9.registrarVacuna("Anual Rabia", hoy);
        p9.registrarVacuna("Anual Parvo", hoy);
        p9.registrarVacuna("Anual Moquillo", hoy);
        lista.add(p9);

        // 10. Mora - INCOMPLETO (Aviso Rojo)
        Perro p10 = new Perro(10, "Mora", 10, 15.0, "Cocker Spaniel");
        p10.registrarVacuna("Rabia", hoy);
        p10.registrarVacuna("Parvo", hoy);
        lista.add(p10);

        // --- 10 GATOS ---
        
        // 11. Mami - COMPLETO (Botón Azul)
        Gato g11 = new Gato(11, "Mami", 4, 3.2, true);
        g11.registrarVacuna("Triple Felina", hoy);
        g11.registrarVacuna("Leucemia", hoy);
        g11.registrarVacuna("Rabia", hoy);
        lista.add(g11);

        // 12. Linda - INCOMPLETO (Aviso Rojo)
        Gato g12 = new Gato(12, "Linda", 36, 4.8, false);
        g12.registrarVacuna("Triple Felina", hoy);
        lista.add(g12);

        // 13. Oliver - COMPLETO (Botón Azul)
        Gato g13 = new Gato(13, "Oliver", 12, 5.5, true);
        g13.registrarVacuna("Triple", hoy);
        g13.registrarVacuna("Leucemia", hoy);
        g13.registrarVacuna("Rabia", hoy);
        lista.add(g13);

        // 14. Bella - COMPLETO (Botón Azul)
        Gato g14 = new Gato(14, "Bella", 24, 4.0, true);
        g14.registrarVacuna("Triple", hoy);
        g14.registrarVacuna("Leucemia", hoy);
        g14.registrarVacuna("Rabia", hoy);
        lista.add(g14);

        // 15. Max - INCOMPLETO (Aviso Rojo)
        Gato g15 = new Gato(15, "Max", 8, 3.5, false);
        g15.registrarVacuna("Triple Felina", hoy);
        lista.add(g15);

        // 16. Chloe - COMPLETO (Botón Azul)
        Gato g16 = new Gato(16, "Chloe", 48, 4.2, true);
        g16.registrarVacuna("Triple", hoy);
        g16.registrarVacuna("Leucemia", hoy);
        g16.registrarVacuna("Rabia", hoy);
        lista.add(g16);

        // 17. Milo - INCOMPLETO (Aviso Rojo)
        Gato g17 = new Gato(17, "Milo", 60, 6.0, false);
        g17.registrarVacuna("Rabia", hoy);
        lista.add(g17);

        // 18. Kitty - COMPLETO (Botón Azul)
        Gato g18 = new Gato(18, "Kitty", 3, 1.5, true);
        g18.registrarVacuna("Triple", hoy);
        g18.registrarVacuna("Leucemia", hoy);
        g18.registrarVacuna("Rabia", hoy);
        lista.add(g18);

        // 19. Felix - COMPLETO (Botón Azul)
        Gato g19 = new Gato(19, "Felix", 120, 5.8, true);
        g19.registrarVacuna("Refuerzo 1", hoy);
        g19.registrarVacuna("Refuerzo 2", hoy);
        g19.registrarVacuna("Refuerzo 3", hoy);
        lista.add(g19);

        // 20. Nala - INCOMPLETO (Aviso Rojo)
        Gato g20 = new Gato(20, "Nala", 18, 3.9, false);
        g20.registrarVacuna("Triple Felina", hoy);
        lista.add(g20);

        return lista;
    }
}