package com.example.fxgui2p2.split;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

// => W w W.y I  I b Ai .c O  M
public class MainT2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Lines");

        Group root = new Group();
        Scene scene = new Scene(root, 800, 150, Color.WHITE);

        Line redLine = new Line(10, 40, 610, 40);

        redLine.setStroke(Color.GREEN);
        redLine.setStrokeWidth(4);
        redLine.setStrokeLineCap(StrokeLineCap.ROUND);
        double[] doubles = {20, 10};
        double blackwidth = 10d;
        for (double d : doubles) {
//            System.out.println(d);
            redLine.getStrokeDashArray().add(d);
            redLine.getStrokeDashArray().add(blackwidth);
        }

//    redLine.setStrokeDashOffset(100);

        root.getChildren().add(redLine);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

