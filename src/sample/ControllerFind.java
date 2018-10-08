package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
