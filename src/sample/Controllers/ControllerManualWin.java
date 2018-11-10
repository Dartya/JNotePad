package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;

public class ControllerManualWin {
    public WebView WebView ;
    private String selectedItem;
    private TreeItem<String> rootTreeNode;
    @FXML TreeView treeView;
    WebEngine webEngine;

    public void initialize(){
        System.out.println("blabla");
        createTree();
        webEngine = WebView.getEngine();
        webEngine.load("http://ru.investing.com");
    }
    private void createTree(){
        System.out.println("createTree method...");
        // определяем корневой узел
        rootTreeNode = new TreeItem<>("Справка");

        // определяем набор вложенных узлов
        TreeItem<String> common = new TreeItem<>("Общие сведения о программе");
        common.getChildren().add(new TreeItem<>("Поиск символов или слов"));
        common.getChildren().add(new TreeItem<>("Поиск и замена символов или слов"));
        common.getChildren().add(new TreeItem<>("Включение режима переноса слов"));
        common.getChildren().add(new TreeItem<>("Переход к конкретной строке"));
        common.getChildren().add(new TreeItem<>("Вырезание, копирование, вставка"));
        common.getChildren().add(new TreeItem<>("Изменение способа отображения"));
        common.getChildren().add(new TreeItem<>("Печать документа"));
        common.getChildren().add(new TreeItem<>("Вставка в документ времени и даты"));
        common.getChildren().add(new TreeItem<>("Ведение журнала использования данных"));

        TreeItem<String> languages = new TreeItem<>("Использование различных языков");
        languages.getChildren().add(new TreeItem<>("Русский"));
        languages.getChildren().add(new TreeItem<>("Английский"));

        // добавляем узлы в корневой узел
        rootTreeNode.getChildren().add(common);
        rootTreeNode.getChildren().add(languages);
        rootTreeNode.setExpanded(false);
        // устанавливаем корневой узел для TreeView
        treeView.setRoot(rootTreeNode);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                selectedItem = newValue.getValue();

                switch (selectedItem) {
                    case "Русский":
                        System.out.println("русский");
                        URL url = this.getClass().getResource("/sample/JavaFX _ TreeView.html");
                        webEngine.load(url.toString());

                        break;
                        default:
                            System.out.println("дефолт");
                            webEngine.load("http://google.com");
                }
            }
        });
    }
}