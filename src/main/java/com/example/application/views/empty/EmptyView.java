package com.example.application.views.empty;

import java.util.List;
import java.util.stream.Collectors;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("VeciPets Pro | Inicio")
@Route(value = "")
public class EmptyView extends VerticalLayout {

    private HorizontalLayout catalogo = new HorizontalLayout();
    private List<Mascota> todasLasMascotas;

    public EmptyView() {
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        getStyle().set("background-color", "#f8f9fa");

        // 1. Datos iniciales
        todasLasMascotas = MascotasService.obtenerMascotas();

        // 2. Navbar (Barra Azul)
        add(new NavbarComponent());

        // 3. BARRA DE FILTROS (Botones)
        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setWidthFull();
        filtros.getStyle().set("padding", "20px");
        filtros.setJustifyContentMode(JustifyContentMode.CENTER);

        Button btnTodos = new Button("Todos", e -> mostrarMascotas(todasLasMascotas));
        Button btnPerros = new Button("Perros 🐶", e -> filtrar(Perro.class));
        Button btnGatos = new Button("Gatos 🐱", e -> filtrar(Gato.class));

        // Estilo a los botones de filtro
        btnTodos.getStyle().set("cursor", "pointer");
        btnPerros.getStyle().set("cursor", "pointer");
        btnGatos.getStyle().set("cursor", "pointer");

        filtros.add(btnTodos, btnPerros, btnGatos);
        add(filtros);

        // 4. Catálogo (Donde se ven las tarjetas)
        catalogo.setWidthFull();
        catalogo.getStyle().set("padding", "20px").set("flex-wrap", "wrap");
        catalogo.setJustifyContentMode(JustifyContentMode.CENTER);
        
        mostrarMascotas(todasLasMascotas); // Carga inicial
        add(catalogo);
    }

    // Método para filtrar usando Polimorfismo
    private void filtrar(Class<?> claseFiltro) {
        List<Mascota> filtradas = todasLasMascotas.stream()
                .filter(claseFiltro::isInstance)
                .collect(Collectors.toList());
        mostrarMascotas(filtradas);
    }

    // Método para refrescar las tarjetas en pantalla
    private void mostrarMascotas(List<Mascota> lista) {
        catalogo.removeAll();
        for (Mascota m : lista) {
            catalogo.add(new MascotaCard(m));
        }
    }
}