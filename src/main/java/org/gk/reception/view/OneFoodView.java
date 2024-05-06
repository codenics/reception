package org.gk.reception.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

public class OneFoodView extends VerticalLayout {
    Image foodImage = new Image("images/chef.jpeg", "Egg Plant Image");
    H3 mainNameText = new H3("PARMIGIANA DI MELANZANE");
    H4 secondaryNameText = new H4("EGGPLANT | SAN MARZANO TOMATOES | PARMIGIANO REGGIANO | FIOR DI LATTE");
    H5 descriptionText = new H5("""
            The eggplant, or aubergine, is a versatile vegetable that lends itself to a myriad of culinary applications.
            Whether roasted, grilled, or fried, the eggplant's rich, meaty texture and mild flavor make it a popular ingredient in many cuisines.\s
             In this classic Italian dish, the eggplant is layered with tangy San Marzano tomatoes, creamy Parmigiano Reggiano, and luscious fior di latte. \n
             The result is a sumptuous, savory dish that is sure to delight the senses.""");
    @Getter
    private String selectedFood = "";

    Button orderButton = new Button("Select");

    public OneFoodView() {
        orderButton.addClickListener(e -> handleOrderButtonClick());
        foodImage.setClassName("responsive-image", true);
        getStyle().set("background-color", "#f8f9fa"); // light gray
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(foodImage, mainNameText, secondaryNameText, descriptionText, orderButton);
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
