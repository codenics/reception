package org.gk.reception.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class SelectFoodView extends VerticalLayout {
    Button filetButton = new Button("Beef Filet");
    Button octopusButton = new Button("Octopus");
    Button eggPlantButton = new Button("Egg Plant");

    OneFoodView filetView = new OneFoodView();
    OneFoodView octopusView = new OneFoodView();
    OneFoodView eggPlantView = new OneFoodView();
    TextArea specialRequestsTextArea = new TextArea("Special Requests");

    VerticalLayout foodButtonsAndFoodSpecialNotesVLayout = new VerticalLayout();
    HorizontalLayout foodButtonsHlayout = new HorizontalLayout();
    HorizontalLayout foodViewsHlayout = new HorizontalLayout();

    public SelectFoodView() {
        initFoods();
        foodButtonsHlayout.add(filetButton, octopusButton, eggPlantButton);
        foodViewsHlayout.add(filetView);
        foodButtonsAndFoodSpecialNotesVLayout.add(foodButtonsHlayout, foodViewsHlayout, specialRequestsTextArea);
        eggPlantButton.addClickListener(event -> {
            foodViewsHlayout.removeAll();
            foodViewsHlayout.add(eggPlantView);
            add(specialRequestsTextArea);
        });
        filetButton.addClickListener(event -> {
            foodViewsHlayout.removeAll();
            foodViewsHlayout.add(filetView);
            add(specialRequestsTextArea);
        });
        octopusButton.addClickListener(event -> {
            foodViewsHlayout.removeAll();
            foodViewsHlayout.add(octopusView);
            add(specialRequestsTextArea);
        });
        add(foodButtonsAndFoodSpecialNotesVLayout);
        foodButtonsAndFoodSpecialNotesVLayout.setAlignItems(Alignment.CENTER);
        foodButtonsAndFoodSpecialNotesVLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        foodButtonsHlayout.setAlignItems(Alignment.CENTER);
        foodButtonsHlayout.setJustifyContentMode(JustifyContentMode.CENTER);
        setWidth("75%");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }


    public String getSelectedFoodDetails() {
        if (filetView.isVisible()) {
            filetView.handleOrderButtonClick();
            return filetView.getSelectedFood();
        } else if (octopusView.isVisible()) {
            octopusView.handleOrderButtonClick();
            return octopusView.getSelectedFood();
        } else if (eggPlantView.isVisible()) {
            return eggPlantView.getSelectedFood();
        }
        return null;
    }


    public void deselectOthers() {
        // Deselect all food views
        filetView.deselectFood();
        octopusView.deselectFood();
        eggPlantView.deselectFood();
    }

    // get specialRequestsTextArea value and return it as a string
    public String getSpecialRequests(){
        return specialRequestsTextArea.getValue();
    }

    void initFoods(){
        filetView.orderButton.addClickListener(event -> {
            deselectOthers();
            filetView.handleOrderButtonClick();
        });
        octopusView.orderButton.addClickListener(event -> {
            deselectOthers();
            octopusView.handleOrderButtonClick();
        });
        eggPlantView.orderButton.addClickListener(event -> {
            deselectOthers();
            eggPlantView.handleOrderButtonClick();
        });


        specialRequestsTextArea.setPlaceholder("eg. I am allergic to peanuts.");
        specialRequestsTextArea.setMaxLength(500);
        specialRequestsTextArea.setClassName("special-requests-text-area", true);

        filetView.mainNameText.setText("FILETTO DI MANZO");
        filetView.secondaryNameTextHtml.setHtmlContent("<div style=\"width: 350px; word-wrap: break-word; padding: 5px;\"> " +
                "BEEF FILET | MUSHROOMS | BLACK PEPPER SAUCE | MASHED POTATOES</div>");
        filetView.foodImage.setSrc("images/beef_fillet.jpg");
        filetView.descriptionText.setHtmlContent("<div style=\"width: 350px; word-wrap: break-word; padding: 5px; border-radius: 10px; background-color: #f8f9fa; font-family: Arial, sans-serif; line-height: 1.6; margin: 5px;\">" +
                "Filet mignon epitomizes culinary refinement. " +
                "This exquisite cut, sourced from the tenderloin, boasts unparalleled tenderness and marbling." +
                "When expertly prepared, its velvety texture and succulent flavor evoke gastronomic ecstasy. " +
                "Whether adorned with a luscious sauce or simply seasoned, the beef filet remains an epitome of indulgence and sophistication. </div>");

        octopusView.mainNameText.setText("POLPO ARROSTO CON CREMA DI CECI");
        octopusView.secondaryNameTextHtml.setHtmlContent(String.format("<div style=\"width: 350px; word-wrap: break-word; padding: 5px;\">%s</div>", "Gegrillter Oktopus | Chili | Petersilie | Oliven Öl | Kichererbsenpüree | Tomaten Confit".toUpperCase()));
        octopusView.foodImage.setSrc("images/octopus.jpg");
        octopusView.descriptionText.setHtmlContent("<div style=\"width: 350px; word-wrap: break-word; padding: 5px; " +
                "border-radius: 10px; background-color: #f8f9fa; font-family: Arial, sans-serif; line-height: 1.6; margin: 5px;\"> " +
                "Octopus' tender, succulent flesh, when grilled to perfection, offers a delightful contrast of textures. " +
                "The octopus' subtle brininess harmonizes with the piquant chili and aromatic parsley. " +
                "Finally the accompanied creamy chickpea puree and sweet tomato confit provide a luscious backdrop for this exquisite dish.</div>");
        eggPlantView.mainNameText.setText("MELANZANE ALLA PARMIGIANA");
        eggPlantView.secondaryNameTextHtml.setHtmlContent("<div style=\"width: 350px; word-wrap: break-word; padding: 5px;\">EGGPLANT | SAN MARZANO TOMATOES | PARMIGIANO REGGIANO | FIOR DI LATTE</div>");
        eggPlantView.foodImage.setSrc("images/eggplant.jpg");
        eggPlantView.descriptionText.setHtmlContent("<div style=\"width: 350px; word-wrap: break-word; padding: 5px; border-radius: 10px; background-color: #f8f9fa; font-family: Arial, line-height: 1.6; margin: 5px;\">" +
                "The eggplant, a versatile vegetable, is the star of this classic Italian dish. " +
                "Layered with tangy San Marzano tomatoes, nutty Parmigiano Reggiano, and creamy fior di latte; " +
                "the eggplant casserole is a symphony of flavors and textures. " +
                "Whether served as a main course, this dish is sure to delight the palate and even make the most ardent carnivore a convert 😉." +
                "</div>");
    }
}
