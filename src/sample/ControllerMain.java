package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMain {

    //главное окно
    @FXML
    public Button leftButton;
    @FXML
    public Button centerButton;
    @FXML
    public Button rightButton;
    @FXML
    public TextArea textAreaOne;
    @FXML
    public MenuItem findMenuItem;
    public ObservableList<String> fontTypesList = FXCollections.observableList(Font.getFontNames()); //ObservableList - обертка для List
    public ObservableList<Integer> fontSizesList = FXCollections.observableArrayList(
            2, 4, 6, 8, 10, 12, 14, 16, 18, 32, 48, 72
    );
    public ObservableList<String> fontColorsList = FXCollections.observableArrayList(
            "Черный", "Красный", "Синий", "Желтый", "Зеленый"
    );
    public ObservableList<String> stylesList = FXCollections.observableArrayList(
            "Стиль 1", "Стиль 2", "Стиль 3", "Стиль 4", "Стиль 5"
    );
    @FXML
    public ComboBox fontChoice;
    @FXML
    public ComboBox fontSizeComboBox;
    @FXML
    public ComboBox fontColorComboBox;
    @FXML
    public ComboBox styleComboBox;

    public String result;

    public void initialize(){
        fontChoice.setItems(fontTypesList);
        fontChoice.setValue("Times New Roman");
        fontSizeComboBox.setItems(fontSizesList);
        fontSizeComboBox.setValue(12);
        fontSizeComboBox.setEditable(true);
        fontColorComboBox.setItems(fontColorsList);
        fontColorComboBox.setValue("Черный");
        styleComboBox.setItems(stylesList);
        styleComboBox.setValue("Стиль 1");
        styleComboBox.setEditable(true);
    }
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
        result = (fontTypesList.get(0)+"\n"+fontTypesList.get(1)+"\n"+fontTypesList.get(2)+"\n"+fontTypesList.get(3)+"\n"+fontTypesList.get(4)+"\n"+fontTypesList.get(5)+"\n"+fontTypesList.get(6)+"\n"+fontTypesList.get(7)+" ");
        textAreaOne.setText(result);
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
        Platform.exit();
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
        try {
            Stage aboutstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("about_win.fxml"));
            aboutstage.setTitle("О программе");
            aboutstage.setMinHeight(200);
            aboutstage.setMinWidth(150);
            aboutstage.setResizable(false);
            aboutstage.setScene(new Scene(root));
            aboutstage.getIcons().add(new Image("image/file.png"));
            aboutstage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());    //указывается родительское окно
            //правда, данный метод инициализации родительского окна не работает с элеменами основного меню, поэтому
            //stage.show();         //не используется в связке с stage.initModality(Modality.WINDOW_MODAL);
            aboutstage.showAndWait();    //зато используется этот метод в связке с stage.initModality(Modality.APPLICATION_MODAL);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void replaceAction(ActionEvent actionEvent) {

    }

    public void highliteAction(ActionEvent actionEvent) {
        textAreaOne.selectAll();
    }

    public void insertDataAction(ActionEvent actionEvent) {

    }

    public void findAction(ActionEvent actionEvent) {
        try {
            Stage stageFind = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("find_win.fxml"));
            stageFind.setTitle("Найти");
            stageFind.setMinHeight(200);
            stageFind.setMinWidth(150);
            stageFind.setResizable(false);
            stageFind.setScene(new Scene(root));
            stageFind.getIcons().add(new Image("image/search.png"));
            stageFind.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());    //указывается родительское окно
            //правда, данный метод инициализации родительского окна не работает с элеменами основного меню, поэтому
            //stage.show();         //не используется в связке с stage.initModality(Modality.WINDOW_MODAL);
            stageFind.showAndWait();    //зато используется этот метод в связке с stage.initModality(Modality.APPLICATION_MODAL);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
