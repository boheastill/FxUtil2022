package com.example.fxgui2p2.split;

import com.example.fxgui2p2.split.jfxOveride.RLine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainT extends Application {


    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        final Scene scene = new Scene(box, 300, 250);
        scene.setFill(null);

//        Line line = readLine();
        RLine line = new RLine(0, 0, 100, 300);
        //修改line 的颜色
        box.getChildren().add(line);
        RLine e = line.verticalLine();
        e.setStroke(javafx.scene.paint.Color.RED);

        box.getChildren().add(e);

        stage.setScene(scene);
        stage.show();
    }
/*
    @NotNull
    private static Line readLine() {
        float sx = 0.0f;
        float sy = 0.0f;
        float ex = 200.0f;
        float ey = 200.0f;
        Line line = drawLine(sx, sy, ex, ey);
        float top = 100;
        float right = 100;
        //line上移top
        line.setTranslateY(-top);
        line.setTranslateX(right);
        line.setTranslateZ(right);
        //line缩放0.5
        line.setScaleX(2);
        line.setScaleY(2);
        //line旋转45度
        line.setRotate(-60);
        return line;
    }

    @NotNull
    private static Line drawLine(float sx, float sy, float ex, float ey) {
        Line line = new Line();
        line.setStartX(sx);
        line.setStartY(sy);
        line.setEndX(ex);
        line.setEndY(ey);
        return line;
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}