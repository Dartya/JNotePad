package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Classes.WindowConstructor;
import sample.Controllers.ControllerFind;
import sample.Controllers.ControllerFontSettingsWin;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerMain {

    //ссылки на контроллеры
    private ControllerFind children;  // Ссылка на контроллер окна поиска текста
    public ControllerFontSettingsWin childFontWin;
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
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;


    public ObservableList<String> fontTypesList = FXCollections.observableList(Font.getFamilies()); //ObservableList - обертка для List
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
    boolean wraptext = false;

    public String currentFontFamily;
    public FontPosture currentFontPosture;
    public FontWeight currentFontWeight;
    public int currentFontSize;

    Tooltip btn1 = new Tooltip("Создать");
    Tooltip btn2 = new Tooltip("Открыть");
    Tooltip btn3 = new Tooltip("Сохранить");
    Tooltip btn4 = new Tooltip("Сохранить как...");
    Tooltip btn5 = new Tooltip("Выход");
    Tooltip btn6 = new Tooltip("Выравнивание по левому краю");
    Tooltip btn7 = new Tooltip("Выравнивание по центру");
    Tooltip btn8 = new Tooltip("Выравнивание по правому краю");

    public void setFontParams(){
        currentFontFamily = Main.currentFontFamily;
        currentFontPosture = Main.currentFontPosture;
        currentFontWeight = Main.currentFontWeight;
        currentFontSize = Main.currentFontSize;
        textAreaOne.setFont(Font.font(currentFontFamily, currentFontWeight, currentFontPosture, currentFontSize));
    }

    public void initialize(){
        button1.setTooltip(btn1);
        button2.setTooltip(btn2);
        button3.setTooltip(btn3);
        button4.setTooltip(btn4);
        button5.setTooltip(btn5);
        leftButton.setTooltip(btn6);
        centerButton.setTooltip(btn7);
        rightButton.setTooltip(btn8);
        fontChoice.setItems(fontTypesList);
        fontChoice.setValue(Main.currentFontFamily);
        fontSizeComboBox.setItems(fontSizesList);
        fontSizeComboBox.setValue(Main.currentFontSize);
        fontSizeComboBox.setEditable(true);
        fontColorComboBox.setItems(fontColorsList);
        fontColorComboBox.setValue("Черный");
        styleComboBox.setItems(stylesList);
        styleComboBox.setValue("Стиль 1");
        styleComboBox.setEditable(true);
        this.setFontParams();
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

    }

    public void openAction(ActionEvent actionEvent) {
        /*
        System.out.println("Creating a new file...");
        FileChooser fileChooser = new FileChooser();
        // Set title for FileChooser
        fileChooser.setTitle("Открытие файла...");
        // Set Initial Directory
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(//
                new FileChooser.ExtensionFilter("Все файлы", "*.*"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        */
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            textAreaOne.setText(readFile(file));
        }
    }
    //метод чтения файла
    private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stringBuffer.toString();
    }

    public void saveAction(ActionEvent actionEvent) {
        System.out.println("Saving the file...");
    }

    public void saveAsAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            SaveFile(textAreaOne.getText(), file);
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void exitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void fontChooseAction(ActionEvent actionEvent) {
        try{
            Stage stageFont = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/FontSettingsWin.fxml"));
            Parent root = loader.load();
            stageFont.setTitle("Шрифт");
            stageFont.setResizable(false);
            stageFont.setScene(new Scene(root));
            stageFont.getIcons().add(new Image("image/file.png"));
            stageFont.initModality(Modality.APPLICATION_MODAL);
            childFontWin = loader.getController();
            childFontWin.setParent(this);
            System.out.println(childFontWin.getClass().getName());
            stageFont.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void indentsAction(ActionEvent actionEvent) {
        try{
            Stage stageIndents = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("FXML/indents.fxml"));
            stageIndents.setTitle("Отступы");
            stageIndents.setResizable(false);
            stageIndents.setScene(new Scene(root));
            stageIndents.getIcons().add(new Image("image/file.png"));
            stageIndents.initModality(Modality.NONE);
            stageIndents.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wordWrapAction(ActionEvent actionEvent) {
        wraptext = !(wraptext);
        textAreaOne.setWrapText(wraptext);

    }

    public void manualWinAction(ActionEvent actionEvent) {
        try {
            Stage aboutstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FXML/manualWin.fxml"));
            aboutstage.setTitle("Справка");
            aboutstage.setResizable(true);
            aboutstage.setMinWidth(660);
            aboutstage.setMinHeight(450);
            aboutstage.setScene(new Scene(root));
            aboutstage.getIcons().add(new Image("image/file.png"));
            aboutstage.initModality(Modality.NONE);
            aboutstage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aboutWinAction(ActionEvent actionEvent) {
        try {
            Stage aboutstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/about_win.fxml"));
            Parent root = loader.load();
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
        textAreaOne.undo();
    }

    public void cutAction(ActionEvent actionEvent) {
        textAreaOne.cut();
    }

    public void copyAction(ActionEvent actionEvent) {
        textAreaOne.copy();
    }

    public void pasteAction(ActionEvent actionEvent) {
        textAreaOne.paste();
    }

    public void deleteAction(ActionEvent actionEvent) {
        IndexRange range = textAreaOne.getSelection();
        textAreaOne.deleteText(range.getStart(), range.getEnd());
    }

    public void replaceAction(ActionEvent actionEvent) {
        try {
            Stage stageReplace = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("FXML/warpWords.fxml"));
            stageReplace.setTitle("Заменить");
            stageReplace.setMinHeight(200);
            stageReplace.setMinWidth(220);
            stageReplace.setResizable(false);
            stageReplace.setScene(new Scene(root));
            stageReplace.getIcons().add(new Image("image/search.png"));
            stageReplace.initModality(Modality.NONE);   //не модальнео окно
            //stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());    //указывается родительское окно
            //правда, данный метод инициализации родительского окна не работает с элеменами основного меню, поэтому
            //stage.show();         //не используется в связке с stage.initModality(Modality.WINDOW_MODAL);
            stageReplace.show();    //зато используется этот метод в связке с stage.initModality(Modality.APPLICATION_MODAL);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void highliteAction(ActionEvent actionEvent) {
        textAreaOne.selectAll();
    }

    public void insertDataAction(ActionEvent actionEvent) {
        textAreaOne.appendText(new Date().toString());
        textAreaOne.appendText("\n");
    }

    public void findAction(ActionEvent actionEvent) {
        try {
            Stage stageFind = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/find_win.fxml"));
            Parent root = loader.load();
            stageFind.setTitle("Найти");
            stageFind.setMinHeight(200);
            stageFind.setMinWidth(150);
            stageFind.setResizable(false);
            stageFind.setScene(new Scene(root));
            stageFind.getIcons().add(new Image("image/search.png"));
            stageFind.initModality(Modality.NONE);
            //stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());    //указывается родительское окно
            //правда, данный метод инициализации родительского окна не работает с элеменами основного меню, поэтому
            //stage.show();         //не используется в связке с stage.initModality(Modality.WINDOW_MODAL);
            stageFind.show();    //зато используется этот метод в связке с stage.initModality(Modality.APPLICATION_MODAL);
            children = loader.getController();
            children.setParent(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
