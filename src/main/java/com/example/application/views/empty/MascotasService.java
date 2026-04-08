package com.example.application.views.empty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 📊 Clase servicio que simula una base de datos.
 * Genera automáticamente 40 mascotas (20 perros y 20 gatos).
 */
public class MascotasService {

    /**
     * 🔄 Método estático que devuelve una lista de mascotas
     */
    public static List<Mascota> obtenerMascotas() {

        // 📦 Lista donde se almacenarán todas las mascotas
        List<Mascota> lista = new ArrayList<>();

        // 🕒 Fecha actual para registrar vacunas
        LocalDateTime hoy = LocalDateTime.now();

        // 🐶 Arreglo con nombres reales de perros
        String[] nombresPerros = {
            "Max", "Toby", "Rocky", "Luna", "Coco",
            "Thor", "Daisy", "Simba", "Bruno", "Mora",
            "Leo", "Zeus", "Bobby", "Rex", "Kira",
            "Nico", "Otto", "Balto", "Kenai", "Bolt"
        };

        // 🐱 Arreglo con nombres reales de gatos
        String[] nombresGatos = {
            "Mimi", "Nala", "Oliver", "Bella", "Max",
            "Chloe", "Milo", "Kitty", "Felix", "Luna",
            "Simba", "Tom", "Garfield", "Salem", "Loki",
            "Cleo", "Pelusa", "Bigotes", "Sombra", "Nube"
        };

        // =========================
        // 🐶 CREACIÓN DE PERROS
        // =========================

        for (int i = 0; i < 20; i++) {

            /**
             * 🧱 Se crea un objeto Perro usando su constructor
             * i+1 → ID (empieza en 1)
             * nombresPerros[i] → nombre real
             */
            Perro p = new Perro(
                    i + 1,
                    nombresPerros[i],
                    6 + i,         // edad progresiva
                    5.0 + i,       // peso progresivo
                    "Raza" + (i + 1)
            );

            /**
             * 🧠 CONDICIÓN IMPORTANTE
             * (i + 1) % 2 == 0
             * 
             * 👉 % = módulo (resto de división)
             * 👉 Sirve para saber si un número es PAR o IMPAR
             * 
             * EJEMPLOS:
             * 2 % 2 = 0 → PAR
             * 3 % 2 = 1 → IMPAR
             */
            if ((i + 1) % 2 == 0) {

                /**
                 * ✅ SI ES PAR → MASCOTA COMPLETA
                 * Se le asignan TODAS las vacunas
                 */
                p.registrarVacuna("Rabia", hoy);
                p.registrarVacuna("Parvo", hoy);
                p.registrarVacuna("Moquillo", hoy);

            } else {

                /**
                 * ⚠️ SI ES IMPAR → MASCOTA INCOMPLETA
                 * Solo tiene una vacuna
                 */
                p.registrarVacuna("Rabia", hoy);
            }

            // 📌 Se añade el perro a la lista general
            lista.add(p);
        }

        // =========================
        // 🐱 CREACIÓN DE GATOS
        // =========================

        for (int i = 0; i < 20; i++) {

            /**
             * 🧱 Se crea un objeto Gato
             * ID empieza en 21 para no repetir con perros
             */
            Gato g = new Gato(
                    i + 21,
                    nombresGatos[i],
                    4 + i,
                    3.0 + i,

                    /**
                     * 🧠 CONDICIÓN BOOLEAN
                     * i % 2 == 0
                     * 
                     * 👉 true si es par
                     * 👉 false si es impar
                     * 
                     * Puede representar:
                     * - si es doméstico
                     * - si está esterilizado
                     */
                    i % 2 == 0
            );

            /**
             * 🧠 SEGUNDA CONDICIÓN DE VACUNAS
             * (i + 21) % 2 == 0
             * 
             * 👉 Igual que en perros:
             * pares → completos
             * impares → incompletos
             */
            if ((i + 21) % 2 == 0) {

                // 💉 GATO COMPLETO
                g.registrarVacuna("Triple Felina", hoy);
                g.registrarVacuna("Leucemia", hoy);
                g.registrarVacuna("Rabia", hoy);

            } else {

                // ⚠️ GATO INCOMPLETO
                g.registrarVacuna("Triple Felina", hoy);
            }

            // 📌 Se añade a la lista
            lista.add(g);
        }

        // 🔚 Se devuelve la lista con las 40 mascotas
        return lista;
    }
}