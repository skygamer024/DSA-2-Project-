package com.mazr.generator;

import com.mazr.utils.Utils;

public class RecursiveDivisionGenerator extends Generator {

    public RecursiveDivisionGenerator(int rows, int columns) {
        super(rows, columns);
        grid.clear();
        stroke(0,0, rows - 1, columns - 1);
        System.out.println(grid);
    }

    private void stroke(int startRow, int startColumn, int endRow, int endColumn) {
        System.out.println(grid);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int rowLength = endRow - startRow;
        int columnLength = endColumn - startColumn;
        if (rowLength < 2 || columnLength < 2) {
            return;
        }
        int horizontalStrokeIndex = startRow + random.nextInt(rowLength);
        int verticalStrokeIndex = startColumn + random.nextInt(columnLength);
        grid.linearStroke(horizontalStrokeIndex, startColumn, horizontalStrokeIndex, endColumn);
        grid.linearStroke(startRow, verticalStrokeIndex, endRow, verticalStrokeIndex);
        grid.get(startRow + random.nextInt(rowLength),
                verticalStrokeIndex)
                .removeWall(Utils.Wall.East);
        grid.get(horizontalStrokeIndex,
                startColumn + random.nextInt(columnLength))
                .removeWall(Utils.Wall.South);
        stroke(horizontalStrokeIndex, verticalStrokeIndex, endRow, endColumn);
        stroke(horizontalStrokeIndex, startColumn, endRow, verticalStrokeIndex);
        stroke(startRow, startColumn, horizontalStrokeIndex, verticalStrokeIndex);
        stroke(startRow, verticalStrokeIndex, horizontalStrokeIndex, endColumn);
    }
}
