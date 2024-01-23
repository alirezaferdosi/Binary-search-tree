package com.example.javaproject;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Title extends StackPane {
    public Text text = new Text();
    public HBox hBox =new HBox();
    public DropShadow shadow = new DropShadow();
    public Stop[] stops = new Stop[]{//DARKSLATEBLUE
            new Stop(1,Color.rgb(51,193,250)),
            new Stop(0,Color.rgb(230,36,116))
    };
    public LinearGradient linearGradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE,stops);
    public void title(){

        shadow.setColor(Color.rgb(230,147,251));
        shadow.setOffsetX(3.2);
        shadow.setOffsetY(3.2);
        shadow.setHeight(-10);
        shadow.setWidth(-10);
        shadow.setRadius(10);
        shadow.setSpread(.15);

        text.setText("Binary Search");
        text.setFont(Font.font("Edwardian Script ITC",58));
        text.setFill(linearGradient);
        text.setId("title");
        //text.setFont(Font.font(getClass().getResource("/com/font/fint1.ttf").toExternalForm(),58));
        text.setEffect(shadow);

        hBox.setTranslateX(505);
        hBox.setTranslateY(52);

        hBox.getChildren().add(text);
        Binarytree.root_title.getChildren().add(hBox);
        Binarytree.root_title_text.getChildren().add(hBox);
    }
}
