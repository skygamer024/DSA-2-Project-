package com.mazr.generator;

import com.mazr.grid.Grid;

import java.util.Random;

public class Generator {

    protected int rows;
    protected int columns;
    protected Grid grid;
    protected Random random;

    Generator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Grid(rows, columns);
        random = new Random();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
