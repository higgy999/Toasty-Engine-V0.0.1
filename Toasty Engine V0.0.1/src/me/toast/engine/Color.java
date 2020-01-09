package me.toast.engine;

public class Color {

    public float red = 1;
    public float green = 1;
    public float blue = 1;
    public float alpha = 1;

    public Color(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Color(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Color RED() { return new Color(255, 0, 0); }
    public static Color ORANGE() { return new Color(255, 127, 0); }
    public static Color YELLOW() { return new Color(255, 255, 0); }
    public static Color GREEN() { return new Color(0, 255, 0); }
    public static Color BLUE() { return new Color(0, 0, 255); }
    public static Color INDIGO() { return new Color(46, 43, 95); }
    public static Color VIOLET() { return new Color(139, 0, 255); }
}
