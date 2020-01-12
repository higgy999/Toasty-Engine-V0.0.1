#version 140

in vec2 position;
in vec2 texCoords;

uniform vec4 matColor;
out vec4 color;

void main() {
    gl_Position = vec4(position, 0, 1);
    color = matColor;
}