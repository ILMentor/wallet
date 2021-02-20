package Controllers;

import Database.DatabaseHandler;
import Database.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainFormController {

    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private Button openMenu_button;

    @FXML
    private TextField value_textField;

    @FXML
    private TextField date_textField;

    @FXML
    private TextField account_textField;

    @FXML
    private TextField type_textField;

    @FXML
    private TextField category_textField;

    @FXML
    private Button addNote_button;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private VBox menu_VBox;

    @FXML
    void initialize() {

        AnchorPane1.getChildren().removeAll(AnchorPane2);

        openMenu_button.setOnAction(actionEvent -> {
            if(!AnchorPane1.getChildren().removeAll(AnchorPane2))
                AnchorPane1.getChildren().add(AnchorPane2);
        });

        addNote_button.setOnAction(actionEvent -> {
            Note note = new Note(value_textField.getText(), date_textField.getText(), account_textField.getText(),
                    type_textField.getText(), category_textField.getText());
            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.insertNote(note);
        });
    }
}

