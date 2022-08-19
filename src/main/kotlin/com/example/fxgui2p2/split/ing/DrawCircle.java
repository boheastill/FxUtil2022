package com.example.fxgui2p2.split.ing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.fxgui2p2.split.ing.Tra.byte2Color;
import static com.example.fxgui2p2.split.ing.Tra.str2Byte;

public class DrawCircle extends JFrame {
    private final int OVAL_WIDTH = 80;                                    //圆形的宽
    private final int OVAL_HELGHT = 80;                                   //圆形的高

    public DrawCircle() {
        //调用初始化方法
        initialize();

    }

    //初始化方法
    private void initialize() {
        setSize(300, 200);                                     //设置窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    //设置窗体关闭模式
        setContentPane(new DrawPanel());                                  //设置窗体面板为绘图面板对象
        setTitle("绘图实例1");                                               //设置窗体标题
    }

    //创建绘制面板
    class DrawPanel extends JPanel {
        //重写绘制方法
        public void paint(Graphics g) {
            g.drawOval(10, 10, OVAL_WIDTH, OVAL_HELGHT);                 //绘制第1个图形
            g.drawOval(80, 10, OVAL_WIDTH, OVAL_HELGHT);                 //绘制第1个图形
            g.drawOval(150, 10, OVAL_WIDTH, OVAL_HELGHT);                //绘制第1个图形
            g.drawOval(50, 70, OVAL_WIDTH, OVAL_HELGHT);                 //绘制第1个图形
            g.drawOval(120, 70, OVAL_WIDTH, OVAL_HELGHT);                //绘制第1个图形
        }
    }

    //
//    public static void main(String[] args) {
//        new DrawCircle().setVisible(true);
//    }
    public static void main(String[] args) throws IOException {
        drawPNG();
    }

    private static void drawPNG() throws IOException {
        //1.定义图形尺寸
        int cellNum = 8;
        int step = 10;
        int width = cellNum * step;
        int height = cellNum * step;

        //获取图片缓冲区
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //得到绘制坏境(这张图片的笔)
        Graphics2D gh = bi.createGraphics();
        gh.setColor(ColorEnum.getColorByNum(2));//设置颜色

//    Graphics gh= (Graphics)bi.getGraphics();
        //水平线

        gh.setColor(Color.white);//设置颜色
        gh.fillRect(0, 0, width, height);//填充整张图片(其实就是设置背景色)
        gh.setColor(Color.black);//设置颜色

        for (int wPosition = 0; wPosition < width; wPosition += step) {
            gh.drawLine(0, wPosition, width, wPosition);
        }
        //竖直线
        for (int hPosition = 0; hPosition < height; hPosition += step) {
            gh.drawLine(hPosition, 0, hPosition, height);
        }

        Integer[] nums = byte2Color(str2Byte("张三")[0]);
        Integer[] nums2 = byte2Color(str2Byte("张三")[1]);

        writeCellFROMByte(step, gh, 0, 0, nums);
        writeCellFROMByte(step, gh, 4, 0, nums2);


        gh.setFont(new Font("Bernard MT", Font.BOLD, 18));//字体样式 字体格式 字体大小

        gh.setColor(Color.BLUE);//设置字体颜色

//        gh.drawString("测试", 40, 40);//向图片上写随机字符串

        ImageIO.write(bi, "PNG", new FileOutputStream("test.png"));//把图片输出到指定路径
    }

    private static void writeCellFROMByte(int step, Graphics2D gh, int wIdx, int hIdx, Integer[] nums) {
        lightCell(step, gh, wIdx++, hIdx, ColorEnum.getColorByNum(nums[0]));
        lightCell(step, gh, wIdx++, hIdx, ColorEnum.getColorByNum(nums[1]));
        lightCell(step, gh, wIdx++, hIdx, ColorEnum.getColorByNum(nums[2]));
        lightCell(step, gh, wIdx++, hIdx, ColorEnum.getColorByNum(nums[3]));
    }

    private static void lightCell(int step, Graphics2D gh, int wIdx, int hIdx, Color color) {
        int wPosition = wIdx * step;
        int hPosition = hIdx * step;
        gh.setColor(color);//设置颜色

        gh.fillRect(wPosition, hPosition, step, step);
    }
}