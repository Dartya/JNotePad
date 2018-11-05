package sample.Controllers;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class ControllerManualWin {
    public javafx.scene.web.WebView WebView ;
    public javafx.scene.control.TreeView<String> TreeView;

    public void initialize(){
        // определяем корневой узел
        TreeItem<String> rootTreeNode = new TreeItem<String>("Справка");

        // определяем набор вложенных узлов
        TreeItem<String> common = new TreeItem<String>("Общие сведения о программе");
        common.getChildren().add(new TreeItem<String>("Поиск символов или слов"));
        common.getChildren().add(new TreeItem<String>("Поиск и замена символов или слов"));
        common.getChildren().add(new TreeItem<String>("Включение режима переноса слов"));
        common.getChildren().add(new TreeItem<String>("Переход к конкретной строке"));
        common.getChildren().add(new TreeItem<String>("Вырезание, копирование, вставка"));
        common.getChildren().add(new TreeItem<String>("Измерение способа отображения"));
        common.getChildren().add(new TreeItem<String>("Печать документа"));
        common.getChildren().add(new TreeItem<String>("Вставка в документ времени и даты"));
        common.getChildren().add(new TreeItem<String>("Ведение журнала использования данных"));

        TreeItem<String> languages = new TreeItem<String>("Использование различных языков");
        languages.getChildren().add(new TreeItem<String>("Русский"));
        languages.getChildren().add(new TreeItem<String>("Английский"));

        // добавляем узлы в корневой узел
        rootTreeNode.getChildren().add(common);
        rootTreeNode.getChildren().add(languages);

        // устанавливаем корневой узел для TreeView
        TreeView = new TreeView<String>(rootTreeNode);
    }

}