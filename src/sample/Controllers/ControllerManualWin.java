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
    URL url;

    final String str1 = "Общие сведения о программе";
    final String str2 = "Поиск символов или слов";
    final String str3 = "Поиск и замена символов или слов";
    final String str4 = "Включение режима переноса слов";
    final String str5 = "Переход к конкретной строке";
    final String str6 = "Вырезание, копирование, вставка";
    final String str7 = "Печать документа";
    final String str8 = "Вставка в документ времени и даты";
    final String str9 = "Использование различных языков";
    final String str10 = "Русский";
    final String str11 = "Английский";

    public void initialize(){
        System.out.println("blabla");
        createTree();
        webEngine = WebView.getEngine();
        showPage("/sample/Manuals/spravka.html");
    }
    private void createTree(){
        System.out.println("createTree method...");
        // определяем корневой узел
        rootTreeNode = new TreeItem<>("Справка");

        // определяем набор вложенных узлов
        TreeItem<String> common = new TreeItem<>(str1);
        common.getChildren().add(new TreeItem<>(str2));
        common.getChildren().add(new TreeItem<>(str3));
        common.getChildren().add(new TreeItem<>(str4));
        common.getChildren().add(new TreeItem<>(str5));
        common.getChildren().add(new TreeItem<>(str6));
        common.getChildren().add(new TreeItem<>(str7));
        common.getChildren().add(new TreeItem<>(str8));

        TreeItem<String> languages = new TreeItem<>(str9);
        languages.getChildren().add(new TreeItem<>(str10));
        languages.getChildren().add(new TreeItem<>(str11));

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
                    case str1:
                        showPage("/sample/Manuals/str1.html");
                        break;
                    case str2:
                        showPage("/sample/Manuals/str2.html");
                        break;
                    case str3:
                        showPage("/sample/Manuals/str3.html");
                        break;
                    case str4:
                        showPage("/sample/Manuals/str4.html");
                        break;
                    case str5:
                        showPage("/sample/Manuals/str5.html");
                        break;
                    case str6:
                        showPage("/sample/Manuals/str6.html");
                        break;
                    case str7:
                        showPage("/sample/Manuals/str7.html");
                        break;
                    case str8:
                        showPage("/sample/Manuals/str8.html");
                        break;
                    case str9:
                        showPage("/sample/Manuals/str9.html");
                        break;
                    case str10:
                        showPage("/sample/Manuals/rysskij.html");
                        break;
                    case str11:
                        showPage("/sample/Manuals/my_file.html");
                        break;
                    default:
                        showPage("/sample/Manuals/spravka.html");
                }
            }
        });
    }

    private void showPage(String path){
        url = this.getClass().getResource(path);
        webEngine.load(url.toString());
    }
}