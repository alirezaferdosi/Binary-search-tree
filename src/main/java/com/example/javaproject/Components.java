package com.example.javaproject;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.example.javaproject.Binarytree.root;
import static com.example.javaproject.Functions.Root;
import static com.example.javaproject.Functions.*;
import static com.example.javaproject.Binarytree.textArea;
import static com.example.javaproject.Functions.delete;


public class Components extends StackPane {
    public static ComboBox<String> comboBox1 = new ComboBox<>();
    public static ComboBox<String> comboBox2 = new ComboBox<>();
    public static ComboBox<String> comboBox3 = new ComboBox<>();
    public static Text text_menu = new Text("Menu :");
    public static Text panel = new Text("Trees :");
    public static Text Add = new Text("Add :");
    public static Text Delete = new Text("Delete :");
    public static Text navigation_search = new Text("Traversal and Search :");
    public static Text Add_Delete = new Text("Add and Delete :");
    public static final Button menu_button = new Button("Action");
    public static final Button panel_button = new Button("Create");
    public static final Button Add_button = new Button("Add");
    public static final Button Delete_button = new Button("Delete");
    public static final Button navigation_Button = new Button("start");
    public static final Button Search_button = new Button("search");
    public static HBox hBox1 = new HBox(10);
    public static HBox hBox2 = new HBox(10);
    public static HBox hBox3 = new HBox(10);
    public static HBox hBox4 = new HBox(58);
    public static HBox hBox5 = new HBox(15);
    public static HBox hBox6 = new HBox(60);
    public static HBox hBox7 = new HBox(10);
    public static HBox hBox8 = new HBox(42);
    public static VBox vBox1 = new VBox(27);
    public static VBox vBox2 = new VBox(27);
    public static VBox vBox3 = new VBox(27);
    public static VBox vBox4 = new VBox(27);
    public static TextField textField = new TextField();
    public static TextField Add_field = new TextField();
    public static TextField Delete_field = new TextField();
    public static TextField Search_field = new TextField();
    public static TextField Tree1 = new TextField();
    public static TextField Tree2 = new TextField();
    public static int Tree_counter = 0;

