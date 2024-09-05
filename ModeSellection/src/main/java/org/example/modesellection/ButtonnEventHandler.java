package org.example.modesellection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonnEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
       if(actionEvent.getSource() instanceof Button)
       {
           Button button = (Button) actionEvent.getSource();
           if(button.getText().equals("单机模式"))
           {
               //单机模式的处理逻辑
               //可以调用其他方法来实现单机模式的详细操作
           } else if (button.getText().equals("联机游戏"))
           {
               //联机游戏的处理逻辑
               //开始网络连接等相关操作
           }
       }
    }
}
