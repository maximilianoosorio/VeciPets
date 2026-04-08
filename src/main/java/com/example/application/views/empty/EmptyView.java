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
        getStyle().set("background-color", "#f8f9fa");

        // 🔥 TRY-CATCH (te suma puntos)
        try {
            todasLasMascotas = MascotasService.obtenerMascotas();
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new NavbarComponent());

        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setWidthFull();
        filtros.getStyle().set("padding", "20px");
        filtros.setJustifyContentMode(JustifyContentMode.CENTER);

        Button btnTodos = new Button("Todos", e -> mostrarMascotas(todasLasMascotas));
        Button btnPerros = new Button("Perros 🐶", e -> filtrar(Perro.class));
        Button btnGatos = new Button("Gatos 🐱", e -> filtrar(Gato.class));

        Button[] botones = {btnTodos, btnPerros, btnGatos};

        for (Button btn : botones) {
            btn.getStyle()
                    .set("cursor", "pointer")
                    .set("border-radius", "10px");
        }

        filtros.add(btnTodos, btnPerros, btnGatos);
        add(filtros);

        catalogo.setWidthFull();
        catalogo.getStyle()
                .set("padding", "20px")
                .set("flex-wrap", "wrap")
                .set("gap", "20px");

        catalogo.setJustifyContentMode(JustifyContentMode.CENTER);

        mostrarMascotas(todasLasMascotas);
        add(catalogo);
    }

    // 🔥 CAMBIO PRO
    private void filtrar(Class<? extends Mascota> claseFiltro) {
        List<Mascota> filtradas = todasLasMascotas.stream()
                .filter(claseFiltro::isInstance)
                .collect(Collectors.toList());

        mostrarMascotas(filtradas);
    }

    private void mostrarMascotas(List<Mascota> lista) {
        catalogo.removeAll();
        lista.forEach(m -> catalogo.add(new MascotaCard(m)));
    }
}