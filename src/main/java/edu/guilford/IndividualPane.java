package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class IndividualPane extends GridPane {
    // Could have GridPane, TilePane, StackPane, Pane, BorderPane, and others
    // These organize the components we want to display in different ways

    // //Three String attributes
    // private String name;
    // private String email;
    // private String phone;

    // Indiviual attribute
    private Individual individual;

    // Three textfield attributes
    private javafx.scene.control.TextField nameField;
    private javafx.scene.control.TextField emailField;
    private javafx.scene.control.TextField phoneField;
    private Button submitButton;
    // Three label attributes for the name, email, and phone;
    private Label nameLabel;
    private Label emailLabel;
    private Label phoneLabel;

    // Step 1. Declare an ImageView attribute
    private ImageView imageView;

    //Declare a slider attribute to manipulate the background color
    private Slider colorSlider; 

    // Constructor with no arguments
    public IndividualPane(Individual individual) {
        // Set the individual attribute to the individual argument
        this.individual = individual;

        // Instantiate the submit button
        submitButton = new Button("Submit");

        // Instantiate the slider
        colorSlider = new Slider(0, 1, 0.5);

        // Step 2. Instantiate the ImageView attribute with the image in the resources
        // folder. We have to tell javafx
        // where our resource is and then convert it into an URL which needs to be
        // turned into a string.
        File avatar = new File(this.getClass().getResource("capybara.png").getPath());
        System.out.println(avatar.toURI().toString());
        // URI = Uniform Resource Identifier and it is similar to a URL.
        imageView = new ImageView("file:/target/classes/edu/guilford/capybara.png");

        // Instantiate a textfield
        nameField = new javafx.scene.control.TextField();
        emailField = new javafx.scene.control.TextField();
        phoneField = new javafx.scene.control.TextField();

        // Instantiate a label
        nameLabel = new Label("Name: " + individual.getName());
        emailLabel = new Label("Email: " + individual.getEmail());
        phoneLabel = new Label("Phone: " + individual.getPhone());

        // Add a label to the pane
        this.add((nameLabel), 0, 0);
        this.add((emailLabel), 0, 1);
        this.add((phoneLabel), 0, 2);

        // Understand why there is a problem with this.
        // // Add a label to the pane
        // this.add(new Label("Name: " + individual.getName()), 0, 0);
        // // Add a label to the pane
        // this.add(new Label("Email: " + individual.getEmail()), 0, 1);
        // // Add a label to the pane
        // this.add(new Label("Phone: " + individual.getPhone()), 0, 2);

        // Add field to the pane next to the name label
        this.add(nameField, 1, 0);
        this.add(emailField, 1, 1);
        this.add(phoneField, 1, 2);

        // Add submit button to the pane
        this.add(submitButton, 0, 3);

        // Add slider to the bottom of the pane
        this.add(colorSlider, 0, 4, 2, 1);

        // Step 3. Add the ImageView to the pane to the right of the textfields
        this.add(imageView, 2, 0, 1, 4);
        // Change the image to be of different size
        imageView.setFitHeight(100);
        // And preserve the aspect ratio (ratio of width to height)
        imageView.setPreserveRatio(true);
        // rotate it by 45 degrees
        imageView.setRotate(45);

        // Give a pane a border
        this.setStyle("-fx-border-color: black;");
        // Give a pane a background color
        this.setStyle("-fx-background-color: lightblue;");

        // Add a listener for the button that changes labels; CoPilot built us an event
        // handler
        // Set the name label to the name in the textfield
        submitButton.setOnAction(e -> {
            // Set the labels to the name in the textfield
            nameLabel.setText("Name: " + nameField.getText());
            emailLabel.setText("Email: " + emailField.getText());
            phoneLabel.setText("Phone: " + phoneField.getText());
            // update the individual's attribute with the new data from the textfield
            individual.setName(nameField.getText());
            individual.setEmail(emailField.getText());
            individual.setPhone(phoneField.getText());
        });

        // Steps 4 & 5: Write an event listener and connect it to the component
        // that will trigger the event. (such as rotate the image by 180 degrees when
        // the mouse is
        // is clicked on the image).
        // Rotate the image by 100 degrees when mouse is clicked
        imageView.setOnMouseClicked(e -> {
            imageView.setRotate(imageView.getRotate() + 100);
        });

        //Event listener that turns the background color to red when the slider is moved 
        // to the left and blue when the slider is moved to the right
        colorSlider.valueProperty().addListener(e -> {
            //Get the value of the slider
            double value = colorSlider.getValue();
            //Set the background color to red if the slider is moved to the left
            if (value < 0.5) {
                this.setStyle("-fx-background-color: red;");
            }
            //Set the background color to blue if the slider is moved to the right
            else {
                this.setStyle("-fx-background-color: blue;");
            }
        });
    }
}
