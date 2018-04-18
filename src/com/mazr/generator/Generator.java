package com.mazr.generator;

import com.mazr.grid.Grid;

import java.util.Random;

public class Generator {

    protected int width;
    protected int height;
    protected Grid grid;
    protected Random random;

    Generator(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Grid(width, height);
        random = new Random();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
