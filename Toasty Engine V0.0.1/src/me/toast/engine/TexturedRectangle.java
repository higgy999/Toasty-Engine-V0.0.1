package me.toast.engine;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class TexturedRectangle extends ObjectBase {

    //Texture texture;
    private int t_id;
    private int x, y, width, height;

    public TexturedRectangle(String filepath, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        /*try {
            texture = TextureLoader.getTexture("PNG", new FileInputStream(new File(filepath)));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(filepath));
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();

            int[] pixels_raw = new int[width * height * 4];
            pixels_raw = bufferedImage.getRGB(0, 0, width, height, null, 0, width);

            ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int pixel = pixels_raw[i * width + j];
                    pixels.put((byte) ((pixel >> 16) & 0xFF)); // RED
                    pixels.put((byte) ((pixel >> 8) & 0xFF));  // GREEN
                    pixels.put((byte) (pixel & 0xFF));		  // BLUE
                    pixels.put((byte) ((pixel >> 24) & 0xFF)); // ALPHA
                }
            }

            pixels.flip();

            t_id = glGenTextures();

            glBindTexture(GL_TEXTURE_2D, t_id);

            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void bind(int sampler) {
        if (sampler >= 0 && sampler <= 31) {
            glActiveTexture(GL_TEXTURE0 + sampler);
            glBindTexture(GL_TEXTURE_2D, t_id);
        }
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        glColor3f(1, 1, 1);
        bind(1);

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
        glDeleteTextures(t_id);
        super.clean();
    }
}
