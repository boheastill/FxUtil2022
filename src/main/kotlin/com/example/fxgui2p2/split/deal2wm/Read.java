package com.example.fxgui2p2.split.deal2wm;

import com.example.fxgui2p2.split.ing.ColorEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Read {
    //    java 读图片
    public static void main(String[] args) throws IOException {
        int cellNum = 8;
        int step = 100;
        int width = cellNum * step;
        int height = cellNum * step;

        File file = new File("66.jpg");
        BufferedImage read = ImageIO.read(file);
        Graphics2D gh = read.createGraphics();
        width = read.getWidth();
        height = read.getHeight();
        //得到绘制坏境(这张图片的笔)

        gh.setColor(ColorEnum.getColorByNum(2));//设置颜色

//    Graphics gh= (Graphics)bi.getGraphics();
        //水平线

//        gh.fillRect(0, 0, width, height);//填充整张图片(其实就是设置背景色)
        gh.setColor(Color.BLACK);//设置颜色
        //水平线
        for (int hPosition = 0; hPosition < height; hPosition += step) {
            gh.drawLine(0, hPosition, width, hPosition);

        }
        gh.setColor(Color.RED);//设置颜色
        //竖直线
        for (int wPosition = 0; wPosition < width; wPosition += step) {
            gh.drawLine(wPosition, 0, wPosition, height);
        }
        //格子色彩识别
        cellClor(0, 0, 100, 100,read);

        ImageIO.write(read, "PNG", new FileOutputStream("test2.png"));//把图片输出到指定路径

    }

    private static void cellClor(int x, int y, int w, int h,  BufferedImage read) {
        //逐个像素
        int rgb = read.getRGB(100,   2);
        Color color = new Color(16777216 + rgb);
        System.out.println(color);
    }
}
