package com.myj;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Main extends Application{
    private Stage window;
    private Scene scene1,scene2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;

        Label label1=new Label("welcome to the first scene!");
        Button button1=new Button("go to scene 2");
        button1.setOnAction(e->window.setScene(scene2));

        VBox layout1=new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1=new Scene(layout1,200,600);

        Label label2=new Label("welcome to the second scene!");
        Button button2=new Button("go to scene 1");
        button2.setOnAction((e)->window.setScene(scene1));

        StackPane layout2=new StackPane();
        layout2.getChildren().add(button2);//
        scene2=new Scene(layout2,400,200);

        window.setTitle("场景切换");
        window.setScene(scene2);
        window.show();

    }
}
