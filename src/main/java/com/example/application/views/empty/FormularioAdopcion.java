package com.example.application.views.empty;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.H2;

public class FormularioAdopcion extends Dialog {

    public FormularioAdopcion(Mascota mascota) {

        setWidth("400px");

        // 🎨 CONTENEDOR PRINCIPAL
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setAlignItems(Alignment.CENTER);

        layout.getStyle().set("background", "#e6f2ff");
        layout.getStyle().set("border-radius", "15px");

        // 🐶 TÍTULO
        H2 titulo = new H2("Adoptar a " + mascota.getNombre());
        titulo.getStyle().set("color", "#2b7cff");

        // 📝 CAMPOS
        TextField nombre = new TextField("Nombre");
        TextField documento = new TextField("Documento");
        TextField celular = new TextField("Celular");

        nombre.setWidthFull();
        documento.setWidthFull();
        celular.setWidthFull();

        // 🔥 BOTÓN ENVIAR
        Button enviar = new Button("Enviar", e -> {

            if (nombre.isEmpty() || documento.isEmpty() || celular.isEmpty()) {
                Notification.show("Completa todos los campos");
            } else {

                String nombrePersona = nombre.getValue();

                close(); // cerrar formulario

                Notification n = Notification.show(
                        "Gracias " + nombrePersona + ", nos comunicaremos contigo pronto 🐾",
                        4000,
                        Notification.Position.MIDDLE
                );

                // 🎨 estilo azul cielo
                n.getStyle().set("background", "#4da6ff");
                n.getStyle().set("color", "white");
                n.getStyle().set("border-radius", "10px");
            }
        });

        enviar.getStyle().set("background", "#4da6ff");
        enviar.getStyle().set("color", "white");
        enviar.getStyle().set("border-radius", "10px");

        layout.add(titulo, nombre, documento, celular, enviar);

        add(layout);
    }
}