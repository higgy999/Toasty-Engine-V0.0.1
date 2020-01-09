package me.toast.engine;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;

public class Mesh {
    private int v_id;
    private int u_id;
    private int vao;

    private float[] vertices;
    private float[] uvs;

    public Mesh(float[] vertices, float[] uvs) {
        this.vertices = vertices;
        this.uvs = uvs;

        vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);

        v_id = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, v_id);
        glBufferData(GL_ARRAY_BUFFER, CreateBuffer(vertices), GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(0, vertices.length / 3, GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        u_id = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, u_id);
        glBufferDate(GL_ARRAY_BUFFER, CreateBuffer(uvs), GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    public void render() {
        GL30.glBindVertexArray(vao);
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
    }

    public FloatBuffer CreateBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    public void clean() {
        GL30.glDeleteVertexArrays(vao);
        GL15.glDeleteBuffers(v_id);
    }
}
