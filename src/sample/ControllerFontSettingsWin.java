package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ControllerFontSettingsWin {

    public TextField fontTextField;
    public ListView fontsListView;
    public CheckBox crossedParamRadioButton;
    public CheckBox underlinedParamRadioButton;
    public ColorPicker colorColorPicker;
    public TextField textParamsTextField;
    public ListView fontParamsListView;
    public TextField fontSizeTextField;
    public ListView fontSizeListView;
    public ComboBox symbolsComboBox;
    public Button okButton;
    public Button cancelButton;

    public void okButtonAction(ActionEvent actionEvent) {

    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
