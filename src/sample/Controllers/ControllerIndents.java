package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControllerIndents {
    public TextField leftIndent;
    public Button leftIndentDownButton;
    public Button leftIndentUpButton;

    //отступ слева
    public void initialize(){
        leftIndent.setText("0");
    }

    public void leftIndentUpAction(ActionEvent actionEvent) {

    }

    public void leftIndentDownAction(ActionEvent actionEvent) {

    }
}
