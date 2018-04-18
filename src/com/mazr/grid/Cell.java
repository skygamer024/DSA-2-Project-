package com.mazr.grid;

import java.util.HashSet;

public class Cell {

    public enum Wall {
        North,
        South,
        East,
        West
    }

    private HashSet<Wall> walls;

    public Cell() {
        walls = new HashSet<>();
        walls.add(Wall.North);
        walls.add(Wall.South);
        walls.add(Wall.East);
        walls.add(Wall.West);
    }

    public HashSet<Wall> getWalls() {
        return walls;
    }

    public void removeWall(Wall wall) {
        walls.remove(wall);
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    @Override
    public String toString() {
        String north = walls.contains(Wall.North) ? "N " : "";
        String south = walls.contains(Wall.South) ? "S " : "";
        String east = walls.contains(Wall.East) ? "E " : "";
        String west = walls.contains(Wall.West) ? "W " : "";
        return north + south + east + west;
    }

}
