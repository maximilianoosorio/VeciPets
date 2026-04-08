package com.example.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/**
 * Layout principal SIN navbar automático.
 * Solo se usa como contenedor (sin header ni drawer).
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout implements AfterNavigationObserver {

    public MainLayout() {
        // ❌ No agregamos header
        // ❌ No agregamos drawer
        // 👉 Layout limpio
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // No hacemos nada aquí porque no usamos título dinámico
    }
}