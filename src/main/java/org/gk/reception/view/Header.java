package org.gk.reception.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Header extends HorizontalLayout {

    public Header() {
        H6 rsvpDinnerSelectionTextH6 = new H6("Wedding Reception");
        Text headerText = new Text("June 1, 2024");
        Text headerTextBerlin = new Text("   Berlin");
        add(rsvpDinnerSelectionTextH6, headerText, headerTextBerlin);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        addClassName("header");
    }

}
