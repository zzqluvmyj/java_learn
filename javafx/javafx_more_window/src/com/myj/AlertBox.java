package com.myj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class AlertBox {
    public static void display(String title,String message){
        Stage window=new Stage();

        //阻止和其他应用中的其他窗口交互.
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label=new Label();
        label.setText("message");
        Button closeButton=new Button("close the window");
        closeButton.setOnAction(e->window.close());

        StackPane layout=new StackPane();
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene=new Scene(layout);

        window.setScene(scene);
        window.showAndWait();//和前面的阻止用户和其他窗口交互对应

    }
}
