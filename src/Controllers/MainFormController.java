package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Database.DatabaseHandler;
import Database.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void initialize() {

        addNote_button.setOnAction(actionEvent -> {
            Note note = new Note(value_textField.getText(), date_textField.getText(), account_textField.getText(),
                    type_textField.getText(), category_textField.getText());
            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.insertNote(note);
        });
    }
}

