package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.DialogManager;
import sample.ControllerMain;

public class ControllerFind extends ControllerMain {

    //окно "Найти"
    @FXML public TextField searchTextField;
    @FXML public Label findTextLabel;
    @FXML public Button okTextFindButton;
    @FXML public Button cancelTextFindButton;
    private String text;

    @Override
    public void initialize(){
        System.out.println("psvm");
    }

    public void textFindOkButtonAction(ActionEvent actionEvent) {
        System.out.println("Enter button...");
        text = (searchTextField.getText());
        if (text.equals("")){
            DialogManager.showInfoDialog("Ошибка!", "Введите текст для поиска!");
        }
        else textAreaOne.setText(text);
    }

    public void textFindCancelButtonAction(ActionEvent actionEvent) {
        System.out.println("Esc button...");
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}