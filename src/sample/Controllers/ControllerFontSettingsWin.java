package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.ControllerMain;
import sample.Main;


public class ControllerFontSettingsWin {

    public TextField fontTextField;
    public ListView<String> fontsListView;
    public CheckBox crossedParamRadioButton;
    public CheckBox underlinedParamRadioButton;
    public ColorPicker colorColorPicker;
    public TextField textParamsTextField;
    public ListView<String> fontParamsListView;
    public TextField fontSizeTextField;
    public ListView<Integer> fontSizeListView;
    public Button okButton;
    public Button cancelButton;
    public Label sampleLabel;

    private boolean bUnderlineText;
    private String currentFontFamily;
    private FontPosture currentFontPosture;
    private FontWeight currentFontWeight;
    private int currentFontSize;

    //листы
    public ObservableList<String> fontTypesList = FXCollections.observableList(Font.getFamilies()); //ObservableList - обертка для List
    public ObservableList<Integer> fontSizesList = FXCollections.observableArrayList(
            2, 4, 6, 8, 10, 12, 14, 16, 18, 32, 48, 72
    );
    public ObservableList<String> fontParams = FXCollections.observableArrayList(
            "обычный", "наклонный", "полужирный", "полужирный наклонный"
    );

    //контроллер
    private ControllerMain controller;

    public void setParent (ControllerMain controller){
        this.controller = controller;
    }

    public void initialize(){
        //шрифт
        fontsListView.setItems(fontTypesList);
        fontTextField.setText(Main.currentFontFamily);
        currentFontFamily = fontTextField.getText();
        fontsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //параметры текста
        fontParamsListView.setItems(fontParams);
        textParamsTextField.setText(fontParams.get(0));
        fontParamsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        currentFontWeight = FontWeight.NORMAL;
        currentFontPosture = FontPosture.REGULAR;

        //размер шрифта
        fontSizeListView.setItems(fontSizesList);
        fontSizeTextField.setText(Integer.toString(Main.currentFontSize));
        currentFontSize = Integer.parseInt(fontSizeTextField.getText());
        fontSizeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //образец текста
        sampleLabel.setFont(Font.font(currentFontFamily, currentFontWeight, currentFontPosture, currentFontSize));

        //подчеркивание
        bUnderlineText = underlinedParamRadioButton.isSelected();

        //листенеры
        underlinedParamRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                bUnderlineText = newValue;
                sampleLabel.setUnderline(bUnderlineText);
            }
        });

        fontsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                fontTextField.setText(newValue);
                currentFontFamily = newValue;
                sampleLabel.setFont(Font.font(currentFontFamily, currentFontWeight, currentFontPosture, currentFontSize));
            }
        });
        fontParamsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textParamsTextField.setText(newValue);

                switch (newValue) {
                    case ("обычный"):
                        currentFontWeight = FontWeight.NORMAL;
                        currentFontPosture = FontPosture.REGULAR;
                        break;
                    case ("наклонный"):
                        currentFontWeight = FontWeight.NORMAL;
                        currentFontPosture = FontPosture.ITALIC;
                        break;
                    case ("полужирный"):
                        currentFontWeight = FontWeight.BOLD;
                        currentFontPosture = FontPosture.REGULAR;
                        break;
                    case ("полужирный наклонный"):
                        currentFontWeight = FontWeight.BOLD;
                        currentFontPosture = FontPosture.ITALIC;
                        break;
                }

                sampleLabel.setFont(Font.font(currentFontFamily, currentFontWeight, currentFontPosture, currentFontSize));
            }
        });
        fontSizeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                fontSizeTextField.setText(newValue.toString());
                currentFontSize = newValue;
                sampleLabel.setFont(Font.font(currentFontFamily, currentFontWeight, currentFontPosture, currentFontSize));
            }
        });

    }

    public void setParams(){
        Main.currentFontFamily = currentFontFamily;
        Main.currentFontWeight = currentFontWeight;
        Main.currentFontPosture = currentFontPosture;
        Main.currentFontSize = currentFontSize;
        controller.setFontParams();
    }

    public void okButtonAction(ActionEvent actionEvent) {
        //методы передачи значений в контроллер ControllerMain
        setParams();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}