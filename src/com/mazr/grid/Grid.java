package com.mazr.grid;

import com.mazr.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int rows;
    private int columns;

    private List<List<Cell>> list;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        list = new ArrayList<>();
        createGrid();
    }

    private void createGrid() {
        for (int i = 0; i < rows; i++) {
            List<Cell> tempList = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                tempList.add(new Cell());
            }
            list.add(tempList);
        }
    }

    public Cell get(int i, int j) {
        return list.get(i).get(j);
    }

    public void removeWall(int i, int j, Utils.Wall wall) {
        Cell cell = get(i, j);
        cell.removeWall(wall);
    }

    public void linearStroke(int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex) {
        if (startRowIndex == endRowIndex) {
            for (int i = startColumnIndex; i <= endColumnIndex; i ++) {
                get(startRowIndex, i).addWall(Utils.Wall.South);
            }
        } else {
            for (int i = startRowIndex; i <= endRowIndex; i ++) {
                get(i, startColumnIndex).addWall(Utils.Wall.East);
            }
        }
    }

    public void clear() {
        int rowCounter = 0;
        int columnCounter = 0;
        boolean isLastRow = false;
        boolean isLastColumn = false;
        for (List<Cell> tempList : list) {
            rowCounter ++;
            if (rowCounter == columns) {
                isLastRow = true;
            }
            for (Cell cell : tempList) {
                columnCounter ++;
                if (columnCounter == rows) {
                    isLastColumn = true;
                }
                if (!isLastRow) {
                    cell.removeWall(Utils.Wall.South);
                }
                if (!isLastColumn) {
                    cell.removeWall(Utils.Wall.East);
                }
            }
            columnCounter = 0;
            isLastColumn = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            sb.append(" _");
        }
        sb.append('\n');
        boolean westDone = false;
        for (List<Cell> tempList : list) {
            for (Cell cell : tempList) {
                if (!westDone) {
                    sb.append('|');
                    westDone = true;
                }
                if (cell.getWalls().contains(Utils.Wall.South)) {
                    sb.append('_');
                } else {
                    sb.append(' ');
                }
                if (cell.getWalls().contains(Utils.Wall.East)) {
                    sb.append('|');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
            westDone = false;
        }
        return sb.toString();
    }

}
