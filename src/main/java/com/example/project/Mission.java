package com.example.project;

public class Mission {
    private Plateau plateau;
    public Rover rover1;
    public Rover rover2;

    public Mission(int maxX, int maxY) {
        this.plateau = new Plateau(maxX, maxY);
    }

    private Rover placeRover(int x, int y, char dir) {
        return new Rover(x, y, dir);
    }

    private int clamp(int min, int max, int val) {
        if (val < min) {
            return min;
        } else if (val > max) {
            return max;
        }
        return val;
    }

    private Rover placeRoverFromString(String roverString) {
        String[] roverStringSplit = roverString.split(" ");

        return placeRover(
            clamp(0 ,this.plateau.maxX ,Integer.parseInt(roverStringSplit[0])),
            clamp(0 ,this.plateau.maxY ,Integer.parseInt(roverStringSplit[1])),
            roverStringSplit[2].charAt(0)
        );
    }

    public void placeFirstRoverFromString(String roverString) {
        this.rover1 = placeRoverFromString(roverString);
    }

    public void placeSecondRoverFromString(String roverString) {
        this.rover2 = placeRoverFromString(roverString);
    }
}