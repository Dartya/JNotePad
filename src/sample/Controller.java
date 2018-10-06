package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public Button leftButton;
    public Button centerButton;
    public Button rightButton;
    public TextArea textAreaOne = new TextArea();
    public TextField searchTextField;
    public Label findTextLabel;
    public Button okTextFindButton ;
    public Button cancelTextFindButton ;
    public MenuItem findMenuItem;

    public void leftAlignmentAction(ActionEvent actionEvent) {
        System.out.println("Button1");
        textAreaOne.setText("Button 1");
    }

    public void centerAlignmentAction(ActionEvent actionEvent) {
        System.out.println("Button2");
        textAreaOne.setText("Button 2");
    }

    public void rightAlignmentAction(ActionEvent actionEvent) {
        System.out.println("Button3");

    }

    public void createFileAction(ActionEvent actionEvent) {
        System.out.println("Creating a new file...");
    }

    public void openAction(ActionEvent actionEvent) {
        System.out.println("Initial opening a file...");
    }

    public void saveAction(ActionEvent actionEvent) {
        System.out.println("Saving the file...");
    }

    public void saveAsAction(ActionEvent actionEvent) {
        System.out.println("Initial saving the file...");
    }

    public void exitAction(ActionEvent actionEvent) {

    }

    public void fontChooseAction(ActionEvent actionEvent) {

    }

    public void indentsAction(ActionEvent actionEvent) {

    }

    public void wordWrapAction(ActionEvent actionEvent) {

    }

    public void manualWinAction(ActionEvent actionEvent) {

    }

    public void aboutWinAction(ActionEvent actionEvent) {

    }

    public void printAction(ActionEvent actionEvent) {

    }

    public void cancelAction(ActionEvent actionEvent) {

    }

    public void cutAction(ActionEvent actionEvent) {

    }

    public void copyAction(ActionEvent actionEvent) {

    }

    public void pasteAction(ActionEvent actionEvent) {

    }

    public void deleteAction(ActionEvent actionEvent) {

    }

    public void findAction(ActionEvent actionEvent) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("find_win.fxml"));
            stage.setTitle("Найти");
            stage.setMinHeight(200);
            stage.setMinWidth(150);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());    //указывается родительское окно
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void replaceAction(ActionEvent actionEvent) {

    }

    public void highliteAction(ActionEvent actionEvent) {
        textAreaOne.selectAll();
    }

    public void insertDataAction(ActionEvent actionEvent) {

    }

    public void textFindOkButtonAction(ActionEvent actionEvent) {

    }

    public void textFindCancelButtonAction(ActionEvent actionEvent) {

    }
}
