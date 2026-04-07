package com.example.application.views.empty;

import java.util.List;
import java.util.stream.Collectors;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Vista principal de VeciPets Pro.
 * Aquí se cargan las tarjetas y funcionan los filtros de búsqueda.
 */
@PageTitle("VeciPets Pro | Inicio")
@Route(value = "") // Define esta como la página principal
public class EmptyView extends VerticalLayout {

    private HorizontalLayout catalogo = new HorizontalLayout();
    private List<Mascota> todasLasMascotas;

    public EmptyView() {
        // Configuración estética del fondo
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        getStyle().set("background-color", "#f8f9fa");

        // 1. Cargar datos desde el Service (Asegúrate de tener este archivo creado)
        todasLasMascotas = MascotasService.obtenerMascotas();

        // 2. Navbar (El logo azul de arriba)
        add(new NavbarComponent());

        // 3. BARRA DE FILTROS
        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setWidthFull();
        filtros.getStyle().set("padding", "20px");
        filtros.setJustifyContentMode(JustifyContentMode.CENTER);

        // Botones de filtrado rápido
        Button btnTodos = new Button("Todos", e -> mostrarMascotas(todasLasMascotas));
        Button btnPerros = new Button("Perros 🐶", e -> filtrar(Perro.class));
        Button btnGatos = new Button("Gatos 🐱", e -> filtrar(Gato.class));

        // Estilo de botones
        btnTodos.getStyle().set("cursor", "pointer").set("border-radius", "10px");
        btnPerros.getStyle().set("cursor", "pointer").set("border-radius", "10px");
        btnGatos.getStyle().set("cursor", "pointer").set("border-radius", "10px");

        filtros.add(btnTodos, btnPerros, btnGatos);
        add(filtros);

        // 4. CATÁLOGO DE TARJETAS
        catalogo.setWidthFull();
        catalogo.getStyle()
                .set("padding", "20px")
                .set("flex-wrap", "wrap") // Permite que las tarjetas bajen a la siguiente línea
                .set("gap", "20px");
        catalogo.setJustifyContentMode(JustifyContentMode.CENTER);
        
        // Carga inicial de todas las mascotas
        mostrarMascotas(todasLasMascotas); 
        add(catalogo);
    }

    /**
     * Aplica polimorfismo para filtrar la lista basándose en la clase (Perro o Gato).
     */
    private void filtrar(Class<?> claseFiltro) {
        List<Mascota> filtradas = todasLasMascotas.stream()
                .filter(claseFiltro::isInstance)
                .collect(Collectors.toList());
        mostrarMascotas(filtradas);
    }

    /**
     * Refresca el catálogo visual con la lista proporcionada.
     */
    private void mostrarMascotas(List<Mascota> lista) {
        catalogo.removeAll(); // Limpia lo que hay antes de mostrar lo nuevo
        for (Mascota m : lista) {
            // Se crea la tarjeta y se añade al catálogo
            catalogo.add(new MascotaCard(m));
        }
    }
}