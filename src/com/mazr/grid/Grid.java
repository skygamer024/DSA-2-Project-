package com.mazr.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int width;
    private int height;

    private List<List<Cell>> list;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        list = new ArrayList<>();
        createGrid();
    }

    private void createGrid() {
        List<Cell> tempList = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            tempList.clear();
            for (int j = 0; j < height; j++) {
                tempList.add(new Cell());
            }
            list.add(tempList);
        }
    }

    public Cell get(int i, int j) {
        return list.get(i).get(j);
    }

    public void removeWall(int i, int j, Cell.Wall wall) {
        Cell cell = get(i, j);
        cell.removeWall(wall);
    }

    public void clear() {
        for (List<Cell> tempList : list) {
            for (Cell cell : tempList) {
                cell.removeWall(Cell.Wall.North);
                cell.removeWall(Cell.Wall.South);
                cell.removeWall(Cell.Wall.East);
                cell.removeWall(Cell.Wall.West);
            }
        }
    }

}
