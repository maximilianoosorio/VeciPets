package com.example.application.views.empty;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

public class MascotaCard extends VerticalLayout {

    public MascotaCard(Mascota mascota) {
        // 1. Configuración del contenedor de la tarjeta
        setAlignItems(Alignment.CENTER);
        setWidth("260px");
        
        // Estilo visual (Criterio 13)
        getStyle()
                .set("background-color", "#ffffff")
                .set("border-radius", "20px")
                .set("padding", "20px")
                .set("margin", "10px")
                .set("box-shadow", "0px 8px 18px rgba(0,0,0,0.15)")
                .set("transition", "transform 0.2s");

        // Efecto hover (se agranda un poquito al pasar el mouse)
        getElement().addEventListener("mouseover", e -> getStyle().set("transform", "scale(1.05)"));
        getElement().addEventListener("mouseout", e -> getStyle().set("transform", "scale(1.0)"));

        // --- SOLUCIÓN: IMÁGENES DINÁMICAS (Para que no se repitan) ---
        String url;
        if (mascota instanceof Perro) {
            // Usamos el ID único para traer un perro diferente
            url = "https://loremflickr.com/300/300/dog?lock=" + mascota.getId();
        } else {
            // Usamos el ID único para traer un gato diferente
            url = "https://loremflickr.com/300/300/cat?lock=" + mascota.getId();
        }
            
        Image foto = new Image(url, mascota.getNombre());
        
        // --- DISEÑO DE LA FOTO (Circular y Centrada) ---
        foto.setWidth("150px");
        foto.setHeight("150px");
        foto.getStyle()
                .set("border-radius", "50%")
                .set("object-fit", "cover") // Recorta la imagen para que encaje perfecto
                .set("border", "4px solid #e3f2fd")
                .set("box-shadow", "0px 4px 8px rgba(0,0,0,0.1)");

        // 2. Información de la Mascota
        H3 nombre = new H3(mascota.getNombre());
        nombre.getStyle()
                .set("color", "#01579B")
                .set("margin", "15px 0 5px 0")
                .set("text-transform", "capitalize");

        Span info = new Span(mascota.getEdadMeses() + " meses | " + mascota.getPeso() + " kg");
        info.getStyle()
                .set("color", "#757575")
                .set("font-weight", "600")
                .set("font-size", "0.9em");

        // Polimorfismo: obtenerCuidadosEspeciales()
        Span cuidados = new Span(mascota.obtenerCuidadosEspeciales());
        cuidados.getStyle()
                .set("font-size", "0.8em")
                .set("text-align", "center")
                .set("color", "#546e7a")
                .set("margin-top", "10px")
                .set("font-style", "italic");

        // 3. Botón Adoptar (Azul cielo brillante)
        Button adoptarBtn = new Button("Adoptar ✨", e -> {
            new FormularioAdopcion(mascota).open();
        });
        
        adoptarBtn.getStyle()
                .set("background-color", "#4da6ff")
                .set("color", "white")
                .set("border-radius", "12px")
                .set("width", "100%")
                .set("margin-top", "20px")
                .set("font-weight", "bold")
                .set("cursor", "pointer")
                .set("box-shadow", "0px 4px 10px rgba(77, 166, 255, 0.3)");

        add(foto, nombre, info, cuidados, adoptarBtn);
    }
}