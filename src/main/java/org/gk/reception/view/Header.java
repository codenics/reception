package org.gk.reception.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Header extends HorizontalLayout {

    public Header() {
        Text headerText = new Text("June 1, 2024");
        Text headerTextBerlin = new Text(" Berlin");
        add(headerText, headerTextBerlin);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        addClassName("header");
    }

}
