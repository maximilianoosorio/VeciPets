package com.example.application.views.empty;

import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
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

        // 🎨 FONDO BLANCO LIMPIO
        getStyle().set("background-color", "#FFFFFF");

        todasLasMascotas = MascotasService.obtenerMascotas();

        add(new NavbarComponent());

        // 🔘 BARRA DE FILTROS
        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setWidthFull();
        filtros.getStyle()
                .set("padding", "20px")
                .set("gap", "10px");

        filtros.setJustifyContentMode(JustifyContentMode.CENTER);

        Button btnTodos = new Button("Todos", e -> mostrarMascotas(todasLasMascotas));
        Button btnPerros = new Button("Perros 🐶", e -> filtrar(Perro.class));
        Button btnGatos = new Button("Gatos 🐱", e -> filtrar(Gato.class));

        // 🎨 ESTILO BOTONES MODERNO
        Button[] botones = {btnTodos, btnPerros, btnGatos};

        for (Button btn : botones) {
            btn.getStyle()
                    .set("background-color", "#E3F2FD") // azul clarito
                    .set("color", "#0D47A1")
                    .set("border-radius", "12px")
                    .set("padding", "10px 18px")
                    .set("font-weight", "600")
                    .set("cursor", "pointer")
                    .set("transition", "all 0.2s ease");

            // Hover efecto
            btn.getElement().addEventListener("mouseover",
                    e -> btn.getStyle().set("background-color", "#BBDEFB"));

            btn.getElement().addEventListener("mouseout",
                    e -> btn.getStyle().set("background-color", "#E3F2FD"));
        }

        filtros.add(btnTodos, btnPerros, btnGatos);
        add(filtros);

        // 📦 CATÁLOGO
        catalogo.setWidthFull();
        catalogo.getStyle()
                .set("padding", "30px")
                .set("flex-wrap", "wrap")
                .set("gap", "25px");

        catalogo.setJustifyContentMode(JustifyContentMode.CENTER);

        mostrarMascotas(todasLasMascotas);
        add(catalogo);
    }

    private void filtrar(Class<?> claseFiltro) {
        List<Mascota> filtradas = todasLasMascotas.stream()
                .filter(claseFiltro::isInstance)
                .collect(Collectors.toList());

        mostrarMascotas(filtradas);
    }

    private void mostrarMascotas(List<Mascota> lista) {
        catalogo.removeAll();

        for (Mascota m : lista) {
            catalogo.add(new MascotaCard(m));
        }
    }
}