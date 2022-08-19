package com.example.fxgui2p2.split.ing;

import java.awt.*;

public enum ColorEnum {
    black(Color.BLACK, 0), red(Color.RED, 1), green(Color.GREEN, 2), blue(Color.BLUE, 3),

    white(Color.WHITE, 11);

    private Color color;
    private int num;


    ColorEnum(Color color, int num) {
        this.color = color;
        this.num = num;
    }

    public Color getColor() {
        return color;
    }

    //通过num获取color
    public static Color getColorByNum(int num) {
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if (colorEnum.num == num) {
                return colorEnum.color;
            }
        }
        return null;
    }


}
