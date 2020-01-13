package me.toast.engine;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle extends ObjectBase {

    private int r, g, b, x, y, width, height;

    public Rectangle(int r, int g, int b, int x, int y, int width, int height) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        glColor3f(r, g, b);

        glBegin(GL_QUADS);
            glVertex2i(x, y); //Upper-Left
            glVertex2i(width, y); //Upper-Right
            glVertex2i(width, height); //Bottom-Right
            glVertex2i(x, height); //Bottom-Left
        glEnd();
        super.render();
    }

    public int getR() { return r; }
    public void setR(int r) { this.r = r; }
    public int getG() { return g; }
    public void setG(int g) { this.g = g; }
    public int getB() { return b; }
    public void setB(int b) { this.b = b; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
