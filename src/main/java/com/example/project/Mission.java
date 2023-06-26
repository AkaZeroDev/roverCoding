package com.example.project;

public class Mission {
    private Plateau plateau;
    private Rover rover1;
    private Rover rover2;

    public Mission(int maxX, int maxY) {
        this.plateau = new Plateau(maxX, maxY);
    }

    public Rover placeRover(int x, int y, char dir) {
        return new Rover(x, y, dir);
    }



}