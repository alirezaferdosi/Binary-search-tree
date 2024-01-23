//alireza ferdosi
package com.example.javaproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.javaproject.Functions.*;

public class Binarytree extends Application {
    public static Path path = Paths.get("src");
    public static Group root = new Group();
    public static Group root_title = new Group();
    public static Group root_title_text = new Group();
    public static Group tree_root = new Group();
    public static TextArea textArea = new TextArea("");

    @Override
    public void start(Stage stage) throws IOException {
        textArea.setFont(Font.font("",18));
        textArea.setEditable(false);
        textArea.setDisable(false);
        textArea.setPromptText("Operation result ...");
        header Header = new header();

        Title title = new Title();

        Image img = new Image(path.toAbsolutePath() + "\\background.png");
        ImageView imgview = new ImageView(img);

        imgview.setFitHeight(Screen.getPrimary().getBounds().getHeight());
        imgview.setFitWidth(Screen.getPrimary().getBounds().getWidth());

        textArea.setTranslateX(425);
        textArea.setTranslateY(370);

        textArea.setMaxSize(500,185);

        root.getChildren().add(imgview);
        root.getChildren().add(root_title);
        root.getChildren().add(root_title_text);

        box.Box();
        Header.title(476,56,400,77);
        title.title();
        Components.components();

        root.getChildren().add(textArea);

        Scene scene = new Scene(root, 1350, 680);
        stage.getIcons().add(new Image(path.toAbsolutePath() + "\\logo1.png"));
        stage.setTitle("Binary Tree");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}