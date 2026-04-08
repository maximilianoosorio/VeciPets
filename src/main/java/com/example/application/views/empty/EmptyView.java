package com.example.application.views.empty;

import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * 🖥️ VISTA PRINCIPAL (UI)
 * Se encarga de mostrar las mascotas y permitir filtrarlas.
 * Extiende VerticalLayout → herencia de Vaadin.
 */
@PageTitle("VeciPets Pro | Inicio")
@Route(value = "")
public class EmptyView extends VerticalLayout {

    // 📦 Contenedor visual donde se renderizan las tarjetas
    private HorizontalLayout catalogo = new HorizontalLayout();

    // 📊 Lista de datos 
    private List<Mascota> todasLasMascotas;

    /**
     * 🧱 CONSTRUCTOR
     * Inicializa la vista, carga datos y construye la UI.
     */
    public EmptyView() {

        // 🎨 Configuración visual base
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        getStyle().set("background-color", "#f8f9fa");

        /**
         * 🔥 MANEJO DE EXCEPCIONES (TRY-CATCH)
         * Evita que la app se rompa si falla el servicio.
         */
        try {
            todasLasMascotas = MascotasService.obtenerMascotas();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔝 Navbar reutilizable (composición)
        add(new NavbarComponent());

        /**
         * 🔘 BARRA DE FILTROS
         */
        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setWidthFull();
        filtros.getStyle().set("padding", "20px");
        filtros.setJustifyContentMode(JustifyContentMode.CENTER);

        // Botones con eventos (programación orientada a eventos)
        Button btnTodos = new Button("Todos", e -> mostrarMascotas(todasLasMascotas));
        Button btnPerros = new Button("Perros 🐶", e -> filtrar(Perro.class));
        Button btnGatos = new Button("Gatos 🐱", e -> filtrar(Gato.class));

        // 📦 Se crea un array (lista) de botones
        Button[] botones = {btnTodos, btnPerros, btnGatos};

        // 📦 Se crea un array (lista) de botones
        for (Button btn : botones) {
            // 🎨 Se aplica estilo a cada botón
            btn.getStyle()
            // 🎨 Se aplica estilo a cada botón
                    .set("cursor", "pointer")
                     // Cambia el cursor a "mano" al pasar por encima (mejora UX)
                    .set("border-radius", "10px");
        }

        // Esto hace que los botones aparezcan en la misma fila
        filtros.add(btnTodos, btnPerros, btnGatos);
        add(filtros);

        /**
         * 📦 CATÁLOGO (layout flexible)
         */
        catalogo.setWidthFull();
        catalogo.getStyle()
                .set("padding", "20px")
                .set("flex-wrap", "wrap") // responsive
                .set("gap", "20px");

        catalogo.setJustifyContentMode(JustifyContentMode.CENTER);

        // Carga inicial
        mostrarMascotas(todasLasMascotas);
        add(catalogo);
    }

  /**
 * 🔍 Filtra la lista de mascotas según el tipo recibido (Perro, Gato, etc.)
 * 
 * @param claseFiltro Clase que extiende de Mascota (ej: Perro.class)
 */
private void filtrar(Class<? extends Mascota> claseFiltro) {

    // 📌 Se convierte la lista en un stream para poder procesarla
    List<Mascota> filtradas = todasLasMascotas.stream()
            
            // 🧠 POLIMORFISMO:
            // Se filtran solo los objetos que son instancia de la clase recibida
            // (ej: solo Perro o solo Gato)
            .filter(claseFiltro::isInstance)
            
            // 🔄 Se convierte nuevamente a lista
            .collect(Collectors.toList());

    // 🎨 Se actualiza la interfaz mostrando solo las mascotas filtradas
    mostrarMascotas(filtradas);
}

    /**
     * 
     * Renderiza dinámicamente las tarjetas
     */
    private void mostrarMascotas(List<Mascota> lista) {
        catalogo.removeAll(); // limpia antes de pintar
        // 🐾 Por cada mascota se crea una tarjeta visual (MascotaCard)
        // y se añade al catálogo (layout)
        lista.forEach(m -> catalogo.add(new MascotaCard(m))); // lambda
    }
}