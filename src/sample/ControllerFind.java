package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.DialogManager;

public class ControllerFind {

    //окно "Найти"
    public TextField searchTextField;
    public Label findTextLabel;
    public Button okTextFindButton;
    public Button cancelTextFindButton;
    private String text;

    public void textFindOkButtonAction(ActionEvent actionEvent) {
        System.out.println("Enter button...");
        text = (searchTextField.getText());
        if (text.equals("")){
            DialogManager.showInfoDialog("Ошибка!", "Введите текст для поиска!");
        }
    }

    public void textFindCancelButtonAction(ActionEvent actionEvent) {
        System.out.println("Esc button...");
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
