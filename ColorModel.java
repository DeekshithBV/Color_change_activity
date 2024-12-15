package com.example.colorchange;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.util.Random;

public class ColorModel {
    private final String[] colors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };
    private final String[] colorNames = {
            "light blue", "dark blue", "mauve", "red",
            "orange", "lavender", "purple", "aqua",
            "green", "mustard", "dark gray", "pink", "light gray"
    };

    private final Random random = new Random();

    @NonNull
    public ColorData generateRandomColor(){
        int index = random.nextInt(colors.length);
        return new ColorData(colors[index], colorNames[index]);
    }
    public static class ColorData {
        private final String hexColor;
        private final String colorName;
        public ColorData(String hexColor,String colorName){
            this.hexColor = hexColor;
            this.colorName = colorName;
        }
        public String getHexColor(){
            return hexColor;
        }
        public String getColorName(){
            return colorName;
        }
        public int getColorInt(){
            return Color.parseColor(hexColor);
        }
    }
}
