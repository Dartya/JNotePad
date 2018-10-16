package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String FXML_MAIN = "sample.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(FXML_MAIN));
        primaryStage.setTitle("JNotePad");
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(610);
        primaryStage.getIcons().add(new Image("image/file.png"));
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}