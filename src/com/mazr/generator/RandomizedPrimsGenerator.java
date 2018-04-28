package com.mazr.generator;

import com.mazr.grid.Cell;
import com.mazr.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RandomizedPrimsGenerator extends Generator {
    private List<Cell> neighborCells;
    private List<Cell> visitedCells;
    public RandomizedPrimsGenerator(int rows, int columns) {
        super(rows, columns);
        neighborCells = new ArrayList<>();
        visitedCells = new ArrayList<>();
        visitedCells.add(grid.get(0 ,0));
        neighborCells.add(grid.get(1,0 ));
        neighborCells.add(grid.get(0, 1));
        generate();
        System.out.println(grid);
    }

    private void generate() {
        if (visitedCells.size() == rows*columns) {
            return;
        }
        int cellIndex = random.nextInt(visitedCells.size());
        Cell cell = visitedCells.get(cellIndex);
        int randomX = cell.getIndex().x;
        int randomY = cell.getIndex().y;
        List<Cell> neighbourCells = grid.getNeighbour(randomX, randomY);
        for (Cell c: neighbourCells) {
            if (!neighborCells.contains(c) && !visitedCells.contains(c)) {
                neighborCells.add(c);
            }
        }
        for (Cell c: visitedCells) {
            neighbourCells.remove(c);
        }
        while (neighbourCells.size() == 0) {
            cellIndex = random.nextInt(visitedCells.size());
            cell = visitedCells.get(cellIndex);
            randomX = cell.getIndex().x;
            randomY = cell.getIndex().y;
            neighbourCells = grid.getNeighbour(randomX, randomY);
            for (Cell c: neighbourCells) {
                if (!neighborCells.contains(c) && !visitedCells.contains(c)) {
                    neighborCells.add(c);
                }
            }
            for (Cell c: visitedCells) {
                neighbourCells.remove(c);
            }
        }
        int neighbourIndex = random.nextInt(neighbourCells.size());
        Cell neighbour = neighbourCells.get(neighbourIndex);
        int neighbourX = neighbour.getIndex().x;
        int neighbourY = neighbour.getIndex().y;
        if (randomX - neighbourX == -1) {
            grid.removeWall(randomX, randomY, Utils.Wall.South);
        } else if (randomX - neighbourX == 1) {
            grid.removeWall(neighbourX, neighbourY, Utils.Wall.South);
        }
        if (randomY - neighbourY == -1) {
            grid.removeWall(randomX, randomY, Utils.Wall.East);
        } else if (randomY - neighbourY == 1) {
            grid.removeWall(neighbourX, neighbourY, Utils.Wall.East);
        }
        neighborCells.remove(neighbour);
        if (!visitedCells.contains(neighbour)) {
            visitedCells.add(neighbour);
        }
        generate();
    }
}

