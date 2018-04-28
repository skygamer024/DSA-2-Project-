package com.mazr.grid;

import com.mazr.utils.Utils;

import java.util.HashSet;

public class Cell {

    private HashSet<Utils.Wall> walls;
    private int visitCount;
    private Utils.Pair index;
    public Cell() {
        constructorHelper();
    }

    public Cell(int i, int j) {
        setIndex(i, j);
        constructorHelper();
    }

    private void constructorHelper() {
        walls = new HashSet<>();
        walls.add(Utils.Wall.South);
        walls.add(Utils.Wall.East);
        visitCount = 0;
    }

    public Utils.Pair getIndex(){
        return index;
    }

    public void setIndex(int i, int j) {
        Utils.Pair pair = new Utils.Pair(i, j);
        setIndex(pair);
    }

    private void setIndex(Utils.Pair pair) {
        index = pair;
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

    public void incrementVisitCount() {
        visitCount++;
    }

    public int getVisitCount() {
        return visitCount;
    }

    @Override
    public String toString() {
        String north = walls.contains(Utils.Wall.South) ? "S " : "";
        String east = walls.contains(Utils.Wall.East) ? "E " : "";
        return north + east;
    }

}
