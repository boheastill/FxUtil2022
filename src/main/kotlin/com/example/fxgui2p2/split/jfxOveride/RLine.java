package com.example.fxgui2p2.split.jfxOveride;

import javafx.scene.shape.Line;

public class RLine extends Line {

    public RLine(double sx, double sy, double ex, double ey) {
        super(sx, sy, ex, ey);
    }


//    public RLine editLine() {
//        float top = 0;
//        float right = 0;
//        //line上移top
//        translate(top, right);
//        //line缩放0.5
//        int i1 = 1;
//        int i = 1;
//        scale(i, i1);
//        //line旋转45度
//        rotate(45);
//        return this;
//    }

    /*放大xy*/
    public RLine scale(int x, int y) {
        this.setScaleX(x);
        this.setScaleY(y);
        return this;
    }

    /*顺时针旋转*/
    public RLine rotate(int value) {
        this.setRotate(value);
        return this;
    }

    /*移动到上右*/
    public RLine translate(float top, float right) {
        this.setTranslateY(-top);
        this.setTranslateX(right);
//        this.setTranslateZ(0);
        return this;
    }


    /*平行线*/
    public RLine parallelLine(Line line) {
        //新建平行线
        RLine parallelLine = new RLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        //获得垂线
        RLine verticalLine =  verticalLine();


        return parallelLine;
    }
    //垂线
    public RLine verticalLine() {
        //新建垂线
        RLine verticalLine = new RLine(this.getStartX(), this.getStartY(), this.getEndX(), this.getEndY());


        return verticalLine;
    }
}
