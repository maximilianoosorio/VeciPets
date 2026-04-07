package com.example.application.views.empty;


import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

public class MascotaCard extends VerticalLayout {

    public MascotaCard(Mascota mascota) {

        setAlignItems(Alignment.CENTER);

        setWidth("260px");

        getStyle()
                .set("background-color", "#E1F5FE")
                .set("border-radius", "20px")
                .set("padding", "20px")
                .set("margin", "10px")
                .set("box-shadow", "0px 4px 12px rgba(0,0,0,0.15)");

        String url;

        if (mascota instanceof Perro) {

            url = "https://images.dog.ceo/breeds/retriever-golden/n02099601_3004.jpg";

        } else {

            url = "https://images.theconversation.com/files/350865/original/file-20200803-24-1hubxad.jpg";

        }

        Image foto = new Image(url, mascota.getNombre());

        foto.setWidth("120px");

        foto.getStyle()
                .set("border-radius", "50%");

        H3 nombre = new H3(mascota.getNombre());

        nombre.getStyle()
                .set("color", "#01579B");

        Span info = new Span(

                mascota.getEdadMeses()
                        + " meses | "
                        + mascota.getPeso()
                        + " kg"

        );

        info.getStyle()
                .set("color", "#2D6A4F");

        // ✅ POLIMORFISMO
        Span cuidados = new Span(
                mascota.obtenerCuidadosEspeciales()
        );

        cuidados.getStyle()
                .set("font-size", "0.8em")
                .set("text-align", "center")
                .set("color", "#555");

        Button adoptarBtn = new Button("Adoptar 🐾");

        adoptarBtn.getStyle()
                .set("background-color", "#2D6A4F")
                .set("color", "white")
                .set("border-radius", "10px");

        adoptarBtn.addClickListener(e ->
                Notification.show(
                        mascota.getNombre()
                                + " ahora espera tu adopción ❤️"
                )
        );

        add(
                foto,
                nombre,
                info,
                cuidados,
                adoptarBtn
        );
    }
}