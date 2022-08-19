package com.example.fxgui2p2.split.ing;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tra {
    private static HashMap<Integer, Integer[]> cell256map;

    public static void main(String[] args) throws IOException {

        String text = "张三";
        byte[] bytes = str2Byte(text);

        StringBuilder sb = new StringBuilder();
        byte[] bytes1 = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];

            Integer[] integers = byte2Color(b);
            byte key = color2Byte(integers);
            bytes1[i] = key;
        }
        String text2 = new String(bytes1, "utf-8");
        System.out.println(text2);
    }

    @NotNull
    static byte[] str2Byte(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("utf-8");
        return bytes;
    }

    private static Byte color2Byte(Integer[] value) {

        Integer key = getbyteValuebymap(value);
        Byte b = key.byteValue();
        return b;
    }

    static Integer[] byte2Color(byte tb) {
        //获取tb对应的十进制的值
//        int value = tb & 0xff;


        int tbInt = (int) tb;
        Integer[] integers = getCell256map().get(tbInt);
        return integers;
    }

    private static Integer getbyteValuebymap(Integer[] value) {
        for (Map.Entry<Integer, Integer[]> entry : getCell256map().entrySet()) {
            if (Arrays.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null;
    }


    public static HashMap<Integer, Integer[]> getCell256map() {
        if (cell256map != null) {
            return cell256map;
        }
        int startMapKey = -128;
        int cellState = 4;
        HashMap<Integer, Integer[]> cell256map = new HashMap<>();
        for (int c1 = 0; c1 < cellState; c1++) {
            for (int c2 = 0; c2 < cellState; c2++) {
                for (int c3 = 0; c3 < cellState; c3++) {
                    for (int c4 = 0; c4 < cellState; c4++) {
                        cell256map.put(startMapKey++, new Integer[]{c1, c2, c3, c4});
                    }
                }
            }
        }
        Tra.cell256map = cell256map;
        return getCell256map();//执行到这，说明值是刚设置的,再调一下自己，因为已经有值了，会在if那return，不会无限循环
    }
}
