package com.example.application.views.empty;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//recibe una mascota y construye una tarjeta visual con su información
public class MascotaCard extends VerticalLayout {

    public MascotaCard(Mascota mascota) {
        setAlignItems(Alignment.CENTER);
        setWidth("260px");

        // 🎨 TARJETA MÁS PRO (estilo de las tarjetas )
        getStyle()
                .set("background-color", "#EEF6FD") // 🔥 mejora visual
                .set("border-radius", "20px")
                .set("padding", "20px")
                .set("margin", "10px")
                .set("box-shadow", "0px 6px 14px rgba(0,0,0,0.12)")
                .set("cursor", "pointer")
                .set("transition", "transform 0.2s");

                //efecto de la tarjeta
        getElement().addEventListener("mouseover",
                e -> getStyle().set("transform", "scale(1.05)"));

        getElement().addEventListener("mouseout",
                e -> getStyle().set("transform", "scale(1.0)"));

                //IMAGEN DINAMICA (se usa polimorfismo para asisnar imagenes diferentes)
        // Esto se usa para evitar que las imágenes sean siempre las mismas
        int random = (int) (Math.random() * 1000);
        // Esto se usa para evitar que las imágenes sean siempre las mismas
        String url = (mascota instanceof Perro)
        ? "https://loremflickr.com/300/300/dog?lock=" + random
        : "https://loremflickr.com/300/300/cat?lock=" + random;

        Image foto = new Image(url, mascota.getNombre());
        foto.setWidth("150px");
        foto.setHeight("150px");
        foto.getStyle()
                .set("border-radius", "50%")
                .set("object-fit", "cover")
                .set("border", "4px solid #90CAF9");


                //informacion de la mascota
        H3 nombre = new H3(mascota.getNombre());
        nombre.getStyle().set("color", "#0D47A1");

        Span info = new Span(mascota.getEdadMeses() + " meses | " + mascota.getPeso() + " kg");
        info.getStyle()
                .set("color", "#37474F")
                .set("font-weight", "600");

        this.addClickListener(e -> abrirDetalleExacto(mascota, url));

        String estadoSalud = (mascota instanceof IInmunizable)
                ? ((IInmunizable) mascota).obtenerEstadoSalud()
                : "";

                //vacunas
        int numVacunas = (mascota instanceof IInmunizable inmunizable)
        ? inmunizable.getNumeroVacunas()
        : 0;

        // 🏷️ BADGE (si la mascota está disponible o en proceso.)
        Span estado = new Span(numVacunas >= 3 ? "Disponible" : "En proceso");

        estado.getStyle()
                .set("background", numVacunas >= 3 ? "#C8E6C9" : "#FFE0B2")
                .set("color", "#333")
                .set("font-size", "12px")
                .set("padding", "4px 10px")
                .set("border-radius", "20px")
                .set("font-weight", "600");

        addComponentAsFirst(estado);

        add(foto, nombre, info);

        if (numVacunas >= 3) {
                //boton adoptar
            Button adoptarBtn = new Button("Adoptar ✨",
                    e -> new FormularioAdopcion(mascota).open());

            adoptarBtn.getStyle()
                    .set("background-color", "#1E88E5")
                    .set("color", "white")
                    .set("border-radius", "12px")
                    .set("width", "100%")
                    .set("font-weight", "bold")
                    .set("box-shadow", "0px 4px 10px rgba(0,0,0,0.15)")
                    .set("transition", "all 0.2s ease");

            // 🔥 hover
            adoptarBtn.getElement().addEventListener("mouseover",
                    e -> adoptarBtn.getStyle().set("transform", "scale(1.05)"));

            adoptarBtn.getElement().addEventListener("mouseout",
                    e -> adoptarBtn.getStyle().set("transform", "scale(1)"));

            add(adoptarBtn);

        } else {
            Span avisoSalud = new Span(
                    VaadinIcon.WARNING.create(),
                    new Span(" Salud en proceso")
            );

            avisoSalud.getStyle()
                    .set("color", "#EF5350")
                    .set("background", "#FFEBEE")
                    .set("border-radius", "8px")
                    .set("padding", "6px 10px")
                    .set("font-weight", "bold");

            add(avisoSalud);
        }
    }

