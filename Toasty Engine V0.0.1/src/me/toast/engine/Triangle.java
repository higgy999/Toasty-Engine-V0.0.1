package me.toast.engine;

import static org.lwjgl.opengl.GL11.*;

public class Triangle extends ObjectBase {

    private int r, g, b, x1, y1, x2, y2, x3, y3;

    public Triangle(int r, int g, int b, int x1, int y1, int x2, int y2, int x3, int y3) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        glColor3f(r, g, b);

        glBegin(GL_QUADS);
            glVertex2i(x1, y1);
            glVertex2i(x2, y2);
            glVertex2i(x3, y3);
        glEnd();
        super.render();
    }

    @Override
    public void clean() {
        super.clean();
    }
}
