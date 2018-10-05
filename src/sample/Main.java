package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    public Button leftButton = new Button("", new ImageView("sample/image/left.png"));
    public Button centerButton;
    public Button rightButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JNotePad");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}