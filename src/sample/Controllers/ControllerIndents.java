package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;

public class ControllerIndents {
    public TextField leftIndent;
    public TextField rightIndent;
    public TextField redRowIndent;

    public Button leftIndentDownButton;
    public Button leftIndentUpButton;

    public Button rightIndentDownButton;
    public Button rightIndentUpButton;

    public Button redRowIndentUpButton;
    public Button redRowIndentDownButton;

    int leftIndentInt;
    int rightIndentInt;
    int redRowIndentInt;

    //отступ слева
    public void initialize(){
        leftIndent.setText(Integer.toString(Main.leftIndent));
        rightIndent.setText(Integer.toString(Main.rightIndent));
        redRowIndent.setText(Integer.toString(Main.redRowIndent));

        leftIndentInt = Main.leftIndent;
        rightIndentInt = Main.rightIndent;
        redRowIndentInt = Main.redRowIndent;
    }

    public void leftIndentUpAction(ActionEvent actionEvent) {
        leftIndentInt = Integer.parseInt(leftIndent.getText());
        leftIndentInt++;
        leftIndent.setText(Integer.toString(leftIndentInt));
    }

    public void leftIndentDownAction(ActionEvent actionEvent) {
        leftIndentInt = Integer.parseInt(leftIndent.getText());
        leftIndentInt--;
        leftIndent.setText(Integer.toString(leftIndentInt));
    }

    public void redRowIndentUpButton(ActionEvent actionEvent) {
        redRowIndentInt = Integer.parseInt(redRowIndent.getText());
        redRowIndentInt++;
        redRowIndent.setText(Integer.toString(redRowIndentInt));
    }

    public void redRowIndentDownAction(ActionEvent actionEvent) {
        redRowIndentInt = Integer.parseInt(redRowIndent.getText());
        redRowIndentInt--;
        redRowIndent.setText(Integer.toString(redRowIndentInt));
    }

    public void rightIndentUpAction(ActionEvent actionEvent) {
        rightIndentInt = Integer.parseInt(rightIndent.getText());
        rightIndentInt++;
        rightIndent.setText(Integer.toString(rightIndentInt));
    }

    public void rightIndentDownAction(ActionEvent actionEvent) {
        rightIndentInt = Integer.parseInt(rightIndent.getText());
        rightIndentInt--;
        rightIndent.setText(Integer.toString(rightIndentInt));
    }

    public void okAction(ActionEvent actionEvent) {
        Main.leftIndent = leftIndentInt;
        Main.rightIndent = rightIndentInt;
        Main.redRowIndent = redRowIndentInt;

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        System.out.println("Esc button...");
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}