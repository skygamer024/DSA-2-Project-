package com.mazr.grid;

import com.mazr.utils.Utils;

import java.util.HashSet;

public class Cell {

    private HashSet<Utils.Wall> walls;

    public Cell() {
        walls = new HashSet<>();
        walls.add(Utils.Wall.South);
        walls.add(Utils.Wall.East);
    }

    public HashSet<Utils.Wall> getWalls() {
        return walls;
    }

    public void removeWall(Utils.Wall wall) {
        walls.remove(wall);
    }

    public void addWall(Utils.Wall wall) {
        walls.add(wall);
    }

    @Override
    public String toString() {
        String north = walls.contains(Utils.Wall.South) ? "S " : "";
        String east = walls.contains(Utils.Wall.East) ? "E " : "";
        return north + east;
    }

}
