package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerFind {

    //окно "Найти"
    public TextField searchTextField;
    public Label findTextLabel;
    public Button okTextFindButton;
    public Button cancelTextFindButton;

    public void textFindOkButtonAction(ActionEvent actionEvent) {
        searchTextField.getText();

    }

    public void textFindCancelButtonAction(ActionEvent actionEvent) {

    }
}
