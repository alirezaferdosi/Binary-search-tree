package com.example.javaproject;


import javafx.geometry.Pos;
import javafx.scene.effect.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class header extends StackPane {
        Rectangle header = new Rectangle(575,315,200,50);
        public DropShadow shadow_header = new DropShadow();

        public void title(int x1 , int y1 , int x2 , int y2){
            Rectangle header = new Rectangle(x1,y1,x2,y2);
            shadow_header.setOffsetX(1);
            shadow_header.setOffsetY(-1);
            shadow_header.setColor(Color.WHITE);
            setAlignment(Pos.CENTER);

            header.setStrokeWidth(3);
            header.setStroke(Color.rgb(255,250,250));
            header.setEffect(new GaussianBlur(5));
            header.setEffect(shadow_header);
            header.setCache(true);
            header.setOpacity(.75);
            header.setArcWidth(25);
            header.setArcHeight(25);
            header.setFill(Color.rgb(210,249,246));

            //Binarytree.root_title.getChildren().add(header);
        }
}
