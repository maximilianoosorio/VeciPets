package com.example.application.views.empty;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
public class EmptyView extends VerticalLayout {

    public EmptyView() {

        setSizeFull();
        getStyle().set("background-color", "#eef3f7");

        // 🔽 BAJAR MÁS TODO
        setPadding(true);
        setSpacing(true);
        getStyle().set("padding-top", "80px"); // 🔥 MÁS ABAJO

        HorizontalLayout catalogo = new HorizontalLayout();
        catalogo.setWidthFull();
        catalogo.getStyle().set("flex-wrap", "wrap");
        catalogo.getStyle().set("justify-content", "center");
        catalogo.getStyle().set("gap", "30px");

        List<Mascota> mascotas = MascotasService.obtenerMascotas();

        for (Mascota m : mascotas) {

            VerticalLayout card = new VerticalLayout();
            card.setWidth("270px");
            card.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

            // 🎨 ESTILO VECIPETS
            card.getStyle().set("background", "white");
            card.getStyle().set("border-radius", "18px");
            card.getStyle().set("box-shadow", "0 8px 18px rgba(0,0,0,0.15)");
            card.getStyle().set("padding", "15px");

            // 🐶🐱 FOTOS REALES
            Image img;
            if (m instanceof Perro) {
                img = new Image("https://images.unsplash.com/photo-1558788353-f76d92427f16?w=400", "Perro");
            } else {
                img = new Image("https://images.unsplash.com/photo-1518791841217-8f162f1e1131?w=400", "Gato");
            }
            img.setWidth("100%");
            img.getStyle().set("border-radius", "12px");

            // 📝 DATOS
            H3 nombre = new H3(m.getNombre());
            Span edad = new Span("Edad: " + m.getEdadMeses() + " meses");
            Span peso = new Span("Peso: " + m.getPeso() + " kg");

            card.add(img, nombre, edad, peso);
            catalogo.add(card);
        }

        add(catalogo);
    }
}