package me.toast.engine;

import static org.lwjgl.opengl.GL11.*;

public class Line extends ObjectBase {

    private int r, g, b, x1, x2, y1, y2;

    public Line(int r, int g, int b, int x1, int y1, int x2, int y2) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        glColor3f(r, g, b);

        glBegin(GL_LINES);
            glVertex2i(x1, y1);
            glVertex2i(x2, y2);
        glEnd();
        super.render();
    }

    public int getR() { return r; }
    public void setR(int r) { this.r = r; }
    public int getG() { return g; }
    public void setG(int g) { this.g = g; }
    public int getB() { return b; }
    public void setB(int b) { this.b = b; }

    public int getX1() { return x1; }
    public void setX1(int x1) { this.x1 = x1; }
    public int getX2() { return x2; }
    public void setX2(int x2) { this.x2 = x2; }
    public int getY1() { return y1; }
    public void setY1(int y1) { this.y1 = y1; }
    public int getY2() { return y2; }
    public void setY2(int y2) { this.y2 = y2; }
}