    public Stop[] stops = new Stop[]{//DARKSLATEBLUE
            new Stop(1,Color.rgb(2,172,222)),
            new Stop(0,Color.rgb(255,36,116))
    };
    public LinearGradient linearGradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE,stops);


    public static void components(){

        panel_button.setCursor(Cursor.HAND);
        panel.setFont(Font.font("Harrington" ,16));

        textField.setPromptText("Root");
        textField.setCursor(Cursor.TEXT);

        hBox1.getChildren().addAll(comboBox1 ,panel_button);
        vBox1.getChildren().addAll(panel,hBox1 ,textField);

        //******************************************************************
        Add_Delete.setFont(Font.font("",16));

        Add_button.setCursor(Cursor.HAND);
        Add_field.setPromptText("value");
        Add.setFont(Font.font("",15));

        Delete.setFont(Font.font("",15));
        Delete_field.setPromptText("value");
        Delete_button.setCursor(Cursor.HAND);

        hBox2.getChildren().addAll(Add_field , Add_button);
        hBox3.getChildren().addAll(Delete_field ,Delete_button);
        vBox2.getChildren().addAll(Add_Delete ,hBox2 ,hBox3);

        //*****************************************************************
        navigation_search.setFont(Font.font("",16));

        comboBox3.getItems().addAll("Pre_order","In_order","Post_order","Level_order");

        Search_field.setPromptText("value");

        navigation_Button.setCursor(Cursor.HAND);

        Search_button.setCursor(Cursor.HAND);
        hBox4.getChildren().addAll(comboBox3 ,navigation_Button);
        hBox5.getChildren().addAll(Search_field ,Search_button);
        vBox3.getChildren().addAll(navigation_search ,hBox4 ,hBox5);

        //*****************************************************************
        comboBox2.getItems().addAll("Maximum" , "Minimum" , "height" , "Depth" , "Complete" , "Number of Leaves" , "Delete" , "Compare");
        menu_button.setCursor(Cursor.HAND);
        text_menu.setFont(Font.font("Harrington", 16));

        Tree1.setPromptText("tree1 for Comparision");
        Tree2.setPromptText("tree2 for Comparision");

        hBox6.getChildren().addAll(comboBox2 ,menu_button);
        hBox7.getChildren().addAll(Tree1 ,Tree2);
        vBox4.getChildren().addAll(text_menu ,hBox6 ,hBox7);

        //*****************************************************************
        hBox8.getChildren().addAll(vBox1 ,vBox2 ,vBox3 ,vBox4);
        hBox8.setTranslateX(170);
        root.getChildren().add(hBox8);

        panel_button.setOnMouseClicked(event -> {
            if (!textField.getText().equals("")) {
                textArea.setText("");
                Functions.add(Integer.parseInt(textField.getText()), Root, Tree_counter);
                Tree_counter++;
                comboBox1.getItems().add(String.valueOf(String.valueOf(Tree_counter)));
                comboBox1.setPromptText(String.valueOf(String.valueOf(Tree_counter)));
                textField.clear();

            }
            else {
                textArea.setText("Please enter the the root value !");
            }

        });

        Add_button.setOnMouseClicked(event ->{
            if(Add_field.getText().equals("")){
                textArea.setText("Please enter the number !");
            }
            else if(Tree_counter == 0){
                textArea.setText("Please select a tree !");
            }
            else {
                Functions.add(Double.parseDouble(Add_field.getText()), Root, Integer.parseInt(comboBox1.getPromptText()) - 1);
                Add_field.clear();
                textArea.clear();
            }
        });

        Search_button.setOnMouseClicked(event ->{
            if(Search_field.getText().equals("")) textArea.setText("Please enteer the number !");
            else {
                if (binary_search(Root[Integer.parseInt(comboBox1.getPromptText()) - 1] ,Double.parseDouble(Search_field.getText()))){
                    textArea.setText("The desired number exists.");
                }
                else textArea.setText("The desired number does not exists .");
            }
        });

        navigation_Button.setOnMouseClicked(event ->{
            navigation = "";
            if(Tree_counter == 0) textArea.setText("Please select a tree !");
            else {
                if(comboBox3.getValue() == null)    textArea.setText("please select the part !");
                else{
                    switch (comboBox3.getValue()) {

                        case "Pre_order" -> textArea.setText("Pre_order :\n" + Pre_order(Root[Integer.parseInt(comboBox1.getPromptText()) - 1]));

                        case "In_order" -> textArea.setText("In_order :\n" + in_order(Root[Integer.parseInt(comboBox1.getPromptText()) - 1]));

                        case "Post_order" -> textArea.setText("Post_order :\n" + post_order(Root[Integer.parseInt(comboBox1.getPromptText()) - 1]));

                        case "Level_order" -> textArea.setText("Level_order :\n" + Level_order(Integer.parseInt(comboBox1.getPromptText()) - 1));

                    }
                }

            }

        });

        menu_button.setOnMouseClicked(event ->{

            if(Tree_counter == 0) textArea.setText("Please select a tree");
            else {

                if (comboBox2.getValue() == null)   textArea.setText("Please select the part !");
                else{

                    if (comboBox1.getValue() == null)   textArea.setText("Please select the Tree !");
                    else {
                        switch (comboBox2.getValue()) {
                            case "Maximum" -> textArea.setText("the Maximum number : " + max_Element(Integer.valueOf(comboBox1.getPromptText()) - 1));

                            case "Minimum" -> textArea.setText("the Minimum number : " + min_Element(Integer.valueOf(comboBox1.getPromptText()) - 1));

                            case "height" -> textArea.setText("tree height : " + tree_height(Integer.valueOf(comboBox1.getPromptText()) - 1));

                            case "Depth" -> textArea.setText("tree Depth : " + tree_Depth(Root[Integer.valueOf(comboBox1.getPromptText()) - 1]));

                            case "Number of Leaves" -> textArea.setText("number of leaves : " + number_of_leaves(Integer.valueOf(comboBox1.getPromptText()) - 1));

                            case "Delete" -> {
                                delete_all_of_nodes(Root[Integer.valueOf(comboBox1.getValue()) - 1] , Integer.valueOf(comboBox1.getValue()) - 1);
                                textArea.setText("Tree number " + comboBox1.getValue() + " was cleared .");
                                comboBox1.getItems().remove(comboBox1.getValue());
                                comboBox1.setPromptText("");

                            }

                            case "Complete" ->{
                                if(Complete(Root[Integer.valueOf(comboBox1.getPromptText()) - 1],0,number_of_nodes[Integer.valueOf(comboBox1.getPromptText()) - 1]))
                                    textArea.setText("The tree is complete !");
                                else textArea.setText("The tree is not complete !");
                            }

                            case "Compare" -> {
                                if(Tree1.getText().equals("") || Tree2.getText().equals("")) textArea.setText("Please enter tree index !");
                                else{
                                    if (Compare(Integer.parseInt(Tree1.getText()) - 1 , Integer.parseInt(Tree2.getText()) - 1)) textArea.setText("these are equal .");
                                    else textArea.setText("these are not equal .");
                                }
                            }

                        }
                    }

                }
                }

        });

        Delete_button.setOnMouseClicked(event ->{
            if(comboBox1.getValue() == null) textArea.setText("Please select the tree !");
            else{
                if(Delete_field.getText().equals("")) textArea.setText("Please enter a number !");
                else{
                    delete(Double.valueOf(Delete_field.getText()) ,Integer.parseInt(comboBox1.getValue()));
                    textArea.setText("The " + Double.valueOf(Delete_field.getText()) + " was deleted .");
                }
            }
        });

    }
}
