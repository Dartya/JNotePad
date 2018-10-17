package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Observer;
import java.util.ResourceBundle;

public class Main extends Application {
    private static final String FXML_MAIN = "sample.fxml";

    private Stage primaryStage;             //сцена главного окна
    private ControllerMain mainController;  //контроллер сцены главного окна
    private FXMLLoader fxmlLoader;          //загрузчик файлов FXML
    private GridPane currentRoot;           //коренной Node (Parent)

    @Override
    public void start(Stage primaryStage) throws Exception{ //метод, выполняющийся при старте приложения (создает главное окно)
        this.primaryStage = primaryStage;
        createGUI();
    }

    private void createGUI() {
        currentRoot = loadFXML(); //возвращает сконфигурированный Node (Parent)
        Scene scene = new Scene(currentRoot, 650, 500);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(610);
        primaryStage.getIcons().add(new Image("image/file.png"));
        primaryStage.show();

        /*
        Parent root = FXMLLoader.load(getClass().getResource(FXML_MAIN));
        primaryStage.setTitle("JNotePad");
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(610);
        primaryStage.getIcons().add(new Image("image/file.png"));
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
        */
    }

    private GridPane loadFXML() {   //возвращает сконфигурированный Node (Parent)
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(FXML_MAIN));
        GridPane node = null;

        try {
            node = (GridPane) fxmlLoader.load();
            mainController = fxmlLoader.getController();
            primaryStage.setTitle("JNotePad");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

