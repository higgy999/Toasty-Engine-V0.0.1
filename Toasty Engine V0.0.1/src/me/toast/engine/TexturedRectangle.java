package me.toast.engine;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TexturedRectangle extends ObjectBase {

    Texture texture;
    private int x, y, width, height;

    public TexturedRectangle(String filepath, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        try {
            texture = TextureLoader.getTexture("PNG", new FileInputStream(new File(filepath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        texture.bind();

        glBegin(GL_QUADS);
            glTexCoord2f(0, 0);
            glVertex2i(x, y); //Upper-Left

            glTexCoord2f(1, 0);
            glVertex2i(width, y); //Upper-Right

            glTexCoord2f(1, 1);
            glVertex2i(width, height); //Bottom-Right

            glTexCoord2f(0, 1);
            glVertex2i(x, height); //Bottom-Left
        glEnd();

        super.render();
    }

    @Override
    public void clean() {
        //glBindTexture(GL_TEXTURE_2D, 0);
        texture.release();
        super.clean();
    }
}
