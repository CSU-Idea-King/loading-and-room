package org.example.modesellection;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.InputStream;

public class LoadingUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // 创建一个进度条
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(900);
        progressBar.setLayoutY(500);

        //读取图片文件
        InputStream in = this.getClass().getResourceAsStream("imgs/loading3png.png");
        Image image = new Image(in);
        ImageView imageView = new ImageView(image);
        //创建一个pane
        Pane Pane = new Pane();
        Pane.getChildren().addAll(imageView,progressBar);

        // 创建一个布局容器
        //VBox root = new VBox(30);

        // 进度条添加到布局容器中
       // root.getChildren().add(progressBar);

        // 创建一个场景，并将布局容器添加到场景中
        Scene scene = new Scene(Pane, 900, 630);
       // root.setLayoutY(500);
        // 绑定图片视图的宽高属性到舞台的宽高属性，实现自动适应
//        imageView.fitWidthProperty().bind(stage.widthProperty());
//        imageView.fitHeightProperty().bind(stage.heightProperty());
//        //将图片设置为背景
//        root.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
        // 设置舞台的标题
        stage.setTitle("loading");

        // 将场景添加到舞台中
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); // 去掉窗口边框
        stage.setScene(scene);

        // 显示舞台
        stage.show();

        // 创建一个Timeline动画，用于控制进度条的变化
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(progressBar.progressProperty(), 1); // 目标值为1，即100%
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(4), keyValue); // 动画持续时间为5秒
        timeline.getKeyFrames().add(keyFrame);

        //创建一个FadeTransition 用于当前界面的淡出
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1),Pane);
        fadeOut.setFromValue(0.1);
        fadeOut.setToValue(0.0);

        //创建一个人FadeTransition 用于RoomUI界面的淡入
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1),new Pane());
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(0.1);

        //为Timeline添加一个事件处理，当动画完成时切换到RoomUI
        timeline.setOnFinished(actionEvent ->
        {
//            执行淡出动画
//            fadeOut.play();

            //启动RoomUI并执行淡入动画
//            fadeOut.setOnFinished(outEvent ->
//            {
                stage.close();
                Stage newStage = new Stage();
                RoomUI roomUI = new RoomUI();
                try {
                    roomUI.start(newStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
//            });

        });
        timeline.play(); // 开始播放动画

    }
    public static void main(String[] args) {
        launch(args);
    }
}
