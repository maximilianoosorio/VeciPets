package com.example.application.views.empty;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

public class NavbarComponent extends HorizontalLayout {

    public NavbarComponent() {
        setWidthFull();
        setHeight("70px"); // un poco más compacto
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // 🎨 NAVBAR MODERNO
        getStyle()
                .set("background-color", "#1E88E5") // azul principal
                .set("padding", "0 20px")
                .set("box-shadow", "0px 2px 8px rgba(0,0,0,0.1)"); // más suave

        H2 logo = new H2("🐾 VeciPets Pro");

        logo.getStyle()
                .set("color", "white")
                .set("margin", "0")
                .set("font-size", "22px")
                .set("font-weight", "700");

        add(logo);
    }
}