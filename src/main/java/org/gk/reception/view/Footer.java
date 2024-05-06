package org.gk.reception.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Footer extends HorizontalLayout {
    public Footer() {
        Text footerCopyrightText = new Text("© 2023 Gilbert & Kira Joy");
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(footerCopyrightText);
        addClassName("footer");
    }
}
