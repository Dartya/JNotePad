package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;
import javafx.scene.control.MultipleSelectionModel;

public class ControllerManualWin {
    public WebView WebView ;
    private TreeItem<String> rootTreeNode;
    @FXML TreeView<String> treeView;

    public void initialize(){
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
        rootTreeNode.setExpanded(true);
        // устанавливаем корневой узел для TreeView
        treeView = new TreeView<>(rootTreeNode);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

}