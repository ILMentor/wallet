package Controllers;

import Database.DatabaseHandler;
import Database.Note;
import Database.TableProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private Label value_label;

    @FXML
    private Label date_label;

    @FXML
    private Label type_label;

    @FXML
    private Label category_label;

    @FXML
    private Label description_label;

    @FXML
    private Button addNote_button;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private VBox menu_VBox;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {

        doAtFirst();

        openMenu_button.setOnAction(actionEvent -> {
            if(!AnchorPane1.getChildren().removeAll(AnchorPane2))
                AnchorPane1.getChildren().add(AnchorPane2);
        });

        addNote_button.setOnAction(actionEvent -> {
            Note note = new Note(value_textField.getText(), date_textField.getText(), account_textField.getText(),
                    type_textField.getText(), category_textField.getText());
            databaseHandler.insertNote(note);
        });
    }

    void doAtFirst()  {

        AnchorPane1.getChildren().removeAll(AnchorPane2);

        try{
            String select = "SELECT * FROM " + TableProperty.TABLE_NAME;
            Statement statement = databaseHandler.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while(resultSet.next()){
                value_label.setText(resultSet.getString(TableProperty.VALUE));
                date_label.setText(resultSet.getString(TableProperty.DATE));
                category_label.setText(resultSet.getString(TableProperty.CATEGORY));
                type_label.setText(resultSet.getString(TableProperty.TYPE));
                description_label.setText(resultSet.getString(TableProperty.DESCRIPTION));
            }

        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

