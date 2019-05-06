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
    private Button button;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("窗口");

        button=new Button("click me");
        button.setOnAction(e->AlertBox.display("标题","信息"));

        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,300,300);

        window.setScene(scene);
        window.show();
    }
}
