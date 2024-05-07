package org.gk.reception.view;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("thank-you")
public class ThankYouView extends VerticalLayout {
    H1 thankYouText = new H1("Thank you for your RSVP!");
    // Add a link to a completely different website, https://www.zola.com/wedding/gilbertkirajoy/faq
    public Anchor faqLink = new Anchor("https://www.zola.com/wedding/gilbertkirajoy/faq", "Wedding Page");

    public ThankYouView() {
        add(thankYouText);
        add(faqLink);
        addClassName("thank-you-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
