package org.gk.reception.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.gk.reception.viewmodel.MainViewModel;

@Route("thank-you")
public class ThankYouView extends VerticalLayout {
    H1 thankYouText = new H1("Thank you for your RSVP!");
    public Button backToMain = new Button("Back to Main");

    public ThankYouView() {
        add(thankYouText);
        add(backToMain);
        addClassName("thank-you-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
