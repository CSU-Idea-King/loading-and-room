package org.example.modesellection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.InputStream;
import java.net.URL;

public class RoomUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {

            //创建根容器
            Pane pane = new Pane();
            //读取图片文件，加载
            InputStream in = this.getClass().getResourceAsStream("imgs/Room4.jpg");
            if (in != null){
                Image image = new Image(in);
                ImageView imageView = new ImageView(image);
                // 将图片在容器中应用
                pane.getChildren().add(imageView);
                // 绑定图片视图的宽高属性到舞台的宽高属性，实现自动适应
                imageView.fitWidthProperty().bind(stage.widthProperty());
                imageView.fitHeightProperty().bind(stage.heightProperty());
            } else {
                System.out.println("无法加载图片");
            }

            //设置scene场景
            Scene scene = new Scene(pane,900,630);
            //创建单机模式按钮
            Button singlePlayerButton = new Button("单机模式");
            singlePlayerButton.setLayoutX(370);
            singlePlayerButton.setLayoutY(250);
//            singlePlayerButton.getStyleClass().add("button");
            singlePlayerButton.setOnAction(new ButtonnEventHandler());
            //设置背景图片

        singlePlayerButton.setOnMouseEntered(event -> {
            singlePlayerButton.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-font-size: 30px;-fx-font-weight: bold; -fx-effect: dropshadow(three-pass-box, rgba(255, 255, 255, 0.8), 10, 0, 0, 0);");
        });

        // 设置鼠标离开时恢复常规样式
        singlePlayerButton.setOnMouseExited(event -> {
            singlePlayerButton.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-font-size: 30px;-fx-font-weight: bold; -fx-effect: null;");
        });

            //创建联机游戏按键
            Button onlineGameButton = new Button("联机游戏");
            onlineGameButton.setLayoutX(370);
            onlineGameButton.setLayoutY(335);
            onlineGameButton.setOnAction(new ButtonnEventHandler());

            onlineGameButton.setOnMouseEntered(event -> {
                onlineGameButton.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-font-size: 30px;-fx-font-weight: bold; -fx-effect: dropshadow(three-pass-box, rgba(255, 255, 255, 0.8), 10, 0, 0, 0);");
            });

        onlineGameButton.setOnMouseExited(event -> {
            onlineGameButton.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-font-size: 30px;-fx-font-weight: bold; -fx-effect: null;");
        });
            pane.getChildren().addAll(singlePlayerButton, onlineGameButton);

            //设置舞台
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); // 去掉窗口边框
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}