    //muestra informacion detallada
    private void abrirDetalleExacto(Mascota mascota, String urlImagen) {
        Dialog dialog = new Dialog();
        dialog.setMaxWidth("950px");

        HorizontalLayout mainPanel = new HorizontalLayout();
        mainPanel.setSpacing(true);

        VerticalLayout leftCol = new VerticalLayout();
        leftCol.setWidth("400px");
        leftCol.setAlignItems(Alignment.CENTER);
        leftCol.getStyle()
                .set("background-color", "#F5F9FF")
                .set("border-radius", "15px");

        H2 titulo = new H2(mascota.getNombre().toUpperCase() + " (ADOPCIÓN)");
        titulo.getStyle().set("color", "#0D47A1");

        String razaStr = (mascota instanceof Perro)
                ? ((Perro) mascota).getRaza()
                : "Gato Doméstico";

        Span sub = new Span(razaStr + " | " + mascota.getEdadMeses() + " meses");
        sub.getStyle().set("color", "#546E7A");

        Image fotoGrande = new Image(urlImagen, mascota.getNombre());
        fotoGrande.setWidth("320px");
        fotoGrande.getStyle()
                .set("border-radius", "15px")
                .set("border", "5px solid white");

        String estadoSalud = (mascota instanceof IInmunizable)
                ? ((IInmunizable) mascota).obtenerEstadoSalud()
                : "";

        int numVacunas = (estadoSalud.contains("•"))
                ? estadoSalud.split(" • ").length
                : (estadoSalud.equals("Esquema pendiente") ? 0 : 1);


                //Validacion de adopcion
        if (numVacunas >= 3) {
            Button btnSolicitud = new Button(
                    "INICIAR SOLICITUD DE ADOPCIÓN",
                    VaadinIcon.CLIPBOARD_CHECK.create()
            );

            btnSolicitud.getStyle()
                    .set("background-color", "#1E88E5")
                    .set("color", "white")
                    .set("margin-top", "15px")
                    .set("font-weight", "bold");

            btnSolicitud.setWidthFull();

            btnSolicitud.addClickListener(e -> {
                dialog.close();
                new FormularioAdopcion(mascota).open();
            });

            leftCol.add(titulo, sub, fotoGrande, btnSolicitud);
        } else {
            Div msgError = new Div(
                    new Span("⚠️ No apto para adopción inmediata. Debe completar su esquema de vacunación (Mínimo 3).")
            );

            msgError.getStyle()
                    .set("color", "#C62828")
                    .set("background", "#FFEBEE")
                    .set("padding", "15px")
                    .set("border-radius", "10px")
                    .set("margin-top", "15px")
                    .set("font-size", "0.9em")
                    .set("font-weight", "600");

            leftCol.add(titulo, sub, fotoGrande, msgError);
        }

        Button btnPreguntar = new Button(
                "WHATSAPP DE CONTACTO",
                VaadinIcon.CHAT.create()
        );

        btnPreguntar.getStyle()
                .set("background-color", "#25D366")
                .set("color", "white")
                .set("font-weight", "bold");

        btnPreguntar.setWidthFull();

        btnPreguntar.addClickListener(e -> {
            String mensaje = "Hola VeciPets, me interesa saber cuándo estará listo "
                    + mascota.getNombre() + " para adopción";

            String urlWa = "https://wa.me/573000000000?text="
                    + mensaje.replace(" ", "%20");

            UI.getCurrent().getPage().open(urlWa, "_blank");
        });

        leftCol.add(btnPreguntar);

        VerticalLayout rightCol = new VerticalLayout();

        H4 hSalud = new H4(
                VaadinIcon.HEART.create(),
                new Span(" ESTADO DE SALUD")
        );
        hSalud.getStyle().set("color", "#1E88E5");

        VerticalLayout healthBox = new VerticalLayout();
        healthBox.getStyle()
                .set("background-color", "#E3F2FD")
                .set("border-radius", "10px")
                .set("border", "1px solid #BBDEFB");

        healthBox.add(
                new Span("💉 Vacunas registradas: " + (estadoSalud.isEmpty() ? "Ninguna" : estadoSalud)),
                new Span("✅ Desparasitado: Al día"),
                new Span("✅ Microchip: Registrado")
        );

        H4 hConoceme = new H4(
                VaadinIcon.INFO_CIRCLE.create(),
                new Span(" CONÓCEME")
        );
        hConoceme.getStyle().set("color", "#1E88E5");

        VerticalLayout infoBox = new VerticalLayout();
        infoBox.getStyle()
                .set("background-color", "#F5F5F5")
                .set("border-radius", "10px");

        infoBox.add(
                new Span("👤 Carácter: Muy sociable"),
                new Span("⚡ Energía: Alta"),
                new Span("🏠 Entorno: Casa o Apto")
        );

        H4 hHistoria = new H4(
                VaadinIcon.BOOK.create(),
                new Span(" HISTORIA")
        );
        hHistoria.getStyle().set("color", "#1E88E5");

        
        Paragraph historia = new Paragraph(
                mascota.getNombre() + " es una mascota rescatada que "
                        + mascota.obtenerCuidadosEspeciales()
        );

        rightCol.add(hSalud, healthBox, hConoceme, infoBox, hHistoria, historia);

        mainPanel.add(leftCol, rightCol);
        dialog.add(mainPanel);
        dialog.open();
    }
}