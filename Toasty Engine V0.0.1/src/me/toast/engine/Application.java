package me.toast.engine;

import org.lwjgl.opengl.GL;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

public class Application {

    private static final String name = "Toasty Engine V0.0.1";
    private static int width = 1280;
    private static int height = 720;
    private static long window;

    public static long init() {
        if(!glfwInit()) {
            System.err.println("GLFW Fucked up!");
            System.exit(1);
        }

        window = glfwCreateWindow(width, height, name, 0, 0);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);

        GL.createCapabilities();
        glClearColor(0, 0, 0, 255);

        return window;
    }
}
