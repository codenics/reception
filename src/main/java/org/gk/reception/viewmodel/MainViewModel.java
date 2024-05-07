package org.gk.reception.viewmodel;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import org.gk.reception.model.Dinner;
import org.gk.reception.repository.DinnerRepository;
import org.gk.reception.view.Footer;
import org.gk.reception.view.Header;
import org.gk.reception.view.SelectFoodView;
import org.gk.reception.view.ThankYouView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Route(value = "")
@RouteAlias("home")
@RouteAlias("main")
@PreserveOnRefresh
@CssImport("resources/static/styles.css")
public class MainViewModel extends Div {
    // add logging to entire codebase
    private static final Logger log = LoggerFactory.getLogger(MainViewModel.class);
    private final Binder<Dinner> binder = new Binder<>(Dinner.class);

    private final DinnerRepository dinnerRepository;
    H1 coupleText = new H1("Gilbert & Kira Joy");
    H3 rsvpDinnerSelectionText = new H3("Please RSVP & Select Main Course");
    TextField firstNameField = new TextField("First Name");
    TextField cityField = new TextField("City");
    Button submitButton = new Button("Submit");
    Footer footer = new Footer();
    Header header = new Header();

    VerticalLayout pageContent = new VerticalLayout();
    HorizontalLayout nameCityHorizontalLayout = new HorizontalLayout();
    RadioButtonGroup<String> yesNoRadio = new RadioButtonGroup<>();
    SelectFoodView selectFoodView = new SelectFoodView();
    ThankYouView thankYouView = new ThankYouView();

    MainViewModel(DinnerRepository dinnerRepository) {
        this.dinnerRepository = dinnerRepository;
        initComponents();
        selectFoodView.setVisible(false);
        // add header, pageContent, and footer to the main view
        add(header, pageContent, footer);

        yesNoRadio.addValueChangeListener(event -> {
            selectFoodView.setVisible(event.getValue().equals("Yes"));
            log.info("RSVP selection changed to " + event.getValue());
        });

    }

    void initComponents() {
        userDetails();
        validateFields();
        yesNoRadio.setItems("Yes", "No");
        yesNoRadio.setValue("No");
        yesNoRadio.addClassName("v-radio-group-yesno");
        yesNoRadio.setLabel("Are you able to join the Talk and Reception?");
        coupleText.setText(coupleText.getText().toUpperCase());
        coupleText.addClassName("couple-text-padding");
        submitButton.addClassName("submit-button");
        nameCityHorizontalLayout.add(firstNameField, cityField);

        pageContent.add(coupleText, rsvpDinnerSelectionText, nameCityHorizontalLayout,
                yesNoRadio, selectFoodView, submitButton);
        log.info("Components initialized");
        pageContent.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        pageContent.setAlignItems(FlexComponent.Alignment.CENTER);
        pageContent.addClassName("scrollable-layout");
        submitButton.addClickListener(event -> handleSubmit());
    }

    public void handleSubmit() {
        // save the RSVP details to the database
        if (binder.validate().isOk()) {
        dinnerRepository.save(Dinner.builder()
                .firstName(firstNameField.getValue())
                .city(cityField.getValue())
                .rsvp(yesNoRadio.getValue().equals("Yes"))
                .choice(selectFoodView.getSelectedFoodDetails())
                .notes(selectFoodView.getSpecialRequests())
                .localDateTime(LocalDateTime.now())
                .build());
        // log the submission of the RSVP
        log.info("RSVP submitted" + firstNameField.getValue() + " " + cityField.getValue() + " " +
                yesNoRadio.getValue() + " " + selectFoodView.getSelectedFoodDetails() + " "
                + selectFoodView.getSpecialRequests() + " " + LocalDateTime.now());
        remove(pageContent);
        add(thankYouView);
            thankYouView.setAlignItems(FlexComponent.Alignment.CENTER);
        log.info("Thank you message displayed");
        } else {
            log.info(String.format("RSVP not submitted due to validation errors, FirstName:%s City:%s ", firstNameField.getValue(), cityField.getValue()));
        }
    }

    void userDetails() {
        log.info(String.format("New Visitor %s", LocalDateTime.now()));
        VaadinRequest vaadinRequest = VaadinService.getCurrentRequest();
        log.info("Request: " + vaadinRequest.getRemoteAddr() + " " + vaadinRequest.getHeader("User-Agent") + " " + vaadinRequest.getLocale());
    }

    void validateFields() {
        binder.forField(firstNameField)
                .withValidator(name -> name.matches("^[A-Z][a-zA-Z]{1,}$"), "First name must start with a capital letter and consist only of alphabets")
                .bind(Dinner::getFirstName, Dinner::setFirstName);

        binder.forField(cityField)
                .withValidator(city -> city.matches("^[A-Z][a-zA-Z]{1,}$"), "First name must start with a capital letter and consist only of alphabets")
                .bind(Dinner::getCity, Dinner::setCity);
    }
}

