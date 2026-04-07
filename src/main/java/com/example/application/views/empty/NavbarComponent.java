package com.example.application.views.empty;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

public class NavbarComponent extends HorizontalLayout {

    public NavbarComponent() {
        setWidthFull();
        setHeight("75px");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER); // Logo centrado

        getStyle()
                .set("background-color", "#01579B")
                .set("padding", "0 30px")
                .set("box-shadow", "0px 3px 10px rgba(0,0,0,0.2)");

        H2 logo = new H2("🐾 VeciPets Pro");
        logo.getStyle().set("color", "white").set("margin", "0");

        add(logo);
    }
}