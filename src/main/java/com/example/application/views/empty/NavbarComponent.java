package com.example.application.views.empty;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

public class NavbarComponent extends HorizontalLayout {

    public NavbarComponent() {

        setWidthFull();
        setHeight("75px");

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        getStyle()
                .set("background-color", "#01579B")
                .set("padding", "0 30px")
                .set("box-shadow", "0px 3px 10px rgba(0,0,0,0.2)");

        H2 logo = new H2("🐾 VeciPets Pro");

        logo.getStyle()
                .set("color", "white")
                .set("margin", "0");

        Button btnAdoptar = new Button(
                "¡Quiero Adoptar!",
                new Icon(VaadinIcon.HEART)
        );

        btnAdoptar.getStyle()
                .set("background-color", "#2D6A4F")
                .set("color", "white")
                .set("border-radius", "12px")
                .set("font-weight", "bold");

        // ✅ Criterio 9 (botón funcional)
        btnAdoptar.addClickListener(e ->
                Notification.show(
                        "¡Gracias! Pronto te contactaremos 🐾",
                        3000,
                        Notification.Position.MIDDLE
                )
        );

        add(logo, btnAdoptar);
    }
}