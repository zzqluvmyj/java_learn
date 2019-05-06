package com.myj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * javafx基本结构:窗口,场景,布局,控件
 * 处理事件的三种方式:lambda,实现接口,方法中传入方法
 */

public class HelloWorld extends Application implements EventHandler<ActionEvent> {
    public static void main(String[] args) {
        launch(args);
    }
    private Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("hello world");//得到stage,类似窗口

        button=new Button();
        button.setText("hello");

        //button.setOnAction(this);//监听事件的发生的对象,此处是自己
        //或者是以下这种,此时不需要实现接口,e的类型是EventHandler<ActionEvent类型>
        //此时直接指定的方法,不用if判断到底是哪个按钮被点击了
        button.setOnAction(e->{
            System.out.println("you click me!");
        });//lambda表达式
        //上面是下面的简写
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("you click me!");
//            }
//        });

        StackPane layout=new StackPane();//创建布局
        layout.getChildren().add(button);//布局中添加按钮

        Scene scene=new Scene(layout,300,250);//创建scene
        primaryStage.setScene(scene);//主窗口中添加scene

        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button){
            System.out.println("you click me!");
        }

    }
}
