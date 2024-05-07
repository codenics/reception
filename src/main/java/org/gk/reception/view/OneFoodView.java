package org.gk.reception.view;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

public class OneFoodView extends VerticalLayout {
    Image foodImage = new Image("images/eggplant.jpeg", "Egg Plant Image");
    H3 mainNameText = new H3("PARMIGIANA DI MELANZANE");
    String secondaryNameText = "<div>EGGPLANT | SAN MARZANO TOMATOES | PARMIGIANO REGGIANO | FIOR DI LATTE </div>";

    Html secondaryNameTextHtml = new Html(secondaryNameText);

    String descriptionTextString = "<div style=\"width: 500px; word-wrap: break-word;\"> The eggplant, a " +
            "versatile vegetable, is the star of this classic Italian dish. Layered with tangy San Marzano tomatoes, " +
            "nutty Parmigiano Reggiano, and creamy fior di latte, the eggplant casserole is a symphony of " +
            "flavors and textures. Whether served as a main course, this dish is sure to delight the " +
            "palate and even make the most ardent carnivore a convert 😉. </div>";

    Html descriptionText = new Html(descriptionTextString);

    @Getter
    private String selectedFood = "";

    Button orderButton = new Button("Select");

    public OneFoodView() {
        orderButton.addClickListener(e -> handleOrderButtonClick());
        foodImage.setClassName("responsive-image", true);
        mainNameText.getStyle().set("padding", "5px"); // dark gray
        getStyle().set("background-color", "#f8f9fa"); // light gray
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(foodImage, mainNameText, secondaryNameTextHtml, descriptionText, orderButton);
    }

    void handleOrderButtonClick() {
        selectedFood = mainNameText.getText();
        orderButton.setText("Selected");
    }
    public void deselectFood() {
        selectedFood = "";
        orderButton.setText("Select");
    }


}
