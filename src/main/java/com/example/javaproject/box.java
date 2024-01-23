package com.example.javaproject;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class box {
    public static void Box(){
        Rectangle view = new Rectangle(134,150,1080,435);
        DropShadow shadow = new DropShadow();
        view.setFill(Color.rgb(247,249,250));
        shadow.setOffsetY(1);
        shadow.setOffsetX(-1);
        shadow.setColor(Color.WHITE);
        view.setStrokeWidth(3);
        view.setStroke(Color.rgb(200,226,255));
        view.setEffect(new GaussianBlur(5));
        view.setEffect(shadow);
        view.setCache(true);
        view.setOpacity(0.31);
        view.setArcHeight(15);
        view.setArcWidth(15);
        view.setFill(Color.WHITE);
        Binarytree.root.getChildren().add(view);

    }
}
