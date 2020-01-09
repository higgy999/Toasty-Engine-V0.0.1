package me.toast.engine;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.glfw.GLFW.*;

public class Core {
    public static void main(String[] args) throws InterruptedException {
        long window = Application.init();

        while(!glfwWindowShouldClose(window)) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(0, 0, 0, 1);

            Thread.sleep(1000/60);
            glfwSwapBuffers(window);
        }

        glfwTerminate();
    }
}
